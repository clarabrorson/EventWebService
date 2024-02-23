package com.example.EventWebService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    }
}
