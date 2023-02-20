package com.glosario.gterminosSNAPSHOT.repository;

import com.glosario.gterminosSNAPSHOT.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Para ejecutar operaciones CRUD (Create, Read, Update, and Delete)
 * sobre la entidad word, necesitamos tener un word repository.
 * Para hacerlo usamos la extension CrudRepository y anotamos la interfaz con @Repository.
 */

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
}
