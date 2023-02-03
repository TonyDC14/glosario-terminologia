package com.glosario.gterminosSNAPSHOT.controller;

import com.glosario.gterminosSNAPSHOT.model.Word;
import com.glosario.gterminosSNAPSHOT.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/word")
public class WordController {

    @Autowired // Para inyectar dependencia
    private WordRepository wordRepository;

    @GetMapping // Especifica tipo de peticion HTTP aceptada
    public List<Word> findAllWords(){
        return (List<Word>) wordRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Word> findWordById(@PathVariable(value = "id") long id){
        Optional<Word> word = wordRepository.findById(id);
        if(word.isPresent()){
            return ResponseEntity.ok().body(word.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping // Especifica tipo de peticion HTTP aceptada
    public Word saveWord(@Validated @RequestBody Word word){
        return wordRepository.save(word);
    }

}
