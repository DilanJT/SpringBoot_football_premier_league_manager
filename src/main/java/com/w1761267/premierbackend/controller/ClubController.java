package com.w1761267.premierbackend.controller;


import com.w1761267.premierbackend.model.FootballClub;
import com.w1761267.premierbackend.service.LeagueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/footballclubs")
@CrossOrigin(origins = "http://localhost:4200")
public class ClubController {

    private final LeagueService leagueService;

    public ClubController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<FootballClub> getAllFootballClubs(){
        return leagueService.getAllFootballClubs();
    }

}
