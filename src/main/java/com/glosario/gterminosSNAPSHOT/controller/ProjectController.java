package com.glosario.gterminosSNAPSHOT.controller;

import com.glosario.gterminosSNAPSHOT.model.Project;
import com.glosario.gterminosSNAPSHOT.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired // Para inyectar dependencia
    private ProjectRepository projectRepository;

    @GetMapping // Especifica tipo de peticion HTTP aceptada
    public List<Project> findAllProjects(){
        return (List<Project>) projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> findProjectById(@PathVariable(value = "id") long id){
        Optional<Project> project = projectRepository.findById(id);
        if(project.isPresent()){
            return ResponseEntity.ok().body(project.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping // Especifica tipo de peticion HTTP aceptada
    public Project saveProject(@Validated @RequestBody Project project){
        return projectRepository.save(project);
    }

}
