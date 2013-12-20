package com.nickdollinger.msto;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;

/**
 * Created by ndolling on 12/18/13.
 * This Service will be invoked by the app and will acquire or release a wake lock
 * This is normally a VERY bad thing since it will run your battery down quickly, however
 * in special situations, it's all good.
 */
public class AwakeService extends Service {

    private final String TAG = "AwakeService";
    private PowerManager.WakeLock mLock;

    @Override
    public void onCreate() {
//        try{
//            PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
//            mLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, TAG);
//        }
//        catch(Exception e){
//            String msg = (e.getMessage() == null) ? "Exception" : e.getMessage();
//            Log.e(TAG, msg);
//        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.i(TAG, "Received start id " + startId + ": " + intent);
        handleButtonInput(intent);
        return START_REDELIVER_INTENT; // keep running until explicitly stopped
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null; // Don't really need to bind to this service, so return null
    }

    private void handleButtonInput(Intent intent) {
        boolean flag = intent.getExtras().getBoolean("KeepAwake");  // potential null pointer
        if(flag){
            Log.d(TAG, "Keeping the screen awake");
            PowerManager powerMan = (PowerManager) getSystemService(POWER_SERVICE);
            powerMan.wakeUp(SystemClock.uptimeMillis());  // TODO: perhaps should pass in this time
//            if(mLock != null)
//                mLock.acquire();
//            else
//                Log.e(TAG, "INVALID LOCK");  // TODO: Do something other than report
        }
        else{
            Log.d(TAG, "Allowing the screen to do whatever the F");
//            if(mLock != null)
//                mLock.release();
//            else
//                Log.e(TAG, "INVALID LOCK");
        }
    }
}
