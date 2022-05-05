package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.Data;

@Entity
@Data
public class TrainingSession {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTS;
	
	private String title;
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	private Date dure;
	
	private String localisation;
	
	private String descriptionOfTS;
	
	private Integer x;
	
	private Integer y;
	
	@OneToMany(mappedBy = "trainingSession", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Question> questions;
	
	@OneToOne
	private Certificate certificate;
	
	@ManyToOne
	private User userTraining;

}
