package com.example.demo.services;

import com.example.demo.entities.Sponsor;
import com.example.demo.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SponsorServiceImpl implements SponsorService{
    @Autowired
    private SponsorRepository sponsorRepository;

    @Override
    public Sponsor ajouterParticipant(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    @Override
    public List<Sponsor> afficherTousLesParticipants() {
        return sponsorRepository.findAll();
    }
}
