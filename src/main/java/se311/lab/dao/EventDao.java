package se311.lab.dao;

import se311.lab.entity.Event;

import org.springframework.data.domain.Page;

public interface EventDao {
    Integer getEventSize();
    Page<Event> getEvents(Integer pageSize, Integer page);
    Event getEvent(Long id);

    Event saveEvent(Event event);
}
