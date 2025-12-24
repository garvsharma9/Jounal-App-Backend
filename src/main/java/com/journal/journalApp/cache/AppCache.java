package com.journal.journalApp.cache;

import com.journal.journalApp.Entity.ConfigJournalAppEntity;
import com.journal.journalApp.Repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {
    
    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;
    public Map<String, String> APP_CACHE=new HashMap<>();
        @PostConstruct
        public void init()
        {

            List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();
            for(ConfigJournalAppEntity configJournalAppEntity:all)
            {
                APP_CACHE.put(configJournalAppEntity.getConfigKey(), configJournalAppEntity.getConfigValue());
            }
//            appCache=null;
        }
}
