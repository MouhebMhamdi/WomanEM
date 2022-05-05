package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "TEXT")
	private String msgBody;

    @Column(columnDefinition = "TEXT")
	private String msgSubject;

	@Column(name = "readbysender")
	private Boolean readBySender;

	@Column(name = "readbyrecipient")
	private Boolean readByRecipient;
	
	
	
	    @ManyToOne
	    private User sender;

	    @ManyToOne
	    private User recipient;
	

}
