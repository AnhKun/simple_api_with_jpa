package com.example.simpleapi.onetoone.services;

import com.example.simpleapi.onetoone.dtos.TutorialDetailDto;

public interface ITutorialDetailService {

    public TutorialDetailDto getDetailById(long id) throws Exception;

    public void createDetail(long tutorialId, TutorialDetailDto tutorialDetailDto) throws Exception;

    public void updateDetail(long id, TutorialDetailDto tutorialDetailDto);


}
