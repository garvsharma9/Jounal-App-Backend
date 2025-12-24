package com.journal.journalApp.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document("config_journal_app")
@Data
@NoArgsConstructor
public class ConfigJournalAppEntity {
    private String configKey;
    private String configValue;
}
