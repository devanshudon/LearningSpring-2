package com.Journalapp.LearningSpring.Controller;

import com.Journalapp.LearningSpring.entity.Journal;
import com.Journalapp.LearningSpring.service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {
    @Autowired
    JournalService journalService;

    @GetMapping
    public List<Journal> getJournals(){
        return journalService.getAll();
    }
    @PostMapping
    public void addJournal(@RequestBody Journal journal){
        journal.setDate(LocalDateTime.now());
         journalService.filldata(journal);
    }

    @GetMapping("/id/{myid}")
    public Journal getJournalById(@PathVariable ObjectId myid){
        return journalService.JournalById(myid).orElse(null);
    }

    @DeleteMapping("/id/{myid}")
    public void deleteJournal(@PathVariable ObjectId myid){
           journalService.delete(myid);
    }
}
