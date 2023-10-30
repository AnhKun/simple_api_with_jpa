package com.example.simpleapi.onetoone.dtos;

import com.example.simpleapi.onetoone.entities.Tutorial;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

    private long id;
    private String content;

    private TutorialDto tutorial;

}
