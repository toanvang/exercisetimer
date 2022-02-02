package com.mobile.exercisetimer;

import android.content.Context;
import android.content.SharedPreferences;


public class Setting {
    private boolean enableCountdownSound = true;
    private boolean enableHalfwaySound = true;


    private static Setting setting = new Setting();

    private Setting() {
    }

    public void setEnableCountdownSound(boolean toggle) {
        enableCountdownSound = toggle;
    }

    public void setEnableHalfwaySound(boolean toggle) {
        enableHalfwaySound = toggle;
    }

    public boolean isCountdownSoundEnabled() { return enableCountdownSound; }


    public boolean isHalfwaySoundEnabled() {
        return enableHalfwaySound;
    }

    public static Setting getInstance() {
        return setting;
    }
}
