package com.example.EventWebService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Event entity
 * This class is used to create a document in the MongoDB database
 * @Document(collection = "events") - specifies the collection name in the MongoDB database
 * Lombok annotations are used to generate getters, setters, constructors, and toString methods
 */

@Document(collection = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    private String eventId;
    private String eventName;
    private String eventDescription;
    private String eventDate;
    private String location;
    private String organizer;
    private String category;


    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
