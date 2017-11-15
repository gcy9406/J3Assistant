package cn.mycats.j3assistant;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by gcy on 2016/10/29.
 */

public class SP {
    private SharedPreferences sp = null;
    private SharedPreferences.Editor editor = null;
    private static SP SP = null;
    private Context context;
    private SP(Context context) {
        this.context = context.getApplicationContext();
        sp = this.context.getSharedPreferences("UserManager", MODE_PRIVATE);
        editor = sp.edit();
    }
    public static synchronized SP getInstance(Context context){
        if (SP == null)
            SP = new SP(context);
        return SP;
    }

    /**
     * 添加数据
     * @param key
     * @param value
     */
    public void putString(String key,String value){
        editor.putString(key,value);
        editor.commit();
    }
    public void putBoolean(String key,boolean value){
        editor.putBoolean(key,value);
        editor.commit();
    }

    public void putInt(String key,int value){
        editor.putInt(key,value);
        editor.commit();
    }
    public void putLong(String key,long value){
        editor.putLong(key,value);
        editor.commit();
    }
    public String getString(String key,String value){
        return sp.getString(key,value);
    }

    public boolean getBoolean(String key,boolean value){
        return sp.getBoolean(key,value);
    }
    public int getInt(String key,int value){
        return sp.getInt(key,value);
    }
    public long getLong(String key,long value){
        return sp.getLong(key,value);
    }

    public String getUserName(){
        return sp.getString("name","");
    }

}
