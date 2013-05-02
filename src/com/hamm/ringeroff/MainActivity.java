package com.hamm.ringeroff;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	AudioManager am;
	int currentVolume;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		am = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
	}
	
	public void start(View v){
		currentVolume = am.getStreamVolume(AudioManager.STREAM_RING);
		am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
		System.out.println("Start");
	}
	
	public void stop(View v){
		am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		am.setStreamVolume(AudioManager.STREAM_RING, currentVolume, 0);
		System.out.println("Stop");
	}
}
