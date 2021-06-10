package com.w1761267.premierbackend.model;

public class FootballClub extends SportsClub implements Comparable<FootballClub>{
    private static final long serialVersionUID = 1L;

    private int footballClubID;
    private int numMatches = 0;
    private int points = 0;

    private int wins = 0;
    private int losses = 0;
    private int draws = 0;
    private int redCards = 0;
    private int yellowCards = 0;
    private int cleanSheets = 0;
    private int goalsScored = 0;
    private int goalsConceded = 0;


    public FootballClub(){

    }

    public FootballClub(
            String clubName,
            String location,
            int numMatches,
            int points,
            int wins,
            int losses,
            int draws,
            int goalsScored
    ){
        super(clubName, location);
        this.numMatches = numMatches;
        this.points = points;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.goalsScored = goalsScored;
    }

    public FootballClub(String cName, int footballClubID){
        super(cName);
        this.footballClubID = footballClubID;
    }

    public FootballClub(String cName, String location, int footballClubID){
        super(cName, location);
        this.footballClubID = footballClubID;
    }

    //getters
    public int getNumMatches(){
        return numMatches;
    }

    public int getPoints(){
        return points;
    }

    public int getFootballClubID() {
        return footballClubID;
    }

    //setters
    public void setNumMatches(int numMatches) {
        this.numMatches = numMatches;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    public void setFootballClubID(int footballClubID) {
        this.footballClubID = footballClubID;
    }

    //add
    public void addPoints(int points){
        this.points += points;
    }
    public void incrementNumMatches(){
        this.numMatches += 1;
    }


    //stats getters, setters and methods
    //getters
    public int getCleanSheets() {
        return cleanSheets;
    }
    public int getDraws() {
        return draws;
    }
    public int getGoalsConceded() {
        return goalsConceded;
    }
    public int getGoalsScored() {
        return goalsScored;
    }
    public int getLosses() {
        return losses;
    }
    public int getRedCards() {
        return redCards;
    }
    public int getWins() {
        return wins;
    }
    public int getYellowCards() {
        return yellowCards;
    }

    //setters
    public void setCleanSheets(int cleanSheets) {
        this.cleanSheets = cleanSheets;
    }
    public void setDraws(int draws) {
        this.draws = draws;
    }
    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }
    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }
    public void setLosses(int losses) {
        this.losses = losses;
    }
    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }
    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    //additons
    public void incrementWins(){
        this.wins += 1;
    }
    public void incrementLosses(){
        this.losses += 1;
    }
    public void incrementDraws(){
        this.draws += 1;
    }

    public void addGoalsScored(int goalsScored){
        this.goalsScored += goalsScored;
    }
    public void addGoalsConceded(int goalsConceded){
        this.goalsConceded += goalsConceded;
    }
    public void addCleanSheets(int cleanSheets){
        this.cleanSheets += cleanSheets;
    }
    public void addYellowCards(int yellowCards){
        this.yellowCards += yellowCards;
    }
    public void addRedCards(int redCards) {
        this.redCards += redCards;
    }
    public void addWins(int wins){
        this.wins += wins;
    }
    public void addLosses(int losses){
        this.losses += losses;
    }
    public void addDraws(int draws) {
        this.draws += draws;
    }

    //derived getter
    public int getGoalDifference(){
        return goalsScored - goalsConceded;
    }

    @Override
    public int compareTo(FootballClub fbc) {
        if(points== fbc.getPoints())
            return 0;
        else if(points > fbc.getPoints())
            return -1;
        else
            return 1;
    }

    @Override
    public String toString() {
        return super.toString() + ", No. of matches: "+ numMatches +
                ", Points: "+ points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        FootballClub fClub = (FootballClub) o;
        return (fClub.getClubName().equalsIgnoreCase(this.getClubName()) && fClub.footballClubID == this.footballClubID);
    }

    @Override
    public int hashCode() {
        return this.footballClubID;
    }


}