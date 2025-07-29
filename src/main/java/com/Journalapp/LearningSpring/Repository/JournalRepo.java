package com.Journalapp.LearningSpring.Repository;

import com.Journalapp.LearningSpring.entity.Journal;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepo extends MongoRepository<Journal, ObjectId> {

}
