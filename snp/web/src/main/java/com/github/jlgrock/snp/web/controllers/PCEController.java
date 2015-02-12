package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.core.data.PCERepository;
import com.github.jlgrock.snp.core.domain.PCE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@RequestMapping("/pce")
public class PCEController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PCEController.class);

    @Autowired
    private PCERepository repository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    PCE getPCE(@PathVariable final Long id) {
        LOGGER.debug("getting encounter");
        return repository.findOne(id);
    }
}
