package com.github.jlgrock.snp.classifier.examples;

import gov.vha.isaac.ochre.api.LookupService;
import gov.vha.isaac.ochre.api.constants.Constants;
import gov.vha.isaac.ochre.api.memory.HeapUseTicker;
import gov.vha.isaac.ochre.api.progress.ActiveTasksTicker;

import java.io.IOException;

/**
 *
 */
public abstract class AbstractQuery {
    protected void setup() {
        System.setProperty(Constants.DATA_STORE_ROOT_LOCATION_PROPERTY, "/Users/jlgrock/workspace/snp/data");
        LookupService.startupIsaac();
        HeapUseTicker.start(10);
        ActiveTasksTicker.start(10);
    }

    protected void teardown() {
        HeapUseTicker.stop();
        ActiveTasksTicker.stop();
        LookupService.shutdownIsaac();
        System.out.println("System down...");
    }

    protected abstract void search() throws IOException;

    public void execute() {
        setup();
        try {
            search();
        } catch(IOException ioe) {
            //TODO
        }
        teardown();

        // If you don't System.exit(0), it seems to keep running in the background.  Not sure what causes this
        System.exit(0);
    }
}
