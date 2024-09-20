package se311.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se311.lab.dao.OrgDao;
import se311.lab.entity.Event;
import se311.lab.entity.Organizer;

@Service
@RequiredArgsConstructor
public class OrgServiceImpl implements OrgService {
    final OrgDao orgDao;
    @Override
    public Integer getOrgSize() {
        return orgDao.getOrganizerSize();
    }

    @Override
    public Page<Organizer> getOrgs(Integer pageSize, Integer page) {
        return orgDao.getOrganizers(pageSize, page);
    }

    @Override
    public Organizer getOrg(Long id) {
        return orgDao.getOrganizer(id);
    }
    @Override
    public Organizer saveOrg(Organizer organizer) {
        return orgDao.saveOrg(organizer);
    }
}
