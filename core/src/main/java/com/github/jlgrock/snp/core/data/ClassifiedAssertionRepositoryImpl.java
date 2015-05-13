package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.ClassifiedAssertionReadConverter;
import com.github.jlgrock.snp.core.converters.ClassifiedAssertionWriteConverter;
import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;

import org.bson.Document;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 *
 */
@Service
public class ClassifiedAssertionRepositoryImpl extends AbstractRepositoryImpl<ClassifiedAssertion, Long> implements ClassifiedAssertionRepository {

    private final ClassifiedAssertionReadConverter classifiedAssertionReadConverter;

    private final ClassifiedAssertionWriteConverter classifiedAssertionWriteConverter;
    
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ClassifiedAssertionRepositoryImpl.class);

    @Inject
    public ClassifiedAssertionRepositoryImpl(final MongoDbFactory mongoDbFactoryIn,
                                             final ClassifiedAssertionReadConverter classifiedAssertionReadConverterIn,
                                             final ClassifiedAssertionWriteConverter classifiedAssertionWriteConverterIn) {
        super(mongoDbFactoryIn);
        classifiedAssertionReadConverter = classifiedAssertionReadConverterIn;
        classifiedAssertionWriteConverter = classifiedAssertionWriteConverterIn;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected ClassifiedAssertion convertToDomainObject(final Document dbObjectin) {
    	LOGGER.trace("convertToDomainObject(Document dbObjectin=" + dbObjectin + ")");
        if (dbObjectin == null) {
            return null;
        } else {
            return classifiedAssertionReadConverter.convert(dbObjectin);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Document convertToDBObject(final ClassifiedAssertion s) {
    	LOGGER.trace("convertToDBObject(ClassifiedAssertion s=" + s + ")");
        if (s == null) {
            return null;
        } else {
            return classifiedAssertionWriteConverter.convert(s);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected String getCollectionName() {
    	LOGGER.trace("getCollectionName()");
        return "pces";
    }
}
