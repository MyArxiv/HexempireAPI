package net.donizyo.hexempire;

public interface Communication {
	public static final int HEXLEN = 4;
	public static final int MAXLEN = HEXLEN * 8;
	public static final int MAXCOMMAND = 0xFFFF_FFFF;
	public static final int CMDEXP = 0x120F_4DB3;

	public static final int FLAG_NIDFROM                            = 0xF000_0000;

	public static final int QUERY_SERVER_FALSE                      = 0x0000_0001;
	public static final int QUERY_SERVER_TRUE                       = 0x0000_0002;

	public static final int QUERY_CLIENT                            = 0x0000_0001;
	public static final int QUERY_SERVER                            = 0x0000_0002;
	public static final int INFO_GRID                               = 0x0000_0003;
	public static final int INFO_MOVE                               = 0x0000_0004;
	public static final int CHAT_NEW                                = 0x0000_000C;

		public static final int QUERY_CLIENT_STARTGAME              = 0x0000_0010  | QUERY_CLIENT;
		public static final int QUERY_CLIENT_JOINGAME               = 0x0000_0020  | QUERY_CLIENT;
		public static final int QUERY_CLIENT_MAKEPEACE              = 0x0000_0030  | QUERY_CLIENT;
		public static final int QUERY_CLIENT_SURRENDER              = 0x0000_0040  | QUERY_CLIENT;
		public static final int QUERY_CLIENT_SURRENDERTO            = 0x0000_0080  | QUERY_CLIENT;
		public static final int QUERY_CLIENT_MOVETROOP              = 0x0000_0050  | QUERY_CLIENT;
		public static final int QUERY_CLIENT_QUERYGRID              = 0x0000_0060  | QUERY_CLIENT;
		public static final int QUERY_CLIENT_ENDTURN                = 0x0000_0070  | QUERY_CLIENT;
		public static final int QUERY_CLIENT_PAUSE                  = 0x0000_0090  | QUERY_CLIENT;

		public static final int QUERY_SERVER_STARTGAME              = 0x0000_0010  | QUERY_SERVER;
		public static final int QUERY_SERVER_JOINGAME               = 0x0000_0020  | QUERY_SERVER;
		public static final int QUERY_SERVER_MAKEPEACE              = 0x0000_0030  | QUERY_SERVER;
		public static final int QUERY_SERVER_SURRENDER              = 0x0000_0040  | QUERY_SERVER;
		public static final int QUERY_SERVER_MOVETROOP              = 0x0000_0050  | QUERY_SERVER;

			public static final int QUERY_CLIENT_STARTGAME_NID      = FLAG_NIDFROM | QUERY_CLIENT_STARTGAME;
			public static final int QUERY_CLIENT_JOINGAME_GAMEID    = 0x0000_0F00  | QUERY_CLIENT_JOINGAME;
			public static final int QUERY_CLIENT_MAKEPEACE_TO       = 0x0000_0F00  | QUERY_CLIENT_MAKEPEACE;
			public static final int QUERY_CLIENT_MAKEPEACE_FROM     = FLAG_NIDFROM | QUERY_CLIENT_MAKEPEACE;
			public static final int QUERY_CLIENT_SURRENDER_NID      = FLAG_NIDFROM | QUERY_CLIENT_SURRENDER;
			public static final int QUERY_CLIENT_SURRENDERTO_FROM   = FLAG_NIDFROM | QUERY_CLIENT_SURRENDERTO;
			public static final int QUERY_CLIENT_SURRENDERTO_TO     = 0x0000_F000  | QUERY_CLIENT_SURRENDERTO;
			public static final int QUERY_CLIENT_MOVETROOP_FROM     = 0x0000_FF00  | QUERY_CLIENT_MOVETROOP;
			public static final int QUERY_CLIENT_MOVETROOP_TO       = 0x00FF_0000  | QUERY_CLIENT_MOVETROOP;
			public static final int QUERY_CLIENT_MOVETROOP_NID      = FLAG_NIDFROM | QUERY_CLIENT_MOVETROOP;
			public static final int QUERY_CLEINT_QUERYGRID_GID      = 0x0000_FF00  | QUERY_CLIENT_QUERYGRID;
			public static final int QUERY_CLIENT_QUERYGRID_NID      = FLAG_NIDFROM | QUERY_CLIENT_QUERYGRID;
			public static final int QUERY_CLIENT_ENDTURN_NID        = FLAG_NIDFROM | QUERY_CLIENT_ENDTURN;

			public static final int QUERY_SERVER_STARTGAME_RETURN   = 0x0000_0F00  | QUERY_SERVER_STARTGAME;
			public static final int QUERY_SERVER_JOINGAME_NID       = FLAG_NIDFROM | QUERY_SERVER_JOINGAME;
			public static final int QUERY_SERVER_MAKEPEACE_RETURN   = 0x000F_0000  | QUERY_SERVER_MAKEPEACE;

		public static final int INFO_GRID_GID                       = 0x0000_0FF0  | INFO_GRID;
		public static final int INFO_GRID_NID                       = FLAG_NIDFROM | INFO_GRID;
		public static final int INFO_GRID_TN                        = 0x00FF_0000  | INFO_GRID;
		public static final int INFO_GRID_TM                        = 0xFF00_0000  | INFO_GRID;

		public static final int INFO_MOVE_NID                       = FLAG_NIDFROM | INFO_MOVE;
		public static final int INFO_MOVE_MOVELEFT                  = 0x0000_0F00  | INFO_MOVE;

		public static final int CHAT_NEW_BEGIN                      = 0x0000_0010  | CHAT_NEW;
		public static final int CHAT_NEW_SIZE                       = 0x0000_FF00  | CHAT_NEW_BEGIN;
		public static final int CHAT_NEW_END                        = 0x0000_0020  | CHAT_NEW;
}

//public static final int CHAT_PUBLIC                             = 0x0000_000A;
//	public static final int CHAT_PUBLIC_FROM                    = FLAG_NIDFROM | CHAT_PUBLIC;
//	public static final int CHAT_PUBLIC_CHAR                    = 0xFFFF_0000  | CHAT_PUBLIC;
//public static final int CHAT_PRIVATE                            = 0x0000_000B;
//	public static final int CHAT_PRIVATE_TO                     = 0x0000_00F0  | CHAT_PRIVATE;
//	public static final int CHAT_PRIVATE_FROM                   = FLAG_NIDFROM | CHAT_PRIVATE;
//	public static final int CHAT_PRIVATE_CHAR                   = 0xFFFF_0000  | CHAT_PRIVATE;