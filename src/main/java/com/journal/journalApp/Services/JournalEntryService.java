package com.journal.journalApp.Services;

import com.journal.journalApp.Entity.JournalEntry;
import com.journal.journalApp.Entity.User;
import com.journal.journalApp.Repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;
    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName) {
        try{
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
//            user.setUsername(null);
            userService.saveUser(user);

        }catch(Exception e)
        {
            log.error("Error", e);
        }

    }
    public void saveEntry(JournalEntry journalEntry) {
        try{
            journalEntryRepository.save(journalEntry);

        }catch(Exception e)
        {
            log.error("Error", e);
        }

    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName) {
        boolean b=false;
        try {
            User user = userService.findByUserName(userName);
             b = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (b == true) {
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);

            }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occured while saving the entry", e);
        }
        return b;
    }
}
