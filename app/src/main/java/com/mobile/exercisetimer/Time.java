package com.mobile.exercisetimer;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Time {

    private static ArrayList<Time> timeArrayList;
    private String minute;
    private String second;

    public Time(String minute, String second){
        this.minute = minute;
        this.second = second;
    }

    public static ArrayList<Time> getTimeArrayList(){
        return timeArrayList;
    }

    public static String[] timeString(){
        String[] time = new String[timeArrayList.size()];
        for (int i = 0; i< timeArrayList.size(); i++){
            time[i] = timeArrayList.get(i).minute + ":" + timeArrayList.get(i).second + " minutes";
        }
        return time;
    }

    public static void initTime(){
        timeArrayList = new ArrayList<>();
        timeArrayList.add(new Time("0","10"));
        timeArrayList.add(new Time("0","20"));
        timeArrayList.add(new Time("0","30"));
        timeArrayList.add(new Time("0","40"));
        timeArrayList.add(new Time("0","50"));
        timeArrayList.add(new Time("1","00"));
        timeArrayList.add(new Time("1","10"));
        timeArrayList.add(new Time("1","20"));
        timeArrayList.add(new Time("1","30"));
        timeArrayList.add(new Time("1","40"));
        timeArrayList.add(new Time("1","50"));
        timeArrayList.add(new Time("2","00"));
        timeArrayList.add(new Time("2","10"));
        timeArrayList.add(new Time("2","20"));
        timeArrayList.add(new Time("2","30"));
        timeArrayList.add(new Time("2","40"));
        timeArrayList.add(new Time("2","50"));
        timeArrayList.add(new Time("3","00"));
        timeArrayList.add(new Time("3","10"));
        timeArrayList.add(new Time("3","20"));
        timeArrayList.add(new Time("3","30"));
        timeArrayList.add(new Time("3","40"));
        timeArrayList.add(new Time("3","50"));
        timeArrayList.add(new Time("4","00"));
        timeArrayList.add(new Time("4","10"));
        timeArrayList.add(new Time("4","20"));
        timeArrayList.add(new Time("4","30"));
        timeArrayList.add(new Time("4","40"));
        timeArrayList.add(new Time("4","50"));
        timeArrayList.add(new Time("5","00"));
        timeArrayList.add(new Time("5","10"));
        timeArrayList.add(new Time("5","20"));
        timeArrayList.add(new Time("5","30"));
        timeArrayList.add(new Time("5","40"));
        timeArrayList.add(new Time("5","50"));
        timeArrayList.add(new Time("6","00"));
        timeArrayList.add(new Time("6","10"));
        timeArrayList.add(new Time("6","20"));
        timeArrayList.add(new Time("6","30"));
        timeArrayList.add(new Time("6","40"));
        timeArrayList.add(new Time("6","50"));
        timeArrayList.add(new Time("7","00"));
        timeArrayList.add(new Time("7","10"));
        timeArrayList.add(new Time("7","20"));
        timeArrayList.add(new Time("7","30"));
        timeArrayList.add(new Time("7","40"));
        timeArrayList.add(new Time("7","50"));
        timeArrayList.add(new Time("8","00"));
        timeArrayList.add(new Time("8","10"));
        timeArrayList.add(new Time("8","20"));
        timeArrayList.add(new Time("8","30"));
        timeArrayList.add(new Time("8","40"));
        timeArrayList.add(new Time("8","50"));
        timeArrayList.add(new Time("9","00"));
        timeArrayList.add(new Time("9","10"));
        timeArrayList.add(new Time("9","20"));
        timeArrayList.add(new Time("9","30"));
        timeArrayList.add(new Time("9","40"));
        timeArrayList.add(new Time("9","50"));
        timeArrayList.add(new Time("10","00"));
        timeArrayList.add(new Time("10","30"));
        timeArrayList.add(new Time("11","00"));
        timeArrayList.add(new Time("11","30"));
        timeArrayList.add(new Time("12","00"));
        timeArrayList.add(new Time("12","30"));
        timeArrayList.add(new Time("13","00"));
        timeArrayList.add(new Time("13","30"));
        timeArrayList.add(new Time("14","00"));
        timeArrayList.add(new Time("14","30"));
        timeArrayList.add(new Time("15","00"));
    }

    public String getMinute() {
        return minute;
    }

    public String getSecond() {
        return second;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public void setSecond(String second) {
        this.second = second;
    }
}

