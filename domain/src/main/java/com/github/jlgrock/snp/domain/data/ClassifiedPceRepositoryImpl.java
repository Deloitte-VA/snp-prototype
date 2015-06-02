package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.domain.converters.ClassifiedPceReadConverter;
import com.github.jlgrock.snp.domain.converters.ClassifiedPceWriteConverter;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import org.bson.Document;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 * This class executes queries against the ClassifiedPce 
 * Collection within MongoDB.
 */
@Service
public class ClassifiedPceRepositoryImpl extends AbstractRepositoryImpl<ClassifiedPce, Long>
		implements ClassifiedPceRepository {

	private final ClassifiedPceReadConverter classifiedPceReadConverter;

	private final ClassifiedPceWriteConverter classifiedPceWriteConverter;

	/**
	 * @param mongoDbFactoryIn MongoDbFactory
	 * @param classifiedPceReadConverterIn ClassifiedPceReadConverter
	 * @param classifiedPceWriteConverterIn ClassifiedPceWriteConverter
	 */
	@Inject
    public ClassifiedPceRepositoryImpl(final MongoDbFactory mongoDbFactoryIn,
									   final ClassifiedPceReadConverter classifiedPceReadConverterIn,
									   final ClassifiedPceWriteConverter classifiedPceWriteConverterIn) {
        super(mongoDbFactoryIn);
		classifiedPceReadConverter = classifiedPceReadConverterIn;
		classifiedPceWriteConverter = classifiedPceWriteConverterIn;
    }

	@Override
	protected ClassifiedPce convertToDomainObject(final Document dbObjectin) {
		return classifiedPceReadConverter.convert(dbObjectin);
	}

	@Override
	protected Document convertToDBObject(final ClassifiedPce s) {
		return classifiedPceWriteConverter.convert(s);
	}

    @Override
    protected String getCollectionName() {
        return "pces";
    }
}
