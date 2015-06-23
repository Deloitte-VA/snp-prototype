package com.github.jlgrock.snp.domain.connection.synchronization;

import com.github.jlgrock.snp.apis.connection.synchronization.TransactionSynchronizationManager;
import org.jvnet.hk2.annotations.Service;

/**
 * A thread-safe synchronization mechanism based on a particular collection.
 */
@Service
public class CollectionSynchronizationManager implements TransactionSynchronizationManager {

    /**
     * @return {@literal true} if the collection is locked, {@literal false} otherwise
     */
    public boolean isSynchronizedWithTransaction() {
        //TODO
        return false;
    }

    /**
     * Sets the synchronization per collection
     * @param collection the collection to set the synchronization token
     * @param setSynchronized the value to set the lock
     */
    public void setSynchronizedWithTransaction(final String collection, final boolean setSynchronized) {
        //TODO
    }

    @Override
    public boolean isActive() {
        // TODO
        return false;
    }
}
