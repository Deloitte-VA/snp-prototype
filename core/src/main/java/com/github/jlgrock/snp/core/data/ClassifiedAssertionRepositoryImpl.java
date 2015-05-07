package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.ClassifiedAssertionReadConverter;
import com.github.jlgrock.snp.core.converters.ClassifiedAssertionWriteConverter;
import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import com.mongodb.DBObject;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 * This class executes queries against the ClassifiedAssertion 
 * Collection within MongoDB.
 */
@Service
public class ClassifiedAssertionRepositoryImpl extends AbstractRepositoryImpl<ClassifiedAssertion, Long> implements ClassifiedAssertionRepository {

	private final ClassifiedAssertionReadConverter classifiedAssertionReadConverter;

	private final ClassifiedAssertionWriteConverter classifiedAssertionWriteConverter;

	/**
	 * Constructs a ClassifiedAssertionRepositoryImpl
	 * @param mongoDbFactoryIn MongoDbFactory
	 * @param classifiedAssertionReadConverterIn ClassifiedAssertionReadConverter
	 * @param classifiedAssertionWriteConverterIn ClassifiedAssertionWriteConverter
	 */
	@Inject
    public ClassifiedAssertionRepositoryImpl(final MongoDbFactory mongoDbFactoryIn,
											 final ClassifiedAssertionReadConverter classifiedAssertionReadConverterIn,
											 final ClassifiedAssertionWriteConverter classifiedAssertionWriteConverterIn) {
        super(mongoDbFactoryIn);
		classifiedAssertionReadConverter = classifiedAssertionReadConverterIn;
		classifiedAssertionWriteConverter = classifiedAssertionWriteConverterIn;
    }

	@Override
	protected ClassifiedAssertion convertToDomainObject(final DBObject dbObjectin) {
		return classifiedAssertionReadConverter.convert(dbObjectin);
	}

	@Override
	protected DBObject convertToDBObject(final ClassifiedAssertion s) {
		return classifiedAssertionWriteConverter.convert(s);
	}

    @Override
    protected String getCollectionName() {
        return "pces";
    }
}
