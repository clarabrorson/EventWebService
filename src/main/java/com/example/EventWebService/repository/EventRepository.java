package com.example.EventWebService.repository;

import com.example.EventWebService.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * This interface extends the MongoRepository interface and is used to interact with the MongoDB database.
 */
public interface EventRepository extends MongoRepository<Event, String> {

    public Event findByEventName(String eventName);
}
