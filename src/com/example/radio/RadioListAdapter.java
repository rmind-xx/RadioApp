package com.example.radio;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RadioListAdapter extends ArrayAdapter<Radio> {

	private ArrayList<Radio> items;
	private int textViewResourceId;

	static class RadioHolder {
		ImageView icon;
		TextView tvName;
	}

	public RadioListAdapter(Context context, int textViewResourceId,
			ArrayList<Radio> items) {
		super(context, textViewResourceId, items);
		this.items = items;
		this.textViewResourceId = textViewResourceId;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		RadioListItem item;

		if (null == convertView) {
			item = (RadioListItem) View.inflate(getContext(),
					textViewResourceId, null);
		} else {
			item = (RadioListItem) convertView;
		}

		item.setRadio(items.get(position));

		return item;
	}
}
