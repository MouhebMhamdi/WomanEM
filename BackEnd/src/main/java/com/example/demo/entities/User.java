package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;


@Entity
@Setter
@Getter
@AllArgsConstructor
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max =21)
	private String username;
	
	@NotBlank
	@Size(max = 51)
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 110)
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Role>roles= new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userPost")
	private List<Post> posts=new ArrayList<>();
	
	
	
	@OneToMany(mappedBy =   "sender", cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<>();
 
 
 
   @OneToMany(mappedBy =   "recipient", cascade = CascadeType.ALL)
    private List<Message> messagess = new ArrayList<>();
   
   @OneToMany(mappedBy =   "userAds", cascade = CascadeType.ALL)
   private List<Advirtisement>advirtisements  = new ArrayList<>();
   
   
   @OneToMany(mappedBy =   "userComment", cascade = CascadeType.ALL)
   private List<Comment> comments = new ArrayList<>();
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRdv")
   private List<RendezVous> rdv = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userLawyer")
	private List<Lawyer> lawyers= new  ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userDoctor")
	private List<Doctor> doctors = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userEvents")
	private List<Events>events = new ArrayList<>();
	
	@OneToMany(mappedBy = "userTraining",cascade = CascadeType.ALL)
	private List<TrainingSession> trainingsessions = new ArrayList<>();
	
	//relation avec jobApplication
		@OneToMany(mappedBy="user",  cascade = CascadeType.ALL)
		private Set<JobApplication> jobApplications;
	public User() {
	  }

	public User(String username, String email, String password) {
	    this.username = username;
	    this.email = email;
	    this.password = password;
	  }

}
