package com.nickdollinger.msto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ndolling on 12/18/13.
 */
public class BootUpReceiver extends BroadcastReceiver {

    private final String TAG = "BootUp Receiver";

    @Override
    public void onReceive(Context context, Intent intent) {
//        Intent awakeService = new Intent(context, AwakeService.class);
//        context.startService(awakeService);
        Log.d(TAG, "Broadcast Received");
    }
}
