package com.example.EventWebService.service;

import com.example.EventWebService.entity.Event;
import com.example.EventWebService.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service class to handle business logic for Event entity
 * The class is annotated with @Service to indicate that it is a service class
 * The class is autowired with EventRepository to perform CRUD operations on Event entity
 * The class contains methods to add, update, delete and retrieve events
 */
@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public Event addEvent(Event event) {
        event.setEventId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(event);
    }

    public List<Event> findAllEvents() {
        return repository.findAll();
    }

    public Event getEventByEventId(String eventId) {
        return repository.findById(eventId).get();
    }

    public String deleteEvent(String eventId) {
        Optional<Event> event = repository.findById(eventId);
        if (event.isPresent()) {
            repository.deleteById(eventId);
            return "Event removed: " + eventId;
        } else {
            throw new RuntimeException("Event not found with id: " + eventId);
        }
    }

    public Event updateEvent(Event event) {
        String eventId = event.getEventId();
        if (eventId == null || eventId.isEmpty()) {
            throw new RuntimeException("Event id cannot be null or empty");
        }
        Optional<Event> existingEventOpt = repository.findById(eventId);
        if (existingEventOpt.isPresent()) {
            Event existingEvent = existingEventOpt.get();
            existingEvent.setEventName(event.getEventName());
            existingEvent.setEventDescription(event.getEventDescription());
            existingEvent.setEventDate(event.getEventDate());
            existingEvent.setLocation(event.getLocation());
            existingEvent.setOrganizer(event.getOrganizer());
            existingEvent.setCategory(event.getCategory());
            return repository.save(existingEvent);
        } else {
            throw new RuntimeException("Event not found with id: " + eventId);
        }
    }
}


