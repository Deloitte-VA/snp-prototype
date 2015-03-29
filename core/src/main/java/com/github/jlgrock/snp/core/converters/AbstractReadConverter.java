package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.EncounterTags;
import com.mongodb.DBObject;

import java.time.Instant;
import java.time.LocalDate;

/**
 *
 */
public class AbstractReadConverter {
    private Number parseNumber(final DBObject source, final String tag) {
        return ((Number) source.get(EncounterTags.ID_TAG));
    }

    protected Long parseLong(final DBObject source, final String tag) {
        Long returnVal = null;

        Number num = parseNumber(source, tag);
        if (num == null) {
            return null;
        }
        return num.longValue();
    }

    protected Integer parseInteger(final DBObject source, final String tag) {
        Long returnVal = null;

        Number num = parseNumber(source, tag);
        if (num == null) {
            return null;
        }
        return num.intValue();
    }

    protected LocalDate parseLocalDate(final DBObject source, final String tag) {
        Long num = parseLong(source, tag);
        if (num == null) {
            return null;
        }
        return LocalDate.ofEpochDay(num);
    }

    protected Instant parseInstant(final DBObject source, final String tag) {
        Long num = parseLong(source, tag);
        if (num == null) {
            return null;
        }
        return Instant.ofEpochMilli(num);
    }

    protected String parseString(final DBObject source, final String tag) {
        return (String) source.get(EncounterTags.REASON_FOR_VISIT_TAG);
    }
}
