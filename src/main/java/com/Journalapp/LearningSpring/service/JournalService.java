package com.Journalapp.LearningSpring.service;

import com.Journalapp.LearningSpring.Repository.JournalRepo;
import com.Journalapp.LearningSpring.entity.Journal;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalService {
    @Autowired
    private JournalRepo j;

    public void filldata(Journal j1){
        j.save(j1);
    }
    public List<Journal> getAll(){
        return j.findAll();
    }
    public Optional<Journal> JournalById(ObjectId id){
        return j.findById(id);
    }
    public void delete(ObjectId id){
         j.deleteById(id);
    }
}
