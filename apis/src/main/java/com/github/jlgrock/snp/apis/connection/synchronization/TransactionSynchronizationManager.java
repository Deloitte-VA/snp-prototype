package com.github.jlgrock.snp.apis.connection.synchronization;

import org.jvnet.hk2.annotations.Contract;

/**
 * Manager synchronizations at many possible levels in the code.
 */
@Contract
public interface TransactionSynchronizationManager {
    /**
     * Whether or not the transaction synchonization manager is active, vs disabled.
     * @return true/false
     */
    public boolean isActive();

}
