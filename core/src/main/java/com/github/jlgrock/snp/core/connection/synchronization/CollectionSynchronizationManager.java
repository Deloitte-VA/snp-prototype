package com.github.jlgrock.snp.core.connection.synchronization;

import com.github.jlgrock.snp.apis.connection.synchronization.TransactionSynchronizationManager;

/**
 * A thread-safe synchronization mechanism based on a particular collection.
 */
public class CollectionSynchronizationManager implements TransactionSynchronizationManager {

    /**
     * @return true if the collection is locked, false otherwise
     */
    public boolean isSynchronizedWithTransaction() {

    }

    /**
     * @return set the synchronization on a particular collection
     */
    public void setSynchronizedWithTransaction(final String collection) {
        //TODO
    }

    @Override
    public boolean isActive() {
        // TODO
        return false;
    }
}
