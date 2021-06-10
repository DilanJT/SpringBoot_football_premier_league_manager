package com.w1761267.premierbackend.model;

import java.util.Comparator;

public class DateComparator implements Comparator<PremierLeagueMatch> {
    // com.w1761267.DateComparator may used in the GUI application
    // all are sorted according to the ascending order.
    // compare order -> year > month > day > hour
    @Override
    public int compare(PremierLeagueMatch matchOne, PremierLeagueMatch matchTwo) {
        if(matchOne.getMatchDate().getYear() == matchTwo.getMatchDate().getYear()){
            if(matchOne.getMatchDate().getMonth() ==  matchTwo.getMatchDate().getMonth()){
                if(matchOne.getMatchDate().getDay() ==  matchTwo.getMatchDate().getDay()){
                    if(matchOne.getMatchDate().getHour() ==  matchTwo.getMatchDate().getHour())
                        return 0;
                    else if(matchOne.getMatchDate().getHour() >  matchTwo.getMatchDate().getHour())
                        return 1;
                    else
                        return -1;

                }else if(matchOne.getMatchDate().getDay() >  matchTwo.getMatchDate().getDay())
                    return 1;
                else
                    return -1;

            }else if(matchOne.getMatchDate().getMonth() >  matchTwo.getMatchDate().getMonth())
                return 1;
            else
                return -1;

        }else if(matchOne.getMatchDate().getYear() >  matchTwo.getMatchDate().getYear())
            return 1;
        else
            return -1;

    }
}
