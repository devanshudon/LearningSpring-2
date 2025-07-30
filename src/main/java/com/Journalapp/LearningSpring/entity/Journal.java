package com.Journalapp.LearningSpring.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "journal_collection")
@Data
public class Journal {
    @Id
    private ObjectId id;
    private String title;
    private String name;
    private LocalDateTime date;

}
