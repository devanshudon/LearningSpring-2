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
        List<Journal> l=journalService.getAll();
        return l;
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
    @PutMapping("/id/{myid}")
    public void updateJournal(@PathVariable ObjectId myid, @RequestBody Journal journal){
        Journal Old = journalService.JournalById(myid).orElse(null);
        if(journal.getName()==null ||journal.getName().equals("")){
            journal.setName(Old.getName());
        }
        if(journal.getTitle()==null ||journal.getTitle().equals("")){
            journal.setTitle(Old.getTitle());
        }
        journal.setDate(Old.getDate());
        journalService.filldata(journal);
    }
}
