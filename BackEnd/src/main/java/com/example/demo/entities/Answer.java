package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;



@Entity
@Data

public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idanswer;


	@Size(min = 1, max = 1500, message = "The answer should be less than 150 characters")
	@NotBlank(message = "No answer text provided.")
	private String text;

	@ManyToOne
	private Question question;

	private int answerorder;

	
	@Temporal(TemporalType.DATE)
	private Date createddate;


	

}
