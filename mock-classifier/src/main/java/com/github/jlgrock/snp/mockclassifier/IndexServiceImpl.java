package com.github.jlgrock.snp.mockclassifier;

import gov.vha.isaac.ochre.api.chronicle.ObjectChronology;
import gov.vha.isaac.ochre.api.index.IndexService;
import gov.vha.isaac.ochre.api.index.IndexedGenerationCallable;

import java.io.File;
import java.util.concurrent.Future;

/**
 *
 */
public class IndexServiceImpl implements IndexService {

    @Override
    public void clearIndex() {

    }

    @Override
    public void closeWriter() {

    }

    @Override
    public void commitWriter() {

    }

    @Override
    public void forceMerge() {

    }

    @Override
    public IndexedGenerationCallable getIndexedGenerationCallable(int i) {
        return null;
    }

    @Override
    public File getIndexerFolder() {
        return null;
    }

    @Override
    public String getIndexerName() {
        return null;
    }

    @Override
    public Future<Long> index(ObjectChronology<?> objectChronology) {
        return null;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void setEnabled(boolean b) {

    }
}
