package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.ClassifiedAssertionReadConverter;
import com.github.jlgrock.snp.core.converters.ClassifiedAssertionWriteConverter;
import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import com.mongodb.DBObject;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 *
 */
@Service
public class ClassifiedAssertionRepositoryImpl extends AbstractRepositoryImpl<ClassifiedAssertion, Long> implements ClassifiedAssertionRepository {

	private final ClassifiedAssertionReadConverter classifiedAssertionReadConverter;

	private final ClassifiedAssertionWriteConverter classifiedAssertionWriteConverter;

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
		if(dbObjectin == null){return null;}
		else{
		return classifiedAssertionReadConverter.convert(dbObjectin);
		}
	}

	@Override
	protected DBObject convertToDBObject(final ClassifiedAssertion s) {
		if(s == null){return null;}
		else{
		return classifiedAssertionWriteConverter.convert(s);
		}
	}

    @Override
    protected String getCollectionName() {
        return "pces";
    }
}
