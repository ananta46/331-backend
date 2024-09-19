package se311.lab.service;

import org.springframework.data.domain.Page;
import se311.lab.entity.Event;

import java.util.List;

public interface EventService {
    Integer getEventSize();
    Page<Event> getEvents(Integer pageSize, Integer page);
    Event getEvent(Long id);

}
