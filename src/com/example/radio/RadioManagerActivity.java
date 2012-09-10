package com.example.radio;

import android.app.Activity;

public class RadioManagerActivity extends Activity {

	public RadioManagerActivity() {
		super();
	}

	protected RadioApplication getApp() {
		return (RadioApplication) getApplication();
	}

}
