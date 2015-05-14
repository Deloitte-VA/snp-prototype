package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.EncounterReadConverter;
import com.github.jlgrock.snp.core.converters.EncounterWriteConverter;
import com.github.jlgrock.snp.core.domain.Encounter;
import com.github.jlgrock.snp.core.domain.Patient;

import org.bson.Document;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This class executes queries against the Encounter
 * Collection within MongoDB.
 */
@Service
public class EncounterRepositoryImpl extends
        AbstractRepositoryImpl<Encounter, Long> implements EncounterRepository {

    private final EncounterReadConverter encounterReadConverter;

    private final EncounterWriteConverter encounterWriteConverter;
    
    List<Encounter> encounterShell = new ArrayList<>(6);
    
    private static final Logger LOGGER = LoggerFactory
            .getLogger(EncounterRepositoryImpl.class);

    @Inject
    protected EncounterRepositoryImpl(final MongoDbFactory mongoDbFactoryIn,
                                      final EncounterReadConverter encounterReadConverterIn,
                                      final EncounterWriteConverter encounterWriteConverterIn) {
        super(mongoDbFactoryIn);
        encounterReadConverter = encounterReadConverterIn;
        encounterWriteConverter = encounterWriteConverterIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getCollectionName() {
    	LOGGER.trace("getCollectionName()");
        return "encounters";
    }

    public List<Encounter> findByDate(final LocalDate date) {
    	if (date == null){
    		return encounterShell;
    	}
    	LOGGER.trace("findByDate(LocalDate date=" + date + ")");
        Document query = new Document() {{
            put("date", date);
        }};
        return executeQueryAndTransformResults(query);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected Encounter convertToDomainObject(final Document dbObjectin) {
    	LOGGER.trace("convertToDomainObject(Document dbObjectin=" + dbObjectin + ")");
        if (dbObjectin == null) {
            return null;
        }
        return encounterReadConverter.convert(dbObjectin);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected Document convertToDBObject(final Encounter s) {
    	LOGGER.trace("convertToDBObject(Encounter s=" + s + ")");
        if (s == null) {
            return null;
        }
        return encounterWriteConverter.convert(s);
    }

}
