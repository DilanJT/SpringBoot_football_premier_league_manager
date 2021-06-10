package com.w1761267.premierbackend.Dao;


import com.w1761267.premierbackend.model.FootballClub;
import com.w1761267.premierbackend.model.MatchDate;

public interface LeagueManager {
    //method to add the foot ball clubs to the premier league
    void addFootballClub(FootballClub fbc);

    //method to relgate or delete football clubs from the season
    void deleteFootballClub(FootballClub fbc);

    //display the stats
    void displayFootballClubStats(FootballClub fbc);

    //display the premier league table
    void displayPremierLeagueTable();

    //add the played match details
    void addPlayedMatch(MatchDate md, FootballClub fbc1, FootballClub fbc2);
}
