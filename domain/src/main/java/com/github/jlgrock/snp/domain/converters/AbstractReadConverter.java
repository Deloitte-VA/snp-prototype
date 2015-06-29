package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.domain.data.SharedTags;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;

/**
 * An abstract implementation to convert between a MongoDB DBObject to a java object.
 */
public abstract class AbstractReadConverter {
    private Number parseNumber(final Document source, final String tag) {
        return (Number) source.get(tag);
    }

    /**
     * Parses the document and the tag and returns the value to which the tag is mapped
     *
     * @param source document
     * @param tag    JSON key tags
     * @return the value to which the tag is mapped
     */
    protected Long parseLong(final Document source, final String tag) {
        Number num = parseNumber(source, tag);
        if (num == null) {
            return null;
        }
        return num.longValue();
    }

    /**
     * Parses the document and the tag and returns the value to which the tag is mapped
     *
     * @param source document
     * @param tag    JSON key tags
     * @return the value to which the tag is mapped
     */
    protected Integer parseInteger(final Document source, final String tag) {
        Number num = parseNumber(source, tag);
        if (num == null) {
            return null;
        }
        return num.intValue();
    }

    /**
     * Parses the document and the tag and returns the value to which the tag is mapped
     *
     * @param source document
     * @param tag    JSON key tags
     * @return the value to which the tag is mapped
     */
    protected LocalDate parseLocalDate(final Document source, final String tag) {
        Long num = parseLong(source, tag);
        if (num == null) {
            return null;
        }
        return LocalDate.ofEpochDay(num);
    }

    /**
     * Parses the document and the tag and returns the value to which the tag is mapped.
     * This particular one returns an optional because of the autoboxing problem of
     * booleans within Java, which could cause this to return the incorrect value.
     *
     * @param source document
     * @param tag    JSON key tags
     * @return the value to which the tag is mapped
     */
    protected Optional<Boolean> parseBoolean(final Document source, final String tag) {
        String val = parseString(source, tag);

        Optional<Boolean> retVal = Optional.empty();
        if (val != null) {
            retVal = Optional.of(Boolean.parseBoolean(val));
        }
        return retVal;
    }

    /**
     * Parses the document and the tag and returns the value to which the tag is mapped
     *
     * @param source document
     * @param tag    JSON key tags
     * @return the value to which the tag is mapped
     */
    protected Instant parseInstant(final Document source, final String tag) {
        Long num = parseLong(source, tag);
        if (num == null) {
            return null;
        }
        return Instant.ofEpochMilli(num);
    }

    /**
     * Parses the document and the tag and returns the value to which the tag is mapped
     *
     * @param source document
     * @param tag    JSON key tags
     * @return the value to which the tag is mapped
     */
    protected String parseString(final Document source, final String tag) {
        return (String) source.get(tag);
    }

    /**
     * Parses the document id from the standard ID tag
     *
     * @param source document
     * @return the value of the id
     */
    protected ObjectId parseId(final Document source) {
        return parseObjectId(source, SharedTags.ID_TAG);
    }

    /**
     * Parses the document and the tag and returns the value to which the tag is mapped
     *
     * @param source document
     * @param tag    JSON key tags
     * @return the value to which the tag is mapped
     */
    protected ObjectId parseObjectId(final Document source, final String tag) {
        return (ObjectId) source.get(tag);
    }
}
