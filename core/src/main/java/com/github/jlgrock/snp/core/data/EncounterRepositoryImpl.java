package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.EncounterReadConverter;
import com.github.jlgrock.snp.core.converters.EncounterWriteConverter;
import com.github.jlgrock.snp.core.domain.Encounter;
import org.bson.Document;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

/**
 *
 */
@Service
public class EncounterRepositoryImpl extends
        AbstractRepositoryImpl<Encounter, Long> implements EncounterRepository {

    private final EncounterReadConverter encounterReadConverter;

    private final EncounterWriteConverter encounterWriteConverter;

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
        return "encounters";
    }


    public List<Encounter> findByDate(final LocalDate date) {
        Document query = new Document() {{
            put("date", date);
        }};
        return executeQueryAndTransformResults(query);
    }

    @Override
    protected Encounter convertToDomainObject(final Document dbObjectin) {
        if (dbObjectin == null) {
            return null;
        }
        return encounterReadConverter.convert(dbObjectin);
    }

    @Override
    protected Document convertToDBObject(final Encounter s) {
        if (s == null) {
            return null;
        }
        return encounterWriteConverter.convert(s);
    }

}
