package se311.lab.service;

import org.springframework.data.domain.Page;
import se311.lab.entity.Event;
import se311.lab.entity.Organizer;

public interface OrgService {
    Integer getOrgSize();
    Page<Organizer> getOrgs(Integer pageSize, Integer page);
    Organizer getOrg(Long id);
    Organizer saveOrg(Organizer organizer);


}
