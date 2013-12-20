package com.nickdollinger.msto;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private final String TAG = "MSTO Main Activity";
    private TextView mStatusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStatusText = (TextView) findViewById(R.id.label);

        final Intent serviceIntent = new Intent(this, AwakeService.class); // TODO: correct final?

        // Get the buttons and setup the handlers.  TODO: Move this to a fragment
        Button enableLock = (Button) findViewById(R.id.enable_button);
        enableLock.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
                Log.d(TAG, "Enable Button Clicked");
                // Do I need to clear what might have been in the Bundle first or will this replace?
                //serviceIntent.putExtra("KeepAwake", true);
                //startService(serviceIntent);
               ContentResolver cr = getContentResolver();  // this context's contentResolver
               mStatusText.setText("Screen Timeout: " +
                       Settings.System.getString(cr, Settings.System.SCREEN_OFF_TIMEOUT));
           }
        });

        Button disableLock = (Button) findViewById(R.id.disable_button);
        disableLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Disable Button Clicked");
                //serviceIntent.putExtra("KeepAwake", false);
                //startService(serviceIntent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
