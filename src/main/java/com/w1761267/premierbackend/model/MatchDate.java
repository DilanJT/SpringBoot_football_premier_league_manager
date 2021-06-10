package com.w1761267.premierbackend.model;

import java.io.Serializable;
import java.text.DecimalFormat;

public class MatchDate implements Comparable<MatchDate>, Serializable{

    private static final long serialVersionUID = 1L;

    private int day = 1;
    private int month = 1;
    private int year = 1;
    private String date;

    private int hour = 0;
    private int minutes = 0;
    private String time;

    public MatchDate(){

    }
    public MatchDate(int day, int month, int year){
        setDay(day);
        setMonth(month);
        setYear(year);
    }
    public MatchDate(int day, int month, int year, int hour, int minutes){
        setDay(day);
        setMonth(month);
        setYear(year);
        setHour(hour);
        setMinutes(minutes);
    }

    //setters
    public void setDay(int day) {
        if(day > 0 && day <= 31){
            this.day = day;
        }else{
            System.out.println("Invalid day.");
        }
    }
    public void setMonth(int month) {
        if(month > 0 && month <= 12){
            this.month = month;
        }else{
            System.out.println("Invalid month.");
        }
    }
    public void setYear(int year) {
        if(year > 0){
            this.year = year;
        }
    }

    public void setHour(int hour) {
        if(hour >= 0 && hour <= 23){
            this.hour = hour;
        }
    }

    public void setMinutes(int minutes) {
        if(minutes >= 0 && minutes <= 60){
            this.minutes = minutes;
        }
    }

    public void setTime() {
        //Formatting the time
        DecimalFormat timeFormat = new DecimalFormat("00");
        String hOutput = timeFormat.format(getHour());
        String mOutput = timeFormat.format(getMinutes());
        this.time = hOutput + ":" + mOutput;
    }

    public void setDate() {
        //formatting the date easy to understand
        DecimalFormat dmFormat = new DecimalFormat("00");
        DecimalFormat yFormat = new DecimalFormat("0000");
        String dOutput = dmFormat.format(getDay());
        String mOutput = dmFormat.format(getMonth());
        String yOutput = yFormat.format(getYear());
        this.date = dOutput + "-" + mOutput + "-" + yOutput;
    }


    //getters
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public String getTime(){
        setTime();
        return time;
    }

    public String getDate(){
        setDate();
        return date;
    }

    //using compare to method match is to be sorted according to the latest day (descending order of the day)
    @Override
    public int compareTo(MatchDate md) {
        if(day == md.getDay())
            return 0;
        else if(day > md.getDay())
            return -1;
        else
            return 1;
    }

    @Override
    public String toString() {
        return getTime() + " | " + getDate();
    }


}