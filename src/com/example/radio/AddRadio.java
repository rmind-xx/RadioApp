package com.example.radio;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddRadio extends RadioManagerActivity implements OnClickListener,
		TextWatcher {

	private Button btAdd, btCancel;
	private EditText etName, etUrl;
	private boolean changesPending;
	private AlertDialog unsavedChangesDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_radio);

		init();
	}

	private void init() {

		btAdd = (Button) findViewById(R.id.bt_radio_add);
		btCancel = (Button) findViewById(R.id.bt_radio_add_cancel);
		btAdd.setOnClickListener(this);
		btCancel.setOnClickListener(this);

		etName = (EditText) findViewById(R.id.et_radio_add_name);
		etUrl = (EditText) findViewById(R.id.et_radio_add_url);
		etName.addTextChangedListener(this);
		etUrl.addTextChangedListener(this);

	}

	protected void addRadio() {

		String name = etName.getText().toString();
		String url = etUrl.getText().toString();

		Radio r = new Radio();
		r.setName(name);
		r.setUrl(url);

		getApp().addRadio(r);

		finish();

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_radio_add:
			addRadio();
			break;
		case R.id.bt_radio_add_cancel:
			cancel();
			break;
		}

	}

	private void cancel() {
		if (changesPending) {

		} else {
			finish();
		}

	}

	public void afterTextChanged(Editable arg0) {
		
	}

	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
	}

	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		changesPending = true;
	}

}
