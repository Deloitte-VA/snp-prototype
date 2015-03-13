package com.github.jlgrock.snp.core.connection.synchronization;

/**
 * Manager synchronizations at many possible levels in the code.
 */
public interface TransactionSynchronizationManager {
    /**
     * Whether or not the transaction synchonization manager is active, vs disabled.
     * @return true/false
     */
    public boolean isActive();

}
