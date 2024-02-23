package com.example.EventWebService;

import com.example.EventWebService.entity.Event;
import com.example.EventWebService.repository.EventRepository;
import com.example.EventWebService.service.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class EventServiceTests {

    @Mock
    private EventRepository repository;

    @InjectMocks
    private EventService eventService;


    @Test
    void getEventById() {
        String eventId = "1";
        Event mockEvent = new Event();
        mockEvent.setEventId(eventId);
        mockEvent.setEventName("MockEvent");
        mockEvent.setLocation("MockLocation");
        mockEvent.setEventDate("MockDate");

        when(repository.findById(eventId)).thenReturn(Optional.of(mockEvent));

        Event result = eventService.getEventByEventId(eventId);

        assertEquals(mockEvent, result);

        verify(repository, times(1)).findById(eventId);
    }

    @Test
    void saveEvent() {
        Event mockEvent = new Event();
        mockEvent.setEventName("MockEvent");

        when(repository.save(mockEvent)).thenReturn(mockEvent);

        Event result = eventService.addEvent(mockEvent);

        assertEquals(mockEvent, result);

        verify(repository, times(1)).save(mockEvent);
    }

    @Test
    void deleteEvent() {
        String eventId = "1";
        Event mockEvent = new Event();
        mockEvent.setEventId(eventId);

        when(repository.findById(eventId)).thenReturn(Optional.of(mockEvent));

        assertDoesNotThrow(() -> eventService.deleteEvent(eventId));

        verify(repository, times(1)).findById(eventId);
        verify(repository, times(1)).deleteById(eventId);
    }

    @Test
    void updateEvent() {
        String eventId = "1";
        Event existingEvent = new Event();
        existingEvent.setEventId(eventId);
        existingEvent.setEventName("ExistingEvent");

        Event updatedEvent = new Event();
        updatedEvent.setEventId(eventId);
        updatedEvent.setEventName("UpdatedEvent");

        when(repository.findById(eventId)).thenReturn(Optional.of(existingEvent));
        when(repository.save(updatedEvent)).thenReturn(updatedEvent);

        Event result = eventService.updateEvent(updatedEvent);

        assertEquals(updatedEvent, result);

        verify(repository, times(1)).findById(eventId);
        verify(repository, times(1)).save(updatedEvent);
    }
}
