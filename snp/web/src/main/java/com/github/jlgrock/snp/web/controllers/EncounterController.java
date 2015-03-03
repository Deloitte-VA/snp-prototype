package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.core.data.EncounterRepository;
import com.github.jlgrock.snp.core.domain.Encounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jlgrock on 1/11/15.
 */

@RestController
@RequestMapping("/encounter")
public class EncounterController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EncounterController.class);
   
    
    @Autowired
    private EncounterRepository repository;
    /**
     * 
     * @param pid encounter id used for search
     * @return returns an encounter
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Encounter getEncounter(@PathVariable final Long pid) {
        LOGGER.debug("getting encounter");
        return repository.findOne(pid);
    }
    
    
    /* Just for temporary testing of WAR file. Comment Autowired repository var. And used the method below.
     * But currently this method gives "Could not find acceptable representation" error. */
    /*
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Encounter getEncounter(@PathVariable final Long id) {
        LOGGER.debug("getting encounter");
        return  new Encounter(); //repository.findOne(id);
    }
    */
    
    
    /* Returning String object works with the browser without any problem during testing */
    /*
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getEncounter(@PathVariable final Long id) {
        LOGGER.debug("getting encounter");
        return  "Hello Encounter Service"; //repository.findOne(id);
    }
    */
}
