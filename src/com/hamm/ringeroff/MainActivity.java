package com.hamm.ringeroff;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	AudioManager am;
	int currentVolume;
	public static final String START_ACTION = "com.hamm.ringeroff.start";
	public static final String CANCEL_ACTION = "com.hamm.ringeroff.cancel";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		am = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
	}

	public void start(View v) {
		Intent intent = new Intent();
		intent.setAction(START_ACTION);
		sendBroadcast(intent);

		currentVolume = am.getStreamVolume(AudioManager.STREAM_RING);
		am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
		System.out.println("Start");
	}

	public void stop(View v) {
		Intent intent = new Intent();
		intent.setAction(CANCEL_ACTION);
		sendBroadcast(intent);
		
		am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		am.setStreamVolume(AudioManager.STREAM_RING, currentVolume, 0);
		System.out.println("Stop");
	}
}
