package com.w1761267.premierbackend.service;

import com.w1761267.premierbackend.Dao.PremierLeagueManager;
import com.w1761267.premierbackend.model.FootballClub;
import com.w1761267.premierbackend.model.MatchDate;
import com.w1761267.premierbackend.model.PremierLeagueMatch;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


@Service
public class LeagueService {

    private PremierLeagueManager pManager;

    public LeagueService(PremierLeagueManager pManager) {
        this.pManager = pManager;
    }


    List<PremierLeagueMatch> filteredMatches = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void run() throws IOException, URISyntaxException {


        pManager.loadData();

        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("Welcome to the Premier League Manager.");
        System.out.println("--------------------------------------");
        System.out.println();

        displayMenu();
        System.out.print("Enter your option here :");
        String menuOption = sc.next();


        //covert to switch

        while (true) {
            if (menuOption.equals("1")) {
                addFootballClub();
            } else if (menuOption.equals("2")) {
                deleteFootballClub();
            } else if (menuOption.equals("3")) {
                displayFootballClubStats();
            } else if (menuOption.equals("4")) {
                pManager.displayPremierLeagueTable();
            } else if (menuOption.equals("5")) {
                addPlayedMatch();
            } else if (menuOption.equals("6")) {
                pManager.displayMatchesPlayed();
            } else if (menuOption.equals("g")) {
                invokeGUIfromBrowser();
                System.out.println("Gui is invoked");
            } else if (menuOption.equalsIgnoreCase("q")) {
                System.out.println("Good bye...");
                pManager.saveData();
                System.exit(0);
                break;
            } else {
                System.out.println("You entered a wrong option");
            }

            System.out.println();
            displayMenu();
            System.out.print("Enter your option here :");
            menuOption = sc.next();
        }
    }

    public void displayMenu() {
        //display the menu functions



        System.out.println("|1| Press 1 to add a football club");
        System.out.println("|2| Press 2 to delete(relegate) a football club");
        System.out.println("|3| Press 3 to display statistics of a club");
        System.out.println("|4| Press 4 to display the premier league table");
        System.out.println("|5| Press 5 to add a played match");
        System.out.println("|6| Press 6 to display the matches played");
        System.out.println("|g| Press g to invoke the GUI application.");
        System.out.println("|q| Press q to quit the program");
    }

    public void addFootballClub(){
        //adding a football club

        System.out.print("Enter name of the football club :");
        String clubName = sc.next();
        System.out.print("Enter the location of the football club :");
        String location = sc.next();
        System.out.print("Enter the football club ID :");
        int clubID = checkForInputMismatch("club ID");

        FootballClub fbc = new FootballClub(clubName, location, clubID);
        pManager.addFootballClub(fbc);
    }

    public void deleteFootballClub(){
        //delete a football club
        System.out.print("Enter the football club name you want to delete :");
        String clubName = sc.next();
        System.out.print("Enter the football club ID :");
        int clubID = checkForInputMismatch("club ID");

        FootballClub fbc = new FootballClub(clubName, clubID);
        while(true) {
            if (pManager.checkClubPresence(fbc)) {
                pManager.deleteFootballClub(fbc);
                break;
            } else if(!pManager.checkClubPresence(fbc)) {
                System.out.println("Sorry, there is no such club present in the premier league. Try again.");
                System.out.print("Enter the club name you want to delete :");
                clubName = sc.next();
                System.out.print("Enter the club ID :");
                clubID = checkForInputMismatch("club ID");
                fbc = new FootballClub(clubName, clubID);
            }
        }


    }

    public void displayFootballClubStats(){
        //display the club stats

        System.out.print("Enter the name of the club :");
        String clubName = sc.next();
        System.out.print("Enter the numerical Football Club ID :");
        int footballClubID = checkForInputMismatch("club ID");

        FootballClub fbc = new FootballClub(clubName, footballClubID);

        while(true) {
            if(pManager.checkClubPresence(fbc)){
                pManager.displayFootballClubStats(fbc);
                break;
            }else {
                System.out.println("The entered name is not registered to this league. Please try again...");
                System.out.print("Name of club :");
                clubName = sc.next();
                System.out.print("Football Club ID :");
                footballClubID = checkForInputMismatch("club ID");
                fbc = new FootballClub(clubName, footballClubID);
            }
        }
    }

    public void addPlayedMatch(){
        //add a played match with the statistics
        System.out.println("Enter the date of the match played :");
        System.out.print("Day :");
        int day = checkForInputMismatch("Day");
        System.out.print("Month :");
        int month = checkForInputMismatch("Month");
        System.out.print("Year :");
        int year = checkForInputMismatch("Year");

        System.out.println("Enter the time of the match played :");
        System.out.print("Hour :");
        int hour = checkForInputMismatch("Hour");
        System.out.print("Minute :");
        int minute = checkForInputMismatch("Minute");

        MatchDate pMatch = new MatchDate(day, month, year, hour, minute);

        FootballClub firstTeam = new FootballClub();
        FootballClub secondTeam = new FootballClub();

        System.out.println("\nEnter the clubs and their played match stats.\n");

        clubMatchData(firstTeam, "first");
        clubMatchData(secondTeam, "second");

        pManager.addPlayedMatch(pMatch, firstTeam, secondTeam);

    }

    //other functions

    public void clubMatchData(FootballClub team, String name){

        //asking the data of the first team
        System.out.println("Enter the "+ name + " team data");
        System.out.print("Team name :");
        String teamName = sc.next();
        System.out.print("Enter team ID :");
        int footballClubID = checkForInputMismatch("club ID");

        team.setClubName(teamName);
        team.setFootballClubID(footballClubID);

        while(true){
            if(pManager.checkClubPresence(team)){
                System.out.print("goals scored :");
                int goalsScored = checkForInputMismatch("goals scored");
                System.out.print("goals conceded :");
                int goalsConceded = checkForInputMismatch("goals conceded");
                System.out.print("yellow cards :");
                int yellowCards = checkForInputMismatch("yellow cards");
                System.out.print("Red cards :");
                int redCards = checkForInputMismatch("red cards");

                team.setGoalsConceded(goalsConceded);
                team.setGoalsScored(goalsScored);
                team.setYellowCards(yellowCards);
                team.setRedCards(redCards);
                if(goalsConceded == 0)
                    team.addCleanSheets(1);

                break;
            }else{
                System.out.println("The entered name is not registered to this league. Please try again...");
                System.out.print("Name of club :");
                teamName = sc.next();
                System.out.print("Football Club ID :");
                footballClubID = checkForInputMismatch("club ID");
                team.setClubName(teamName);
                team.setFootballClubID(footballClubID);
            }
        }
    }

    public int checkForInputMismatch(String var){
        int num;
        while(true) {
            try {
                num = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid numerical value for " + var + " again :");
                sc.nextLine();
            }
        }

        return num;
    }



    //communicate with front end
    public List<FootballClub> getAllFootballClubs() {
        return pManager.getAllFootballClubs();
    }

    public List<PremierLeagueMatch> getAllMatchesPlayed(String val){
        filteredMatches.clear();
        for(PremierLeagueMatch match : pManager.getAllMatchesPlayed()){
            if(match.getMatchDate().getDate().equals(val)){
                if(!filteredMatches.contains(match)){
                    filteredMatches.add(match);
                }
            }
        }

        if(val.equals("all")){
            return pManager.getAllMatchesPlayed();
        }
        return filteredMatches;
        //last updated here
        //have to update the gui and logic
    }

    public void addRandomlyPlayedMatch(){
        // Logic for the button to create a randomly played match

        int day = (int) (Math.random() * (31 - 1 + 1) + 1);
        int month = (int) (Math.random() * (12 - 1 + 1) + 1);
        int year = (int) (Math.random() * (2021 - 2020 + 1) + 2020);
        int hour = (int) (Math.random() * (23 - 0 + 1) + 0);
        int min = (int) (Math.random() * (59 - 0 + 1) + 0);

        MatchDate randomDate = new MatchDate(day, month, year, hour, min);

        FootballClub firstTeam = new FootballClub();
        FootballClub secondTeam = new FootballClub();

        int firstTeamIndex = (int) (Math.random() * ((pManager.getFootballClubsSize() - 1) - 0 + 1) + 0);
        int secTeamIndex = (int) (Math.random() * ((pManager.getFootballClubsSize() - 1) - 0 + 1) + 0);
        while(secTeamIndex == firstTeamIndex){
            secTeamIndex = (int) (Math.random() * ((pManager.getFootballClubsSize() - 1) - 0 + 1) + 0);
        }

        firstTeam.setClubName(pManager.getFootballClub(firstTeamIndex).getClubName());
        firstTeam.setLocation(pManager.getFootballClub(firstTeamIndex).getLocation());
        firstTeam.setFootballClubID(pManager.getFootballClub(firstTeamIndex).getFootballClubID());

        secondTeam.setClubName(pManager.getFootballClub(secTeamIndex).getClubName());
        secondTeam.setLocation(pManager.getFootballClub(secTeamIndex).getLocation());
        secondTeam.setFootballClubID(pManager.getFootballClub(secTeamIndex).getFootballClubID());

        clubMatchData(firstTeam);
        clubMatchData(secondTeam);

        pManager.addPlayedMatch(randomDate, firstTeam, secondTeam);
    }

    public void clubMatchData(FootballClub team){

        //generating random numbers for the match for a single team
        int goalsScored = (int) (Math.random() * (50 - 0 + 1) + 0);
        int goalsConceded = (int) (Math.random() * (goalsScored - 0 + 1) + 0);
        int yellowCards = (int) (Math.random() * (46 - 0 + 1) + 0);
        int redCards = (int) (Math.random() * (4 - 0 + 1) + 0);

        team.setGoalsScored(goalsScored);
        team.setGoalsConceded(goalsConceded);
        team.setYellowCards(yellowCards);
        team.setRedCards(redCards);
        if(goalsConceded == 0) {
            team.setCleanSheets(1);
        }

    }

    public PremierLeagueMatch getRandomlyGeneratedMatch(){

        return pManager.getRandomlyGeneratedMatch();
    }


    //function to invoke the gui
    //code taken from :- https://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button
    public void invokeGUIfromBrowser() throws URISyntaxException, IOException {
        String guiURL ="http://localhost:4200";

        if(Desktop.isDesktopSupported()) {
            //windows
            Desktop.getDesktop().browse(new URI(guiURL));
        }else {
            Runtime runtime = Runtime.getRuntime();
            try{
                runtime.exec("rundll32 url.dll, FileProtocolHandler " + guiURL);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }




}
