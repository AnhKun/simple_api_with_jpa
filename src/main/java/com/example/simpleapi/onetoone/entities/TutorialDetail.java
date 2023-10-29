package com.example.simpleapi.onetoone.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tutorial_detail")
public class TutorialDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date createdOn;
    private String createdBy;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tutorial_id")
    private Tutorial tutorial;
}
