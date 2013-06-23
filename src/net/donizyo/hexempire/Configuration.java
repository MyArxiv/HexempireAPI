package net.donizyo.hexempire;

public interface Configuration {
	public static final int GRIDTYPE_SEA     = 0b0000;
	public static final int GRIDTYPE_LAND    = 0b0001;
	public static final int GRIDTYPE_PORT    = 0b0011;
	public static final int GRIDTYPE_CITY    = 0b0101;
	public static final int GRIDTYPE_CAPITAL = 0b1001;

	public static final int LIM_ROW = 22;
	public static final int LIM_COL = 10;
	public static final int LIM_GRID = LIM_ROW * LIM_COL;

	public static final int LIM_MOVE = 5;
	public static final int LIM_TROOP_NUMBER = 99;
	public static final int LIM_TROOP_MORALE = 99;

	public static final int LIM_NATION = 4;

	public static final int LIM_NEIGHBOR = 18;

	public static final int RECRUIT_CITY = 5;
	public static final int RECRUIT_CAPITAL = 10;

	public static final int CAP1 = 20;
	public static final int CAP2 = 39;
	public static final int CAP3 = 180;
	public static final int CAP4 = 199;
}
