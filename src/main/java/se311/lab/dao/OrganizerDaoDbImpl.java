package se311.lab.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se311.lab.dao.OrgDao;
import se311.lab.entity.Organizer;
import se311.lab.repository.OrganizerRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class OrganizerDaoDbImpl implements OrgDao {
    final OrganizerRepository OrganizerRepository;

    @Override
    public Integer getOrganizerSize() {
        return Math.toIntExact(OrganizerRepository.count());
    }
    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        return OrganizerRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return OrganizerRepository.findById(id).orElse(null);
    }

    @Override
    public Organizer saveOrg(Organizer Organizer) {
        return OrganizerRepository.save(Organizer);
    }
}