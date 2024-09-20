package se311.lab.dao;

import org.springframework.data.domain.Page;
import se311.lab.entity.Event;
import se311.lab.entity.Organizer;

import java.util.List;

public interface OrgDao {
    Integer getOrganizerSize();
    Page<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);
    //Organizer save(Organizer organizer);  // <-- Add this method
    Organizer saveOrg(Organizer organizer);
}