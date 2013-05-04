package com.hamm.ringeroff;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;

public class AlarmBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent != null) {
			if (intent.getAction().equals("com.hamm.ringeroff.cancel")) {
				int volume = intent.getIntExtra("com.hamm.ringeroff.volume", 4);
				AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
				am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
				am.setStreamVolume(AudioManager.STREAM_RING, volume, 0);
			}
		}
	}
}
