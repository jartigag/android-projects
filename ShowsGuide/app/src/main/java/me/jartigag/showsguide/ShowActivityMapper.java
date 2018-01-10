package me.jartigag.showsguide;

import android.app.Activity;

import java.util.HashMap;

class ShowActivityMapper {

    private static ShowActivityMapper singleton;
    private HashMap<String, Class<? extends Activity>> showClassMap;

    public static Class<? extends Activity> getShowClass(String showId) {
        return getSingleton().showClassMap.get(showId);
    }

    private static ShowActivityMapper getSingleton() {
        if (singleton == null) {
            singleton = new ShowActivityMapper();
        }
        return singleton;
    }
}
