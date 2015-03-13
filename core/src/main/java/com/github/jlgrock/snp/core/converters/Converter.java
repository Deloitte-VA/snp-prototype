package com.github.jlgrock.snp.core.converters;

/**
 * Simple interface used to help in conversion between known object types.
 */
public abstract interface Converter<T1, T2> {

    /**
     * Will convert from type T1 to type T2.
     * @param source the source object to convert
     * @return the output that is a converted object
     */
    public T2 convert(T1 source);
}
