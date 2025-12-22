package com.journal.journalApp.Repository;

import com.journal.journalApp.Entity.JournalEntry;
import com.journal.journalApp.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUsername(String username);

    void deleteUserByUsername(String name);
}
