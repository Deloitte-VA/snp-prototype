package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.domain.converters.EncounterReadConverter;
import com.github.jlgrock.snp.domain.converters.EncounterWriteConverter;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.mongodb.client.FindIterable;
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
@Service(name="encounterRepository")
public class EncounterRepositoryImpl extends
        AbstractRepositoryImpl<Encounter, Long> implements EncounterRepository {

    private final EncounterReadConverter encounterReadConverter;

    private final EncounterWriteConverter encounterWriteConverter;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EncounterRepositoryImpl.class);

    /**
     * 
     * @param mongoDbFactoryIn MongoDbFactory
     * @param encounterReadConverterIn EncounterReadConverter
     * @param encounterWriteConverterIn EncounterWriteConverter
     */
    @Inject
    protected EncounterRepositoryImpl(final MongoDbFactory mongoDbFactoryIn,
                                      final EncounterReadConverter encounterReadConverterIn,
                                      final EncounterWriteConverter encounterWriteConverterIn) {
        super(mongoDbFactoryIn);
        encounterReadConverter = encounterReadConverterIn;
        encounterWriteConverter = encounterWriteConverterIn;
    }

    @Override
    protected String getCollectionName() {
    	LOGGER.trace("getCollectionName()");
        return "encounters";
    }

    /**
     * Find an encounter by the date of the encounter
     * @param date the date to search by
     * @return the results, in the form of a list
     */
    public List<Encounter> findByDate(final LocalDate date) {
    	if (date == null){
    		return new ArrayList<>();
    	}
    	LOGGER.trace("findByDate(LocalDate date={})", date);
        Document query = new Document() {{
            put("date", date);
        }};
        return executeQueryAndTransformResults(query);
    }

    @Override
    public List<Encounter> findByPceIdList(final List<Long> pceIds) {
        Document query = new Document();
        Document idsIn = new Document();
        idsIn.put("$in", pceIds);
        query.put("observations.name", idsIn);
        return executeQueryAndTransformResults(query);
    }

    @Override
    public Encounter findOneByFhirId(String fhirId) {
        Document query = new Document();
        query.put(EncounterTags.FHIR_ID, fhirId);
        LOGGER.trace("findOneByID(fhirId={})", fhirId);
        if (fhirId == null) {
            LOGGER.error("fhirId parameter for findOneById method is null, therefore Domain Object cannot be found.");
            return null;
        }
        FindIterable<Document> iterable = dBCollection().find(query).limit(1);
        Document first = iterable.first();
        return convertToDomainObject(first);
    }

    @Override
    protected Encounter convertToDomainObject(final Document dbObjectin) {
    	LOGGER.trace("convertToDomainObject(Document dbObjectin={})", dbObjectin);
        if (dbObjectin == null) {
            return null;
        }
        return encounterReadConverter.convert(dbObjectin);
    }
    
    @Override
    protected Document convertToDBObject(final Encounter s) {
    	LOGGER.trace("convertToDBObject(Encounter s={})", s);
        if (s == null) {
            return null;
        }
        return encounterWriteConverter.convert(s);
    }

}
