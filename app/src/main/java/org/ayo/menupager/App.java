package org.ayo.menupager;

import android.app.Application;
import android.util.Log;

import org.ayo.sample.menu.notify.Toaster;

/**
 * Created by Administrator on 2017/1/1.
 */

public class App extends Application {

    public static Application app;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("sample", "Application---onCreate()");
        app = this;
        Toaster.init(app);
    }
}
