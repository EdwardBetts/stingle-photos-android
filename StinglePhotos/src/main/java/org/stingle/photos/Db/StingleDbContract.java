package org.stingle.photos.Db;

import android.provider.BaseColumns;

public class StingleDbContract {

	private StingleDbContract() {}

	/* Inner class that defines the table contents */
	public static class Columns implements BaseColumns {
		public static final String TABLE_NAME_FILES = "files";
		public static final String TABLE_NAME_TRASH = "trash";
		public static final String TABLE_NAME_ALBUMS = "albums";
		public static final String TABLE_NAME_ALBUM_FILES = "album_files";
		public static final String TABLE_NAME_SHARES = "shares";

		public static final String COLUMN_NAME_FILENAME = "filename";
		public static final String COLUMN_NAME_IS_LOCAL = "is_local";
		public static final String COLUMN_NAME_IS_REMOTE = "is_remote";
		public static final String COLUMN_NAME_VERSION = "version";
		public static final String COLUMN_NAME_REUPLOAD = "reupload";
		public static final String COLUMN_NAME_DATE_CREATED = "date_created";
		public static final String COLUMN_NAME_DATE_MODIFIED = "date_modified";
		public static final String COLUMN_NAME_HEADERS = "headers";
		public static final String COLUMN_NAME_DATA = "data";
		public static final String COLUMN_NAME_ALBUM_PK = "album_pk";
		public static final String COLUMN_NAME_ALBUM_ID = "album_id";
		public static final String COLUMN_NAME_TO_USER_ID = "to_user_id";
		public static final String COLUMN_NAME_FROM_USER_ID = "from_user_id";
		public static final String COLUMN_NAME_TO_DATA = "to_data";
		public static final String COLUMN_NAME_FROM_DATA = "from_data";
	}

	public static final String SQL_CREATE_FILES =
			"CREATE TABLE " + Columns.TABLE_NAME_FILES + " (" +
					Columns._ID + " INTEGER PRIMARY KEY," +
					Columns.COLUMN_NAME_FILENAME + " TEXT NOT NULL UNIQUE," +
					Columns.COLUMN_NAME_IS_LOCAL + " INTEGER," +
					Columns.COLUMN_NAME_IS_REMOTE + " INTEGER," +
					Columns.COLUMN_NAME_VERSION + " INTEGER," +
					Columns.COLUMN_NAME_REUPLOAD + " INTEGER," +
					Columns.COLUMN_NAME_DATE_CREATED + " INTEGER," +
					Columns.COLUMN_NAME_DATE_MODIFIED + " INTEGER, " +
					Columns.COLUMN_NAME_HEADERS + " TEXT" +
					")";

	public static final String SQL_DELETE_FILES =
			"DROP TABLE IF EXISTS " + Columns.TABLE_NAME_FILES;

	public static final String SQL_FILES_FN_INDEX =
			"CREATE UNIQUE INDEX filename ON "+ Columns.TABLE_NAME_FILES+" ("+ Columns.COLUMN_NAME_FILENAME+")";
	public static final String SQL_FILES_LR_INDEX =
			"CREATE INDEX localremote ON "+ Columns.TABLE_NAME_FILES+" ("+ Columns.COLUMN_NAME_IS_LOCAL+", "+ Columns.COLUMN_NAME_IS_REMOTE+")";


	public static final String SQL_CREATE_TRASH =
			"CREATE TABLE " + Columns.TABLE_NAME_TRASH + " (" +
					Columns._ID + " INTEGER PRIMARY KEY," +
					Columns.COLUMN_NAME_FILENAME + " TEXT NOT NULL UNIQUE," +
					Columns.COLUMN_NAME_IS_LOCAL + " INTEGER," +
					Columns.COLUMN_NAME_IS_REMOTE + " INTEGER," +
					Columns.COLUMN_NAME_VERSION + " INTEGER," +
					Columns.COLUMN_NAME_REUPLOAD + " INTEGER," +
					Columns.COLUMN_NAME_DATE_CREATED + " INTEGER," +
					Columns.COLUMN_NAME_DATE_MODIFIED + " INTEGER, " +
					Columns.COLUMN_NAME_HEADERS + " TEXT" +
					")";

	public static final String SQL_TRASH_FN_INDEX =
			"CREATE UNIQUE INDEX trash_filename ON "+ Columns.TABLE_NAME_TRASH+" ("+ Columns.COLUMN_NAME_FILENAME+")";
	public static final String SQL_TRASH_LR_INDEX =
			"CREATE INDEX trash_localremote ON "+ Columns.TABLE_NAME_TRASH+" ("+ Columns.COLUMN_NAME_IS_LOCAL+", "+ Columns.COLUMN_NAME_IS_REMOTE+")";

	public static final String SQL_DELETE_TRASH =
			"DROP TABLE IF EXISTS " + Columns.TABLE_NAME_TRASH;


	public static final String SQL_CREATE_ALBUMS =
			"CREATE TABLE " + Columns.TABLE_NAME_ALBUMS + " (" +
					Columns._ID + " INTEGER PRIMARY KEY," +
					Columns.COLUMN_NAME_ALBUM_ID + " TEXT NOT NULL UNIQUE," +
					Columns.COLUMN_NAME_DATA + " TEXT NOT NULL," +
					Columns.COLUMN_NAME_ALBUM_PK + " TEXT NOT NULL, " +
					Columns.COLUMN_NAME_DATE_CREATED + " INTEGER," +
					Columns.COLUMN_NAME_DATE_MODIFIED + " INTEGER" +
					")";
	public static final String SQL_CREATE_ALBUMS_AID_INDEX =
					"CREATE UNIQUE INDEX a_album_id ON "+ Columns.TABLE_NAME_ALBUMS+" ("+ Columns.COLUMN_NAME_ALBUM_ID+")";

	public static final String SQL_DELETE_ALBUMS =
			"DROP TABLE IF EXISTS " + Columns.TABLE_NAME_ALBUMS;

	public static final String SQL_CREATE_ALBUM_FILES =
			"CREATE TABLE " + Columns.TABLE_NAME_ALBUM_FILES + " (" +
					Columns._ID + " INTEGER PRIMARY KEY," +
					Columns.COLUMN_NAME_ALBUM_ID + " TEXT NOT NULL," +
					Columns.COLUMN_NAME_FILENAME + " TEXT NOT NULL," +
					Columns.COLUMN_NAME_IS_LOCAL + " INTEGER," +
					Columns.COLUMN_NAME_IS_REMOTE + " INTEGER," +
					Columns.COLUMN_NAME_VERSION + " INTEGER," +
					Columns.COLUMN_NAME_REUPLOAD + " INTEGER," +
					Columns.COLUMN_NAME_HEADERS + " TEXT, " +
					Columns.COLUMN_NAME_DATE_CREATED + " INTEGER, " +
					Columns.COLUMN_NAME_DATE_MODIFIED + " INTEGER" +
					")";
	public static final String SQL_CREATE_ALBUM_FILES_AID_INDEX =
			"CREATE INDEX af_album_id ON "+ Columns.TABLE_NAME_ALBUM_FILES+" ("+ Columns.COLUMN_NAME_ALBUM_ID+")";

	public static final String SQL_DELETE_ALBUM_FILES =
			"DROP TABLE IF EXISTS " + Columns.TABLE_NAME_ALBUM_FILES;

	public static final String SQL_CREATE_SHARES =
			"CREATE TABLE " + Columns.TABLE_NAME_SHARES + " (" +
					Columns._ID + " INTEGER PRIMARY KEY," +
					Columns.COLUMN_NAME_ALBUM_ID + " TEXT NOT NULL," +
					Columns.COLUMN_NAME_TO_USER_ID + " INTEGER," +
					Columns.COLUMN_NAME_FROM_USER_ID + " INTEGER," +
					Columns.COLUMN_NAME_TO_DATA + " TEXT NOT NULL," +
					Columns.COLUMN_NAME_FROM_DATA + " TEXT NOT NULL," +
					Columns.COLUMN_NAME_DATE_CREATED + " INTEGER," +
					Columns.COLUMN_NAME_DATE_MODIFIED + " INTEGER" +
					")";
	public static final String SQL_CREATE_SHARES_AID_INDEX =
			"CREATE INDEX s_album_id ON "+ Columns.TABLE_NAME_SHARES+" ("+ Columns.COLUMN_NAME_ALBUM_ID+")";

	public static final String SQL_DELETE_SHARES =
			"DROP TABLE IF EXISTS " + Columns.TABLE_NAME_SHARES;
}
