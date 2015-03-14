package com.github.jlgrock.snp.core.converters;

import org.jvnet.hk2.annotations.Contract;

/**
 * A simple extension of the Converter class that indicates reading, vs writing
 * @param <T1> The class indicating the object to store
 * @param <ID> The class indicating the ID to use as the unique identifier
 */
@Contract
public interface WriteConverter<T1, ID> extends Converter<T1, ID> {
}
