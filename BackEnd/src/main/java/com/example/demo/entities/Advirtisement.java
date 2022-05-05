package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data

public class Advirtisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private  Long id ;
	private  String name ;
	private  Date addDateDebut ;
	private  Date addDateFin; 
	private  Integer initialViewsNumber ;
	private  Integer finalViewsNumber ;
	private  String channel ;
	private AdType adType ;
	
	@ManyToOne
	private User userAds;
	

}
