package com.example.radio;

import com.spoledge.aacdecoder.MultiPlayer;
import com.spoledge.aacdecoder.PlayerCallback;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class Main extends ListActivity implements OnClickListener {

	private MultiPlayer aacPlayer;

	private RadioApplication app;

	private RadioListAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.list_radio);
		init();

	}

	@Override
	protected void onResume() {
		super.onResume();
		adapter.notifyDataSetChanged();
	}

	private void init() {

		app = (RadioApplication) this.getApplication();

		adapter = new RadioListAdapter(this, R.layout.radio_list_item,
				app.getCurrentRadios());
		setListAdapter(adapter);

		PlayerCallback clb = new PlayerCallback() {
			public void playerStarted() {
			}

			public void playerPCMFeedBuffer(boolean isPlaying, int bufSizeMs,
					int bufCapacityMs) {
			}

			public void playerStopped(int perf) {
			}

			public void playerException(Throwable t) {
			}

			public void playerMetadata(String key, String value) {
			}
		};

		aacPlayer = new MultiPlayer(clb);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_add:
			Intent intent = new Intent(Main.this, AddRadio.class);
			startActivity(intent);
			break;
		}
		return false;
	}

	public void onClick(View v) {
		aacPlayer.playAsync("http://stream.m-1.fm:80/m1/aacp");
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		Radio r = adapter.getItem(position);

		aacPlayer.stop();
		aacPlayer.playAsync(r.getUrl());

	}

}
