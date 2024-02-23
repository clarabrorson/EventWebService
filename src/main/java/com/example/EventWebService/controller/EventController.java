package com.example.EventWebService.controller;

import com.example.EventWebService.entity.Event;
import com.example.EventWebService.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public List<Event> getEvents() {
        return service.findAllEvents();
    }

    @GetMapping("/{eventId}")
    public Event getEventByEventId(@PathVariable String eventId) {
        return service.getEventByEventId(eventId);
    }

    @PostMapping
    public Event addEvent(@RequestBody Event event) {
        return service.addEvent(event);
    }

    @PutMapping
    public Event updateEvent(@RequestBody Event event) {
        return service.updateEvent(event);
    }

    @DeleteMapping("/{eventId}")
    public String deleteEvent(@PathVariable String eventId) {
        return service.deleteEvent(eventId);
    }


}
