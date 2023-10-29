package com.example.simpleapi.onetoone.services;

import com.example.simpleapi.onetoone.dtos.TutorialDetailDto;

public interface ITutorialDetailService {

    TutorialDetailDto getDetailById(long id);

    void createDetail(long tutorialId, TutorialDetailDto tutorialDetailDto) throws Exception;

    void updateDetail(long id, TutorialDetailDto tutorialDetailDto);


}
