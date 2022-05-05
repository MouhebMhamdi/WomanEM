package com.example.demo.services;

import com.example.demo.entities.RendezVous;

import java.text.ParseException;
import java.util.List;

public interface RendezVousService {

    RendezVous addRdvAndAffecterDoctorAndLoyerAndUser(RendezVous rendezVous,Integer idDoc,Integer idLoyer,Long idUser);
    RendezVous updateRdv(Integer idRdv,RendezVous rendezVous);
    void deleteRendezVous(Integer idRdv);
    void deleteAllRdv();
    List<RendezVous> getAllRendezVous();
    RendezVous getRdvById(Integer idRdv);

    void Notification() throws ParseException;


}
