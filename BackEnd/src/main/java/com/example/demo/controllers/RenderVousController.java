package com.example.demo.controllers;

import com.example.demo.entities.RendezVous;
import com.example.demo.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/rendezVous")

public class RenderVousController {

    @Autowired
    private RendezVousService rendezVousService;



    @GetMapping("all")
    public List<RendezVous> getAllRdv(){
        return  rendezVousService.getAllRendezVous();
    }

    @GetMapping("/{idRdv}")
    public RendezVous getRdVById(@PathVariable Integer idRdv){
        return rendezVousService.getRdvById(idRdv);
    }

    @PutMapping("/{idRdv}")
    public RendezVous updateRdv(@PathVariable Integer idRdv,@RequestBody RendezVous rendezVous){
        return rendezVousService.updateRdv(idRdv,rendezVous);
    }
    @DeleteMapping("/all")
    public String deleteAll(){
         rendezVousService.deleteAllRdv();
        return "All rdv deleted";
    }

    @DeleteMapping("/{id}")
    public  List<RendezVous> deleteById(@PathVariable Integer id){
        rendezVousService.deleteRendezVous(id);
        return this.getAllRdv();
    }

    @PostMapping("add/{idDoc}/{idLoyer}/{idUser}")
    public RendezVous addRdvAndAffectDoctorAndLoyerAndUser(@RequestBody RendezVous rendezVous, @PathVariable Integer idDoc, @PathVariable Integer idLoyer, @PathVariable Long idUser){
        return rendezVousService.addRdvAndAffecterDoctorAndLoyerAndUser(rendezVous,idDoc,idLoyer,idUser);
    }
}
