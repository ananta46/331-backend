package se311.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se311.lab.entity.Event;
import se311.lab.entity.Organizer;
import se311.lab.service.EventService;
import se311.lab.service.OrgService;

@Controller
@RequiredArgsConstructor
public class OrgController {

    final OrgService orgService;

    @GetMapping("orgs")
    public ResponseEntity<?> getEventList(
            @RequestParam(value = "_limit", required = false)Integer perPage,
            @RequestParam(value = "_page", required = false)Integer page) {
        if(page == null){
            page = 1;
        }
        if(perPage == null){
            perPage = 1;
        }

        Page<Organizer> pageOutput = orgService.getOrgs(perPage, page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(pageOutput.getContent(),responseHeader,HttpStatus.OK);
    }

    @GetMapping("orgs/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Organizer output = orgService.getOrg(id);
        if (output != null){
            return ResponseEntity.ok(output);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }
    @PostMapping("/orgs")
    public ResponseEntity<?> addOrganizer(@RequestBody Organizer Organizer) {
        Organizer output = orgService.saveOrg(Organizer);
        return ResponseEntity.ok(output);
    }
}
