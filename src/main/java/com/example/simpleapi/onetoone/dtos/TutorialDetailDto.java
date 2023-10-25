package com.example.simpleapi.onetoone.dtos;

import com.example.simpleapi.onetoone.entities.Tutorial;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TutorialDetailDto {
    private long id;
    private Date createdOn;
    private String createdBy;
    //private TutorialDto tutorial;
}
