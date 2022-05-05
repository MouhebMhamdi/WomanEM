package com.example.demo.services;

import com.example.demo.entities.Events;
import com.example.demo.entities.Sponsor;
import com.example.demo.entities.User;
import com.example.demo.repository.EventsRepository;
import com.example.demo.repository.SponsorRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class EventsServiceImpl implements EventsService{
    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SponsorRepository participantRepository;


    @Override
    @Transactional
    public List<Events> afficherTousLesEvenements() {
        return eventsRepository.findAll();
    }

    @Override
    @Transactional
    public Events afficherEventById(int idEvent) {
        return eventsRepository.findById(idEvent).orElse(null);
    }

    @Override
    @Transactional
    public Events afficherEventByDate(Date date) {
        return eventsRepository.getEventsByDate(date);
    }

    @Override
    @Transactional
    public Events ajouterEvent(Events events) {
        return eventsRepository.save(events);
    }

    @Override
    @Transactional
    public Events modifierEvent(int idEvent,Events events) {
        Events event=eventsRepository.findById(idEvent).orElse(null);

        if(events.getDate()!=null) event.setDate(events.getDate());
        if(events.getEventTopic()!=null) event.setEventTopic(events.getEventTopic());
        if(events.getDescription()!=null) event.setDescription(events.getDescription());
        if(events.getUserEvents()!=null)event.setUserEvents(events.getUserEvents());
        if(events.getFileName()!=null)event.setFileName(events.getFileName());
        if(events.getData()!=null)event.setData(events.getData());
        if(events.getFileType()!=null)event.setFileType(events.getFileType());
        return eventsRepository.save(event);
    }

    @Override
    @Transactional
    public List<Events> supprimerEvent(int idEvent) {
        eventsRepository.deleteById(idEvent);
        return this.afficherTousLesEvenements();
    }

    @Override
    @Transactional
    public void supprimerTousLesEvenements() {
        eventsRepository.deleteAll();
    }

    @Override
    @Transactional
    public List<Events> supprimerAllEventsByDate(Date date) {
        return eventsRepository.deleteAllByDate(date);
    }

    @Override
    @Transactional
    public Events affecterUserAEvent(int idEvent, Long idUser) {
        Events ev=eventsRepository.findById(idEvent).get();
        User us=userRepository.findById(idUser).get();
        ev.setUserEvents(us);

        return eventsRepository.save(ev);
    }

    @Override
    @Transactional
    public Events affecterParticipantAEvent(int idEvent, List<Integer> idParticipant) {
        Events ev=eventsRepository.findById(idEvent).get();
        List<Sponsor> part=participantRepository.findAllById(idParticipant);
        ev.setSponsors(part);
        return eventsRepository.save(ev);
    }

    @Override
    @Transactional
    public Double sommeDonation() {
        return eventsRepository.sommeDonation();
    }

    @Override
    @Transactional
    public List<Events> addImgToEventsList(MultipartFile file, int idEvent) throws IOException {
        Events ev=eventsRepository.findById(idEvent).orElse(null);
        ev.setFileName(file.getOriginalFilename());
        ev.setFileType(file.getContentType());
        ev.setData(file.getBytes());
        eventsRepository.save(ev);
        return this.afficherTousLesEvenements();
    }

    @Override
    @Transactional
    public int nbrDonation() {
        return eventsRepository.nbrDonation();
    }


}
