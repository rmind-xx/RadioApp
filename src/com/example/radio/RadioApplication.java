package com.example.radio;

import java.util.ArrayList;

import static com.example.radio.RadioSQLiteOpenHelper.*;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RadioApplication extends Application {

	private SQLiteDatabase database;
	private ArrayList<Radio> currentRadios;

	@Override
	public void onCreate() {
		super.onCreate();

		RadioSQLiteOpenHelper helper = new RadioSQLiteOpenHelper(this);
		database = helper.getWritableDatabase();
		if (null == currentRadios) {
			loadData();
		}

	}

	@Override
	public void onTerminate() {
		database.close();
		super.onTerminate();
	}

	public void setCurrentRadios(ArrayList<Radio> currentRadios) {
		this.currentRadios = currentRadios;
	}

	public ArrayList<Radio> getCurrentRadios() {
		return currentRadios;
	}

	private void loadData() {
		currentRadios = new ArrayList<Radio>();
		Cursor tasksCursor = database.query(RADIO_TABLE, new String[] {
				RADIO_ID, RADIO_NAME, RADIO_URL, RADIO_IMAGE }, null, null,
				null, null, RADIO_NAME);
		tasksCursor.moveToFirst();
		Radio r;
		if (!tasksCursor.isAfterLast()) {
			do {

				int id = tasksCursor.getInt(0);
				int image = tasksCursor.getInt(3);
				String name = tasksCursor.getString(1);
				String url = tasksCursor.getString(2);

				r = new Radio(id, name, url, image);

				currentRadios.add(r);

			} while (tasksCursor.moveToNext());
		}

		tasksCursor.close();

	}

	public void addRadio(Radio r) {

		assert (null != r);

		ContentValues values = new ContentValues();
		values.put(RADIO_NAME, r.getName());
		values.put(RADIO_URL, r.getUrl());
		values.put(RADIO_IMAGE, r.getImg());

		r.setId(database.insert(RADIO_TABLE, null, values));

		currentRadios.add(r);
	}

}
