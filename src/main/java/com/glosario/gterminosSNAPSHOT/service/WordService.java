package com.glosario.gterminosSNAPSHOT.service;

import com.glosario.gterminosSNAPSHOT.configuration.PageSettings;
import com.glosario.gterminosSNAPSHOT.model.Word;
import com.glosario.gterminosSNAPSHOT.repository.WordRepository;
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
public class WordService {

    private WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository wordRepository){
        this.wordRepository = wordRepository;
    }

    public Page<Word> getWordPage(@NonNull PageSettings pageSetting) {

        Sort wordSort = pageSetting.buildSort();
        Pageable wordPage = PageRequest.of(pageSetting.getPage(), pageSetting.getElementPerPage(), wordSort);

        return wordRepository.findAll(wordPage);
    }

}
