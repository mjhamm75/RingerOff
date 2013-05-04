package com.hamm.ringeroff;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

public class MainActivity extends Activity {
	AudioManager am;
	int currentVolume;
	int itemSelected = 0;
	private static final String CANCEL_ACTION = "com.hamm.ringeroff.cancel";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void start(View v) {
		Spinner timeSpan = (Spinner) findViewById(R.id.spinner_length);
		timeSpan.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
				itemSelected = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				itemSelected = 0;
			}

		});
		getAudioManager().setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
	}

	public void stop(View v) {
		Intent intent = new Intent();
		intent.setAction(CANCEL_ACTION);
		intent.putExtra("com.hamm.ringeroff.volume", currentVolume);
		sendBroadcast(intent);
	}

	public int getCurrentVolume() {
		AudioManager am = getAudioManager();
		return am.getStreamVolume(AudioManager.STREAM_RING);
	}

	public AudioManager getAudioManager() {
		if (am == null) {
			am = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
		}
		return am;
	}
}
