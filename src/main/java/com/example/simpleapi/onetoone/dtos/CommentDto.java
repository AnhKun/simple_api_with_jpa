package com.example.simpleapi.onetoone.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDto {
    private long id;
    private String content;

    private TutorialDto tutorial;
}
