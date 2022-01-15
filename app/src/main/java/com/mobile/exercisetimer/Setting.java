package com.mobile.exercisetimer;

public class Setting {
    private boolean enableCountdownSound = false;
    private boolean enableHalfwaySound = false;

    private static Setting setting = new Setting();

    private Setting() {
    }

    public void setEnableCountdownSound(boolean enabled) {
        enableCountdownSound = enabled;
    }

    public void setEnableHalfwaySound(boolean enabled) {
        enableHalfwaySound = enabled;
    }

    public boolean isCountdownSoundEnabled() {
        return enableCountdownSound;
    }

    public boolean isHalfwaySoundEnabled() {
        return enableHalfwaySound;
    }

    public static Setting getInstance() {
        return setting;
    }
}
