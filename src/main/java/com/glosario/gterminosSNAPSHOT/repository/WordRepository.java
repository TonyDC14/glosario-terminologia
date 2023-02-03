package com.glosario.gterminosSNAPSHOT.repository;

import com.glosario.gterminosSNAPSHOT.model.Word;
import org.springframework.data.repository.CrudRepository;

/**
 * Para ejecutar operaciones CRUD (Create, Read, Update, and Delete)
 * sobre la entidad word, necesitamos tener un word repository.
 * Para hacerlo usamos la extension CrudRepository y anotamos la interfaz con @Repository.
 */

public interface WordRepository extends CrudRepository<Word, Long> {
}
