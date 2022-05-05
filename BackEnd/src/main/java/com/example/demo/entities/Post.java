package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String postTitle;
	private String PostBody;
	private Integer likes;
	private Integer disLikes;
	
	
	
	
	@ManyToOne
	private User userPost;
	
	@OneToMany(mappedBy = "post"  , cascade=CascadeType.ALL)
	private List<Comment>comments =new ArrayList<>();
	
	
	
	
}
