package com.glosario.gterminosSNAPSHOT.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "words")
public class Word implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long words_id;
    private String word;
    private String definition;
    private String notes;
    private long project_id;

    Word() {
        // default constructor
    }

    public long getWords_id() {
        return words_id;
    }

    public void setWords_id(long words_id) {
        this.words_id = words_id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }
}
