package me.chenfuduo.moonnewsclient.utils;

import android.util.Log;

/**
 * Created by Administrator on 2015/6/16.
 */
public final class MyLogger {

    private final static boolean flag = true;

    public static void v(String tag, String msg) {
        if (flag) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (flag) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (flag) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (flag) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (flag) {
            Log.e(tag, msg);
        }
    }

}
