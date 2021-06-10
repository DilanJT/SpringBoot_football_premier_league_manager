package com.w1761267.premierbackend;

import com.w1761267.premierbackend.service.LeagueService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200/")
@SpringBootApplication
public class PremierBackendApplication implements CommandLineRunner {

    final
    LeagueService leagueService;

    public PremierBackendApplication(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    public static void main(String[] args){

        SpringApplication.run(PremierBackendApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world");

        leagueService.run();

    }
}
