package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.core.data.PCERepository;
import com.github.jlgrock.snp.core.domain.PCE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Controller serving up domain objects for PCE objects.
 */
@RestController
@RequestMapping("/pce")
public class PCEController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PCEController.class);

    @Autowired
    private PCERepository repository;

    /**
     * get a single PCE.
     *
     * @param id the id of the PCE to get
     * @return the PCE to return to the client
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PCE getPCE(@PathVariable final Long id) {
        LOGGER.debug("getting encounter");
        return repository.findOne(id);
    }
}
