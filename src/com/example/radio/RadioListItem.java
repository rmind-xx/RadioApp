package com.example.radio;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RadioListItem extends LinearLayout {

	private Radio radio;
	private TextView tvName;
	private ImageView icon;

	public RadioListItem(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		tvName = (TextView) findViewById(android.R.id.text1);
	}

	public void setRadio(Radio radio) {
		this.radio = radio;
		tvName.setText(radio.getName());
		// icon.setImageResource(radio.getImg());
	}

	public Radio getRadio() {
		return radio;
	}

}
