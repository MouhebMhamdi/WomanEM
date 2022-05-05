package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String eventTopic;
    private String Description;
    @Temporal(TemporalType.DATE)
    private Date date;

    private String fileName;
    private String fileType;

    @Lob
    private byte[] data;

    private String videoName;
    private String videoType;

    @Lob
    private byte[] dataVideo;


    @ManyToOne
    @JsonIgnore
    private User userEvents;
    @ManyToMany
    @JsonIgnore
    private List<Sponsor> sponsors = new ArrayList<>();

}
