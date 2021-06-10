package com.w1761267.premierbackend.controller;


import com.w1761267.premierbackend.model.PremierLeagueMatch;
import com.w1761267.premierbackend.service.LeagueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
@CrossOrigin(origins = "http://localhost:4200")
public class MatchController {

    private final LeagueService services;

    public MatchController(LeagueService services) {
        this.services = services;
    }

    @RequestMapping(value = "{val}",method = RequestMethod.GET)
    public List<PremierLeagueMatch> getAllPlayedMatches(@PathVariable("val") String val){
        return this.services.getAllMatchesPlayed(val);
    }

    @RequestMapping(value = "/generatedmatch", method = RequestMethod.GET)
    public PremierLeagueMatch generateRandomMatch(){
        services.addRandomlyPlayedMatch();
        return services.getRandomlyGeneratedMatch();
    }

}
