package com.glosario.gterminosSNAPSHOT.service;

import com.glosario.gterminosSNAPSHOT.configuration.PageSettings;
import com.glosario.gterminosSNAPSHOT.model.Project;
import com.glosario.gterminosSNAPSHOT.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public Page<Project> getProjectPage(@NonNull PageSettings pageSetting) {

        Sort projectSort = pageSetting.buildSort();
        Pageable wordPage = PageRequest.of(pageSetting.getPage(), pageSetting.getElementPerPage(), projectSort);

        return projectRepository.findAll(wordPage);
    }



}
