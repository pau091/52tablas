package com.tarea.application.study.usecase;

import com.tarea.application.study.dto.StudyResponse;
import com.tarea.domain.study.port.repository.StudyRepository;

import java.util.List;

public class ListStudiesUseCase {

    private final StudyRepository studyRepository;

    public ListStudiesUseCase(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    public List<StudyResponse> execute() {
        return studyRepository.findAll().stream()
                .map(StudyResponse::fromDomain)
                .toList();
    }
}
