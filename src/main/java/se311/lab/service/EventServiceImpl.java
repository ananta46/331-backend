package se311.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se311.lab.dao.EventDao;
import se311.lab.entity.Event;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    final EventDao eventDao;
    @Override
    public Integer getEventSize() {
        return eventDao.getEventSize();
    }

    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page) {
        return eventDao.getEvents(pageSize, page);
    }
    @Override
    public Event getEvent(Long id) {
        return eventDao.getEvent(id);
    }

    @Override
    public Event saveEvent(Event event) {
        return eventDao.saveEvent(event);
    }
}
