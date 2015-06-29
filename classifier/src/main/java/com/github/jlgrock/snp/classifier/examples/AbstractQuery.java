package com.github.jlgrock.snp.classifier.examples;

import gov.vha.isaac.ochre.api.LookupService;
import gov.vha.isaac.ochre.api.constants.Constants;
import gov.vha.isaac.ochre.api.memory.HeapUseTicker;
import gov.vha.isaac.ochre.api.progress.ActiveTasksTicker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Shared functionality for the majority of the examples.
 */
public abstract class AbstractQuery {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractQuery.class);

    /**
     * Setup the database
     */
    protected void setup() {
        // TODO this needs to not be hard coded
        System.setProperty(Constants.DATA_STORE_ROOT_LOCATION_PROPERTY, "/Users/jlgrock/workspace/snp/data/1.9-data");
        LookupService.startupIsaac();
        HeapUseTicker.start(10);
        ActiveTasksTicker.start(10);
    }

    /**
     * Teardown the database and exit the system
     */
    protected void teardown() {
        HeapUseTicker.stop();
        ActiveTasksTicker.stop();
        LookupService.shutdownIsaac();
        LOGGER.info("System down...");
    }

    /**
     * Execute a classifier example after a database has been setup.
     *
     * @throws IOException if there are any issues with
     */
    protected abstract void run() throws IOException;

    /**
     * set up the database, run the example, and tear down the database
     */

    public void execute() {
        setup();
        try {
            run();
        } catch(IOException ioe) {
            //TODO
        }
        teardown();

        // If you don't System.exit(0), it seems to keep running in the background.  Not sure what causes this
        System.exit(0);
    }
}
