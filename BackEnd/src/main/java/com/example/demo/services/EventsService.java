package com.example.demo.services;

import com.example.demo.entities.Events;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface EventsService {
    List<Events> afficherTousLesEvenements();

    Events afficherEventById(int idEvent);

    Events afficherEventByDate(Date date);


    Events ajouterEvent(Events events);

    Events modifierEvent(int idEvent,Events events);

    List<Events> supprimerEvent(int idEvent);

    void supprimerTousLesEvenements();

    List<Events> supprimerAllEventsByDate(Date date);

    Events affecterUserAEvent(int idEvent,Long idUser);

    Events affecterParticipantAEvent(int idEvent,List<Integer> idParticipant);

    Double sommeDonation();

    List<Events> addImgToEventsList(MultipartFile file, int idEvent)throws IOException;
    int nbrDonation();

}
