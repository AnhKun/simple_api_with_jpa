package com.example.simpleapi.onetoone.services.impl;

import com.example.simpleapi.onetoone.converter.Mapper;
import com.example.simpleapi.onetoone.dtos.TutorialDetailDto;
import com.example.simpleapi.onetoone.entities.Tutorial;
import com.example.simpleapi.onetoone.entities.TutorialDetail;
import com.example.simpleapi.onetoone.repositories.ITutorialDetailRepository;
import com.example.simpleapi.onetoone.repositories.ITutorialRepository;
import com.example.simpleapi.onetoone.services.ITutorialDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ITutorialDetailServiceImpl implements ITutorialDetailService {
/*
    @Autowired
    public ITutorialDetailRepository detailRepository;
    @Autowired
    public ITutorialRepository tutorialRepository;
    @Autowired
    public Mapper mapper;



 */
    private final ITutorialDetailRepository detailRepository;
    private final ITutorialRepository tutorialRepository;

    private final Mapper mapper;



    @Override
    public TutorialDetailDto getDetailById(long id){
        TutorialDetail tutorialDetail = detailRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("cannot find id"));

        return mapper.toModel(tutorialDetail, TutorialDetailDto.class);
    }

    @Override
    public void createDetail(long tutorialId, TutorialDetailDto tutorialDetailDto) throws Exception{
        Tutorial tutorial = tutorialRepository.findById(tutorialId)
                .orElseThrow(() -> new Exception("Not found"));
        TutorialDetail tutorialDetail = mapper.toModel(tutorialDetailDto, TutorialDetail.class);
        tutorialDetail.setCreatedOn(new java.util.Date());
        tutorialDetail.setTutorial(tutorial);
        detailRepository.save(tutorialDetail);
    }

    @Override
    public void updateDetail(long id, TutorialDetailDto tutorialDetailDto) {
        Optional<TutorialDetail> tutorialDetail = detailRepository.findById(id);
        if (tutorialDetail.isPresent()){
            tutorialDetail.get().setCreatedOn(new java.util.Date());
            tutorialDetail.get().setCreatedBy(tutorialDetailDto.getCreatedBy());
            detailRepository.save(tutorialDetail.get());
        }
    }
}
