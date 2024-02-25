package com.example.EventWebService.controller;

import com.example.EventWebService.entity.Event;
import com.example.EventWebService.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is the controller for the Event entity. It is responsible for handling HTTP requests and returning responses.
 * It is also responsible for mapping the requests to the appropriate service methods.
 * The controller is annotated with @RestController to indicate that it is a controller class.
 * The @RequestMapping annotation is used to map the requests to the appropriate methods.
 * The @Autowired annotation is used to inject the EventService dependency into the controller.
 */
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

    @PutMapping("/{eventId}")
    public Event updateEvent(@PathVariable String eventId, @RequestBody Event event) {
        return service.updateEvent(event);
    }

    @DeleteMapping("/{eventId}")
    public String deleteEvent(@PathVariable String eventId) {
        return service.deleteEvent(eventId);
    }


}
