package net.donizyo.hexempire;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
public class ProtocolManager {
	private static Marshaller marshaller;
	private static Unmarshaller unmarshaller;

	static {
		initManager();
	}

	private static void initManager() {
		try {
			JAXBContext context = JAXBContext.newInstance(ProtocolManager.class);
			marshaller = context.createMarshaller();
			unmarshaller = context.createUnmarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@XmlElement
	private final Set<Instruction> instructions = new HashSet<>();

	@XmlType
	public static class Instruction {
		public static class InstructionEntry {
			@XmlAttribute
			private final int id;
			@XmlElement
			private final String name;
			public InstructionEntry(String entryName, int id) {
				this.id = id;
				this.name = entryName;
			}
			public int getId() {
				return id;
			}
			public String getName() {
				return name;
			}
		}
		@XmlAttribute
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

	public boolean add(Instruction instruction) {
		return instructions.add(instruction);
	}

	public boolean add(String instructionName, String... entries) {
		synchronized (instructions) {
			return add(new Instruction(instructionName, instructions.size(), entries));
		}
	}

	public void exportToXml(FileOutputStream os) throws JAXBException {
		System.out.println("Exporting to xml...");
		marshaller.marshal(this, os);
	}

	public void exportToXml(String path) throws FileNotFoundException, JAXBException {
		exportToXml(new FileOutputStream(path));
	}

	public static ProtocolManager importFromXml(FileInputStream is) throws JAXBException {
		System.out.println("Importing from xml...");
		ProtocolManager manager = (ProtocolManager) unmarshaller.unmarshal(is);
		for (Iterator<Instruction> itr = manager.instructions.iterator(); itr.hasNext();) {
			System.out.println(itr.next());
		}
		return manager;
	}

	public static ProtocolManager importFromXml(String path) throws FileNotFoundException, JAXBException {
		return importFromXml(new FileInputStream(path));
	}

	public int getEntryId(String intructionName, String entryName) {
		return getInstruction(intructionName).getIndex(entryName);
	}

	public static void main(String[] args) {
		ProtocolManager manager = new ProtocolManager();
		manager.add("GridInfo", "gid", "nid", "n", "m");
		manager.add("QueryGrid", "gid", null, null, null);
		try {
			manager.exportToXml("protocol.xml");
		} catch (FileNotFoundException | JAXBException e) {
			e.printStackTrace();
		}
	}
}
