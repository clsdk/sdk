package com.chuanglan.gsou.tools;

import org.json.JSONObject;

public class JsonUtil {

    public static String getString(JSONObject jsonObject, String key) {
        String value = "";
        String jsonStr = jsonObject.toString();
        boolean bool = jsonStr.contains(key);
        if (bool) {
            value = jsonObject.getString(key);
        }
        return value;
    }



    public static int getInt(JSONObject jsonObject, String key) {
        int value = 0;
        String jsonStr = jsonObject.toString();
        boolean bool = jsonStr.contains(key);
        if (bool) {
            value = jsonObject.getInt(key);
        }
        return value;
    }
}
