package com.example.EventWebService.service;

import com.example.EventWebService.entity.Event;
import com.example.EventWebService.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public Event updateEvent(Event event) {
        Event existingEvent = repository.findById(event.getEventId()).orElse(null);
        assert existingEvent != null;
        existingEvent.setEventName(event.getEventName());
        existingEvent.setEventDescription(event.getEventDescription());
        existingEvent.setEventDate(event.getEventDate());
        existingEvent.setLocation(event.getLocation());
        existingEvent.setOrganizer(event.getOrganizer());
        existingEvent.setCategory(event.getCategory());
        return repository.save(existingEvent);
    }

    public String deleteEvent(String taskId) {
        repository.deleteById(taskId);
        return "Event removed" + taskId;
    }
}
