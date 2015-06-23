package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 * Store Assertions from LEGO document which have been replaced
 * with a classifier ID to the MongoDB
 *
 */
@Service
public class ClassifiedPceMongoDbStore implements ClassifiedPceStore {
	private final ClassifiedPceRepository classifiedPceRepository;

    /**
     * Create the assertion store
     * @param classifiedPceRepositoryIn the classifier repository, used for querying
     */
	@Inject
	public ClassifiedPceMongoDbStore(final ClassifiedPceRepository classifiedPceRepositoryIn) {
		classifiedPceRepository = classifiedPceRepositoryIn;
	}
	
	@Override
	public void save(final ClassifiedPce classifiedPce) {
		classifiedPceRepository.save(classifiedPce);
	}
}
