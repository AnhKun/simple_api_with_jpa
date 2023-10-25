package com.example.simpleapi.onetoone.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TutorialDto {
    private long id;
    private String title;
    private String description;
    private boolean published;
}
