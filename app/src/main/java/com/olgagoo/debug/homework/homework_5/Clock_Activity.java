package com.olgagoo.debug.homework.homework_5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.olgagoo.debug.homework.R;

public class Clock_Activity extends AppCompatActivity {
    private Switch switcher;
    private WifiManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_);

        switcher = (Switch) findViewById(R.id.switcher);
        manager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    manager.setWifiEnabled(true);
                } else{
                    manager.setWifiEnabled(false);
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifireciver,intFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifireciver);
    }

    private BroadcastReceiver wifireciver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);

            switch (wifiState){
                case WifiManager.WIFI_STATE_DISABLED:
                    switcher.setChecked(false);
                    break;

                case WifiManager.WIFI_STATE_ENABLED:
                    switcher.setChecked(true);
                    break;
            }
        }
    };
}
