package com.example.demo.entities;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;



@Entity
@Data
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idQuestion;

	@Size(min = 2, max = 150, message = "The question should be between 2 and 150 characters")
	@NotBlank(message = "Question text not provided")
	private String questiontext;

	
	private Integer question_order;

	
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private List<Answer> answers;	
	
	@ManyToOne
	private TrainingSession trainingSession;

	
	@OneToOne
	private Answer correctAnswer;

	@Temporal(TemporalType.DATE)
	private Date createdDate;

	private Boolean isValid = false;



}
