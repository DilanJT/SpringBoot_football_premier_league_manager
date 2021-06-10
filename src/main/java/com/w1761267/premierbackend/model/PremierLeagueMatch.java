package com.w1761267.premierbackend.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class PremierLeagueMatch implements Serializable, Comparable<PremierLeagueMatch>{
    //this match class is for record the statistics for every match
    private static final long serialVersionUID = 1L;

    private MatchDate matchDate;
    private boolean draw;
    private FootballClub wonTeam;
    private FootballClub lossTeam;
    private FootballClub[] twoClubs;


    public PremierLeagueMatch() {
        twoClubs = new FootballClub[2];
    }

    public PremierLeagueMatch(MatchDate date, FootballClub firstTeam, FootballClub secondTeam) {
        twoClubs = new FootballClub[2];
        this.matchDate = date;
        this.twoClubs[0] = firstTeam;
        this.twoClubs[1] = secondTeam;
    }

    // getters

    public FootballClub[] getTwoClubs() {
        return twoClubs;
    }

    public FootballClub getLossTeam() {
        return lossTeam;
    }


    public FootballClub getWonTeam() {
        return wonTeam;
    }

    public boolean getDraw() {
        return draw;
    }

    //important getter
    public MatchDate getMatchDate() {
        return matchDate;
    }

    // setters

    public void setTwoClubs(FootballClub firstClub, FootballClub secClub) {
        this.twoClubs[0] = firstClub;
        this.twoClubs[1] = secClub;
    }

    public void setMatchDate(MatchDate date) {
        this.matchDate = date;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }


    public void setLossTeam(FootballClub lossTeam) {
        this.lossTeam = lossTeam;
    }


    public void setWonTeam(FootballClub wonTeam) {
        this.wonTeam = wonTeam;
    }

    @Override
    public int compareTo(PremierLeagueMatch plm) {
        // date is ordered according the day.
        if(matchDate.getDay() == plm.getMatchDate().getDay())
            return 0;
        else if(matchDate.getDay() > plm.getMatchDate().getDay())
            return 1;
        else
            return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PremierLeagueMatch match = (PremierLeagueMatch) o;
        //there cant be the same teams playing in the same day for 2 times
        return ((matchDate.getDate().equals(match.getMatchDate().getDate())) &&
                Arrays.equals(twoClubs, match.getTwoClubs())
                );
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchDate);
    }
}
