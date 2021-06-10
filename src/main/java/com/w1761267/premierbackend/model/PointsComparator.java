package com.w1761267.premierbackend.model;

import java.util.Comparator;

public class PointsComparator implements Comparator<FootballClub> {
    //sorted according to the descending order
    @Override
    public int compare(FootballClub fbc1, FootballClub fbc2){
        // comparing with the club points
        if(fbc1.getPoints() == fbc2.getPoints()) {
            //comparing with the goal difference when points get equals with each other
            if(fbc1.getGoalDifference() == fbc1.getGoalDifference())
                return 0;
            else if(fbc1.getGoalDifference() > fbc1.getGoalDifference())
                return -1;
            else
                return 1;
        }
        else if(fbc1.getPoints() > fbc2.getPoints())
            return -1;
        else
            return 1;
    }
}
