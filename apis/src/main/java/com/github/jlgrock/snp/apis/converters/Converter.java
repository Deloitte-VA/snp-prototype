package com.github.jlgrock.snp.apis.converters;

/**
 * Simple interface used to help in conversion between known object types.
 * @param <T1> The class indicating the object to store
 * @param <ID> The class indicating the ID to use as the unique identifier
 */
public interface Converter<T1, ID> {

    /**
     * Will convert from type T1 to type T2.
     * @param source the source object to convert
     * @return the output that is a converted object
     */
    ID convert(T1 source);
}

