package com.w1761267.premierbackend.model;

import java.io.Serializable;

public class SportsClub implements Serializable{
    private static final long serialVersionUID = 1L;
    private String clubName;
    private String location;

    //constructor with no parameters
    public SportsClub() {
        this.clubName = "";
        this.location = "";
    }

    public SportsClub(String cName){
        this.clubName = cName;
    }

    //constructor to initialise with 2 parameters
    public SportsClub(String cName, String location) {
        this.clubName = cName;
        this.location = location;
    }

    //setters
    public void setClubName(String name) {
        this.clubName = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //getters
    public String getClubName(){
        return clubName;
    }

    public String getLocation(){
        return location;
    }


    //overiding the toString method
    @Override
    public String toString(){
        return "Club name: " + clubName +
                ", Location: " + location;
    }
}
