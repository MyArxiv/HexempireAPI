package net.donizyo.hexempire;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
//<?xml-stylesheet type="text/xsl" href="protocol.xsl"?>
@XmlRootElement
public class Protocols {
	private static Marshaller marshaller;
	private static Unmarshaller unmarshaller;

	static {
		initManager();
	}

	private static void initManager() {
		try {
			JAXBContext context = JAXBContext.newInstance(Protocols.class);
			marshaller = context.createMarshaller();
			unmarshaller = context.createUnmarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@XmlElement
	private final Set<Instruction> instructions = new HashSet<>();

	@XmlElement
	private int size = 0;

	@XmlType
	public static class Instruction {
		public static class InstructionEntry {
			private final int id;
			private String name;
			public InstructionEntry(String entryName, int id) {
				this.id = id;
				this.name = entryName;
			}
			@XmlElement
			public int getId() {
				return id;
			}
			@XmlElement
			public String getName() {
				return name;
			}
		}
		@XmlElement
		private final int id;
		@XmlElement
		private final String name;
		@XmlElement
		private final InstructionEntry[] entries;
		
		public Instruction() {
			this(null, -1, new String[4]);
		}

		public Instruction(String instructionName, int id, String... strings) {
			this.id = id;
			name = instructionName;
			if (strings.length == 4) {
				entries = new InstructionEntry[4];
				for (int i = 0; i < 4; i++) {
					entries[i] = new InstructionEntry(strings[i], i);
				}
			}
			else
				entries = null;
		}

		public String getName() {
			return name;
		}

		public int getId() {
			return id;
		}

		public int getIndex(String entryName) {
			for (int i = 0; i < 4; i++) {
				if (entries[i].equals(entryName))
					return i;
			}
			return -1;
		}

		public void set(int index, String entryName) {
			entries[index].name = entryName;
		}

		public String toString() {
			return "Instruction " + name + "[" + entries[0] + ", " + entries[1] + ", " + entries[2] + ", " + entries[3] + "].";
		}
	}

	public Instruction getInstruction(String name) {
		for (Iterator<Instruction> itr = instructions.iterator(); itr.hasNext();) {
			Instruction instruction = itr.next();
			if (instruction.name.equals(name))
				return instruction;
		}
		return null;
	}

	public boolean add(String instructionName, String... entries) {
		synchronized (instructions) {
			return instructions.add(new Instruction(instructionName, instructions.size(), entries));
		}
	}

	public void exportToXml(FileOutputStream os) throws JAXBException {
		if (instructions.isEmpty())
			return;
		size = instructions.size();
		System.out.println("Exporting to xml...");
		marshaller.marshal(this, os);
	}

	public void exportToXml(String path) throws FileNotFoundException, JAXBException {
		exportToXml(new FileOutputStream(path));
	}

	public static Protocols importFromXml(FileInputStream is) throws JAXBException {
		System.out.println("Importing from xml...");
		Protocols manager = (Protocols) unmarshaller.unmarshal(is);
		for (Iterator<Instruction> itr = manager.instructions.iterator(); itr.hasNext();) {
			System.out.println(itr.next());
		}
		return manager;
	}

	public static Protocols importFromXml(String path) throws FileNotFoundException, JAXBException {
		return importFromXml(new FileInputStream(path));
	}

	public int getEntryId(String intructionName, String entryName) {
		return getInstruction(intructionName).getIndex(entryName);
	}

	public static void main(String[] args) {
		Protocols manager = new Protocols();
		Class<?> cls1 = Communication.class;
		for (Field f : cls1.getFields()) {
			manager.add(f.getName(), "entry1", "entry2", "entry3", "entry4");
		}
		try {
			manager.exportToXml("protocol.xml");
		} catch (FileNotFoundException | JAXBException e) {
			e.printStackTrace();
		}
	}
}
