package com.example.radio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RadioSQLiteOpenHelper extends SQLiteOpenHelper {

	public static final int VERSION = 1;
	public static final String DB_NAME = "radios_new_db.sqlite";
	public static final String RADIO_TABLE = "radio";
	public static final String RADIO_ID = "id";
	public static final String RADIO_NAME = "name";
	public static final String RADIO_URL = "url";
	public static final String RADIO_IMAGE = "img";
	public static final String CATEGORY_TABLE = "category";

	public RadioSQLiteOpenHelper(Context context) {
		super(context, DB_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		dropAndCreate(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	protected void dropAndCreate(SQLiteDatabase db) {
		db.execSQL("drop table if exists " + RADIO_TABLE + ";");
		db.execSQL("drop table if exists " + CATEGORY_TABLE + ";");
		createTables(db);
		insertData(db);
	}

	protected void createTables(SQLiteDatabase db) {
		db.execSQL("create table " + RADIO_TABLE + " (" + RADIO_ID
				+ " integer primary key autoincrement not null," + RADIO_NAME
				+ " text," + RADIO_URL + " text," + RADIO_IMAGE + " integer );");
	}
	
	protected void insertData(SQLiteDatabase db){
		db.execSQL("insert into " + RADIO_TABLE + " (" + RADIO_NAME + ", " + RADIO_URL + ") values ('M-1', 'http://stream.m-1.fm:80/m1/aacp');");
	}

}
