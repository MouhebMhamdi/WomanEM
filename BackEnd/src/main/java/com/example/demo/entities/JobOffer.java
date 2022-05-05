package com.example.demo.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

	@Table( name = "JobOffer")
	public class JobOffer implements Serializable{
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name="idOffer")
		private Long idOffer; // Clé primaire
		private String description;
		
		//relation avec jobapplication
		@OneToMany(mappedBy="jobOffers")
		private Set<JobApplication> jobApplications;
		
		//relation avec user
		//@ManyToOne
		//User user;

		//getters setters
		public Long getIdOffer() {
			return idOffer;
		}

		public void setIdOffer(Long idOffer) {
			this.idOffer = idOffer;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Set<JobApplication> getJobApplications() {
			return jobApplications;
		}

		public void setJobApplications(Set<JobApplication> jobApplications) {
			this.jobApplications = jobApplications;
		}

		
		
		
		
}
