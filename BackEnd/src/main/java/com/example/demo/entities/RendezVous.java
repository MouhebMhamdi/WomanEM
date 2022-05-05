package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rendez_vous")
public class RendezVous {
    @Id
    @GeneratedValue
    (strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer idRdv;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRendezVous;

    @ManyToOne
    @JsonIgnore
    private Lawyer lawyer;

    @ManyToOne
    @JsonIgnore
    private Doctor doctor;
    
    @ManyToOne
    @JsonIgnore
    private User userRdv;
}
