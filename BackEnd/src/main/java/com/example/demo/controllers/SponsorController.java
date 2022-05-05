package com.example.demo.controllers;

import com.example.demo.entities.Sponsor;
import com.example.demo.services.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/sponsor")
public class SponsorController {
    @Autowired
    private SponsorService sponsorService;


    @GetMapping("/all")
    public List<Sponsor> getAllSponsors(){
        return sponsorService.afficherTousLesParticipants();
    }

    @PostMapping("/add")
    public List<Sponsor> ajouterSponsor(@RequestBody Sponsor sponsor){
        sponsorService.ajouterParticipant(sponsor);
        return this.getAllSponsors();
    }
}
