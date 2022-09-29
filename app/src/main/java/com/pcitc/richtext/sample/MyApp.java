package com.pcitc.richtext.sample;

import android.app.Application;

/**
 * @author xinyu
 * @des
 * @time 2022/9/29 20:47
 */
public class MyApp extends Application {
    private static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static MyApp getApp() {
        return app;
    }
}
