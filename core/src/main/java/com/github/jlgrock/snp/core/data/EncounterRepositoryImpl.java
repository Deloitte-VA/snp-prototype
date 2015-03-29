package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.EncounterReadConverter;
import com.github.jlgrock.snp.core.converters.EncounterWriteConverter;
import com.github.jlgrock.snp.core.domain.Encounter;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
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
		return "encounter";
	}


	public List<Encounter> findByDate(final LocalDate date) {
		List<Encounter> eList = new ArrayList<>();
		DBCollection dbc1 = dBCollection();
		BasicDBObject query = new BasicDBObject() {{
			put("date", date.toEpochDay());
		}};

		DBCursor x = dbc1.find(query);
		for (DBObject o : x) {
			eList.add(convertToDomainObject(o));
		}
		return eList;
	}

	@Override
	protected Encounter convertToDomainObject(final DBObject dbObjectin) {
		return encounterReadConverter.convert(dbObjectin);
	}

	@Override
	protected DBObject convertToDBObject(final Encounter s) {
		return encounterWriteConverter.convert(s);
	}

}
