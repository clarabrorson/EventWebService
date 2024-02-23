package com.example.EventWebService.repository;

import com.example.EventWebService.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {
}
