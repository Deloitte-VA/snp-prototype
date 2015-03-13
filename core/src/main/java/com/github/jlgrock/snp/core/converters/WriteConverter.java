package com.github.jlgrock.snp.core.converters;

import org.jvnet.hk2.annotations.Contract;

/**
 * A simple extension of the Converter class that indicates reading, vs writing
 */
@Contract
public interface WriteConverter<T1, T2> extends Converter<T1, T2> {
}
