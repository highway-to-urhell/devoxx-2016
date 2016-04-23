package org.jhipster.blog.web.rest.dev;

import com.codahale.metrics.annotation.Timed;
import org.jhipster.blog.domain.Entry;
import org.jhipster.blog.repository.EntryRepository;
import org.jhipster.blog.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@RequestMapping("/api/entries")
public class EntryDevResource {

    private final Logger log = LoggerFactory.getLogger(BlogDevResource.class);

    @Inject
    private EntryRepository entryRepository;

    @RequestMapping(value = "/dev/deleteAll",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public String deleteAll() {
        log.debug("DON'T USE IN PRODUCTION REST request to delete All ENTRY : ");
        List<Entry> listAllEntry = entryRepository.findAll();
        for(Entry entryTodelete : listAllEntry){
            entryRepository.delete(entryTodelete.getId());
        }
        return "All deleted !";
    }


   @RequestMapping(value = "/dev/dump",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<Entry> dump() {
        log.debug("DON'T USE IN PRODUCTION REST request to dump All ENTRY : ");
        List<Entry> listAllEntry  = entryRepository.findAll();
        return listAllEntry;
    }

    
  
}
