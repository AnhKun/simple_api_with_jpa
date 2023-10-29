package com.example.simpleapi.onetoone.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TutorialDetailDto {
    private long id;
    private Date createdOn;
    private String createdBy;
    private TutorialDto tutorial;
}
