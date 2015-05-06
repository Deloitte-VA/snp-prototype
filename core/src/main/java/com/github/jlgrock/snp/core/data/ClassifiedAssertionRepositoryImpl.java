package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.ClassifiedPceReadConverter;
import com.github.jlgrock.snp.core.converters.ClassifiedAssertionWriteConverter;
import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import com.mongodb.DBObject;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 *
 */
@Service
public class ClassifiedAssertionRepositoryImpl extends AbstractRepositoryImpl<ClassifiedPce, Long> implements ClassifiedAssertionRepository {

	private final ClassifiedPceReadConverter classifiedAssertionReadConverter;

	private final ClassifiedAssertionWriteConverter classifiedAssertionWriteConverter;

	@Inject
    public ClassifiedAssertionRepositoryImpl(final MongoDbFactory mongoDbFactoryIn,
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
