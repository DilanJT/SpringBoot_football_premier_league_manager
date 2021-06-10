package com.w1761267.premierbackend.model;

public class UniversityFootballClub extends FootballClub{

    private static final long serialVersionUID = 1L;
    private String uniName;

    public UniversityFootballClub() {

    }

    public UniversityFootballClub(String cName, String location, String uniName, int footballClubID) {
        super(cName, location, footballClubID);
        this.uniName = uniName;
    }

    // setter
    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    // getter
    public String uniName() {
        return uniName;
    }

    @Override
    public String toString() {
        return super.toString() + ", University name: " + uniName;
    }
}
