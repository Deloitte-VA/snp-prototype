package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.EncounterTags;
import org.bson.Document;

import java.time.Instant;
import java.time.LocalDate;

/**
 *
 */
public class AbstractReadConverter {
    private Number parseNumber(final Document source, final String tag) {
        return ((Number) source.get(EncounterTags.ID_TAG));
    }

    protected Long parseLong(final Document source, final String tag) {
        Long returnVal = null;

        Number num = parseNumber(source, tag);
        if (num == null) {
            return null;
        }
        return num.longValue();
    }

    protected Integer parseInteger(final Document source, final String tag) {
        Long returnVal = null;

        Number num = parseNumber(source, tag);
        if (num == null) {
            return null;
        }
        return num.intValue();
    }

    protected LocalDate parseLocalDate(final Document source, final String tag) {
        Long num = parseLong(source, tag);
        if (num == null) {
            return null;
        }
        return LocalDate.ofEpochDay(num);
    }

    protected Instant parseInstant(final Document source, final String tag) {
        Long num = parseLong(source, tag);
        if (num == null) {
            return null;
        }
        return Instant.ofEpochMilli(num);
    }

    protected String parseString(final Document source, final String tag) {
        return (String) source.get(EncounterTags.REASON_FOR_VISIT_TAG);
    }
}
