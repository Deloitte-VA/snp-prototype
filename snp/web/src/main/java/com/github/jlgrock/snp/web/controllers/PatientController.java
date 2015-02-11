package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.core.data.PatientRepository;
import com.github.jlgrock.snp.core.domain.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@RequestMapping("/patient")
public class PatientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EncounterController.class);

    @Autowired
    private PatientRepository repository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Patient getPatient(@PathVariable final Long id) {
        LOGGER.debug("getting encounter");
        return repository.findOne(id);
    }
}
