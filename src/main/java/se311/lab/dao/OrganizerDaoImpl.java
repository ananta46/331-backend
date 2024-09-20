package se311.lab.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se311.lab.entity.Organizer;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual-organizer")
public class OrganizerDaoImpl implements OrgDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();

        organizerList.add(Organizer.builder()
                .id(1L)
                .organizer("Animal Welfare Organization")
                .location("123 Meow Town")
                .build());

        organizerList.add(Organizer.builder()
                .id(2L)
                .organizer("Community Gardeners")
                .location("456 Flora City")
                .build());

        // Add more organizers as needed
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<>(organizerList.subList(firstIndex, firstIndex + pageSize), PageRequest.of(page, pageSize), organizerList.size());
    }


    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream()
                .filter(organizer -> organizer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Organizer saveOrg(Organizer organizer) {
        organizer.setId(organizerList.get(organizerList.size() - 1).getId() + 1);
        organizerList.add(organizer);
        return organizer;
    }
}