package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.domain.converters.ClassifiedAssertionWriteConverter;
import com.github.jlgrock.snp.domain.converters.ClassifiedPceReadConverter;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import com.mongodb.DBObject;

import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 * This class executes queries against the ClassifiedAssertion 
 * Collection within MongoDB.
 */
@Service(name="classifiedPceRepository")
public class ClassifiedPceRepositoryImpl extends AbstractRepositoryImpl<ClassifiedPce, Long> implements ClassifiedPceRepository {

	private final ClassifiedPceReadConverter classifiedAssertionReadConverter;

	private final ClassifiedAssertionWriteConverter classifiedAssertionWriteConverter;

	/**
	 * @param mongoDbFactoryIn MongoDbFactory
	 * @param classifiedAssertionReadConverterIn ClassifiedAssertionReadConverter
	 * @param classifiedAssertionWriteConverterIn ClassifiedAssertionWriteConverter
	 */
	@Inject
    public ClassifiedPceRepositoryImpl(final MongoDbFactory mongoDbFactoryIn,
									   final ClassifiedPceReadConverter classifiedAssertionReadConverterIn,
									   final ClassifiedAssertionWriteConverter classifiedAssertionWriteConverterIn) {
        super(mongoDbFactoryIn);
		classifiedAssertionReadConverter = classifiedAssertionReadConverterIn;
		classifiedAssertionWriteConverter = classifiedAssertionWriteConverterIn;
    }

	@Override
	protected ClassifiedPce convertToDomainObject(final DBObject dbObjectin) {
		return classifiedAssertionReadConverter.convert(dbObjectin);
	}

	@Override
	protected DBObject convertToDBObject(final ClassifiedPce s) {
		return classifiedAssertionWriteConverter.convert(s);
	}

    @Override
    protected String getCollectionName() {
        return "pces";
    }
}
