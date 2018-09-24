package com.olgagoo.debug.homework.homework_3;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.leakcanary.LeakCanary;

/**
 * Custom Application class to implement and initialize new function anf SDK
 */
public class CustomApplication extends Application{

    @Override public void onCreate() {
        super.onCreate();

        // LeakCanary implementation
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        //Fresco initialization
        Fresco.initialize(this);

    }
}
