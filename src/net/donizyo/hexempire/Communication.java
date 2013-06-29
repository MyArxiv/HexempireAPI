package net.donizyo.hexempire;

public interface Communication {
	public static final long HEXLEN = 4l;
	public static final long MAXLEN = HEXLEN * 8l;
	public static final long MAXCOMMAND = 0xFFFF_FFFFl;
	public static final long CMDEXP = 0x120F_4DB3l;

	public static final long FLAG_NIDFROM                            = 0xF000_0000l;

	public static final long QUERY_SERVER_FALSE                      = 0x0000_0001l;
	public static final long QUERY_SERVER_TRUE                       = 0x0000_0002l;

	public static final long QUERY_CLIENT                            = 0x0000_0001l;
	public static final long QUERY_SERVER                            = 0x0000_0002l;
	public static final long INFO_GRID                               = 0x0000_0003l;
	public static final long INFO_MOVE                               = 0x0000_0004l;
	public static final long CHAT_NEW                                = 0x0000_000Cl;

		public static final long QUERY_CLIENT_STARTGAME              = 0x0000_0010l  | QUERY_CLIENT;
		public static final long QUERY_CLIENT_JOINGAME               = 0x0000_0020l  | QUERY_CLIENT;
		public static final long QUERY_CLIENT_MAKEPEACE              = 0x0000_0030l  | QUERY_CLIENT;
		public static final long QUERY_CLIENT_SURRENDER              = 0x0000_0040l  | QUERY_CLIENT;
		public static final long QUERY_CLIENT_SURRENDERTO            = 0x0000_0080l  | QUERY_CLIENT;
		public static final long QUERY_CLIENT_MOVETROOP              = 0x0000_0050l  | QUERY_CLIENT;
		public static final long QUERY_CLIENT_QUERYGRID              = 0x0000_0060l  | QUERY_CLIENT;
		public static final long QUERY_CLIENT_ENDTURN                = 0x0000_0070l  | QUERY_CLIENT;
		public static final long QUERY_CLIENT_PAUSE                  = 0x0000_0090l  | QUERY_CLIENT;

		public static final long QUERY_SERVER_STARTGAME              = 0x0000_0010l  | QUERY_SERVER;
		public static final long QUERY_SERVER_JOINGAME               = 0x0000_0020l  | QUERY_SERVER;
		public static final long QUERY_SERVER_MAKEPEACE              = 0x0000_0030l  | QUERY_SERVER;
		public static final long QUERY_SERVER_SURRENDER              = 0x0000_0040l  | QUERY_SERVER;
		public static final long QUERY_SERVER_MOVETROOP              = 0x0000_0050l  | QUERY_SERVER;

			public static final long QUERY_CLIENT_STARTGAME_NID      = FLAG_NIDFROM | QUERY_CLIENT_STARTGAME;
			public static final long QUERY_CLIENT_JOINGAME_GAMEID    = 0x0000_0F00l  | QUERY_CLIENT_JOINGAME;
			public static final long QUERY_CLIENT_MAKEPEACE_TO       = 0x0000_0F00l  | QUERY_CLIENT_MAKEPEACE;
			public static final long QUERY_CLIENT_MAKEPEACE_FROM     = FLAG_NIDFROM | QUERY_CLIENT_MAKEPEACE;
			public static final long QUERY_CLIENT_SURRENDER_NID      = FLAG_NIDFROM | QUERY_CLIENT_SURRENDER;
			public static final long QUERY_CLIENT_SURRENDERTO_FROM   = FLAG_NIDFROM | QUERY_CLIENT_SURRENDERTO;
			public static final long QUERY_CLIENT_SURRENDERTO_TO     = 0x0000_F000l  | QUERY_CLIENT_SURRENDERTO;
			public static final long QUERY_CLIENT_MOVETROOP_FROM     = 0x0000_FF00l  | QUERY_CLIENT_MOVETROOP;
			public static final long QUERY_CLIENT_MOVETROOP_TO       = 0x00FF_0000l  | QUERY_CLIENT_MOVETROOP;
			public static final long QUERY_CLIENT_MOVETROOP_NID      = FLAG_NIDFROM | QUERY_CLIENT_MOVETROOP;
			public static final long QUERY_CLEINT_QUERYGRID_GID      = 0x0000_FF00l  | QUERY_CLIENT_QUERYGRID;
			public static final long QUERY_CLIENT_QUERYGRID_NID      = FLAG_NIDFROM | QUERY_CLIENT_QUERYGRID;
			public static final long QUERY_CLIENT_ENDTURN_NID        = FLAG_NIDFROM | QUERY_CLIENT_ENDTURN;

			public static final long QUERY_SERVER_STARTGAME_RETURN   = 0x0000_0F00l  | QUERY_SERVER_STARTGAME;
			public static final long QUERY_SERVER_JOINGAME_NID       = FLAG_NIDFROM | QUERY_SERVER_JOINGAME;
			public static final long QUERY_SERVER_MAKEPEACE_RETURN   = 0x000F_0000l  | QUERY_SERVER_MAKEPEACE;

		public static final long INFO_GRID_GID                       = 0x0000_0FF0l  | INFO_GRID;
		public static final long INFO_GRID_NID                       = FLAG_NIDFROM | INFO_GRID;
		public static final long INFO_GRID_TN                        = 0x00FF_0000l  | INFO_GRID;
		public static final long INFO_GRID_TM                        = 0xFF00_0000l  | INFO_GRID;

		public static final long INFO_MOVE_NID                       = FLAG_NIDFROM | INFO_MOVE;
		public static final long INFO_MOVE_MOVELEFT                  = 0x0000_0F00l  | INFO_MOVE;

		public static final long CHAT_NEW_BEGIN                      = 0x0000_0010l  | CHAT_NEW;
		public static final long CHAT_NEW_SIZE                       = 0x0000_FF00l  | CHAT_NEW_BEGIN;
		public static final long CHAT_NEW_END                        = 0x0000_0020l  | CHAT_NEW;
}

//public static final long CHAT_PUBLIC                             = 0x0000_000A;
//	public static final long CHAT_PUBLIC_FROM                    = FLAG_NIDFROM | CHAT_PUBLIC;
//	public static final long CHAT_PUBLIC_CHAR                    = 0xFFFF_0000  | CHAT_PUBLIC;
//public static final long CHAT_PRIVATE                            = 0x0000_000B;
//	public static final long CHAT_PRIVATE_TO                     = 0x0000_00F0  | CHAT_PRIVATE;
//	public static final long CHAT_PRIVATE_FROM                   = FLAG_NIDFROM | CHAT_PRIVATE;
//	public static final long CHAT_PRIVATE_CHAR                   = 0xFFFF_0000  | CHAT_PRIVATE;