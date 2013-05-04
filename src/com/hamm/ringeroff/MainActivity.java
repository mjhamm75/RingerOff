package com.hamm.ringeroff;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	int currentVolume;
	AudioManager am;
	private static final String CANCEL_ACTION = "com.hamm.ringeroff.cancel";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		am = (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);
	}

	public void start(View v) {
		am = (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);
		currentVolume = am.getStreamVolume(AudioManager.STREAM_RING);
		am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
	}

	public void stop(View v) {
		Intent intent = new Intent();
		intent.setAction(CANCEL_ACTION);
		intent.putExtra("com.hamm.ringeroff.volume", currentVolume);
		sendBroadcast(intent);
	}
}
