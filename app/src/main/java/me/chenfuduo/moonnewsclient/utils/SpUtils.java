package me.chenfuduo.moonnewsclient.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2015/6/16.
 */
public final class SpUtils {

    private final static String name = "config";

    private final static int mode = Context.MODE_PRIVATE;


    /**
     * 存值
     * @param context
     * @param key
     * @param value
     */
    public final static void putBoolean(Context context,String key,boolean value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, mode);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * 存值
     * @param context
     * @param key
     * @param value
     */
    public final static void putString(Context context,String key,String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, mode);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 取值
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public final static boolean getBoolean(Context context,String key,boolean defValue){
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, mode);
        return sharedPreferences.getBoolean(key, defValue);
    }

    /**
     * 取值
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public final static String getString(Context context,String key,String defValue){
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, mode);
        return sharedPreferences.getString(key, defValue);
    }

}
