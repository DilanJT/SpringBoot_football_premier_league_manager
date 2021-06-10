package com.w1761267.premierbackend.model;

public class SchoolFootballClub extends FootballClub{
    private static final long serialVersionUID = 1L;
    private String schoolName;

    public SchoolFootballClub(){

    }

    public SchoolFootballClub(
            String cName,
            String location,
            int footballClubID,
            String schoolName
    ){
        super(cName, location, footballClubID);
        this.schoolName = schoolName;
    }

    //setters
    public void setSchoolFootballClub(String schoolName){
        this.schoolName = schoolName;
    }

    //getters
    public String getSchoolFootballClub(){
        return schoolName;
    }

    @Override
    public String toString(){
        return super.toString() + ", School Name: "+ schoolName;
    }
}
