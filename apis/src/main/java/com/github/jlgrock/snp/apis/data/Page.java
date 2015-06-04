package com.github.jlgrock.snp.apis.data;

import org.jvnet.hk2.annotations.Contract;

import java.util.List;

/**
 * The pages allowable from a document.
 *
 * @param <T> the type of object that this will page through
 */
@Contract
public interface Page<T> {
    /**
     * @return the number of total pages
     */
    int getTotalPages();

    /**
     * @return the total amount of elements
     */
    long getTotalElements();

    /**
     * @return the number of the current {@link Page}.
     */
    int getNumber();

    /**
     * @return the size of the {@link Page}.
     */
    int getSize();

    /**
     * @return the number of elements currently on this {@link Page}.
     */
    int getNumberOfElements();

    /**
     * @return the page content as {@link List}.
     */
    List<T> getContent();

    /**
     * @return whether the {@link Page} has content at all.
     */
    boolean hasContent();

    /**
     * @return the sorting parameters for the {@link Page}.
     */
    Sort getSort();

    /**
     * @return  whether the current {@link Page} is the first one.
     */
    boolean isFirst();

    /**
     * @return whether the current {@link Page} is the last one.
     */
    boolean isLast();

    /**
     * @return if there is a next {@link Page}.
     */
    boolean hasNext();

    /**
     * @return if there is a previous {@link Page}.
     */
    boolean hasPrevious();

    /**
     * @return the {@link Pageable} to request the next {@link Page}. Can be {@literal null} in case the current
     * {@link Page} is already the last one. Clients should check {@link #hasNext()} before calling this method to make
     * sure they receive a non-{@literal null} value.
     */
    Pageable nextPageable();

    /**
     * @return the {@link Pageable} to request the previous {@link Page}. Can be {@literal null} in case the current
     * {@link Page} is already the first one. Clients should check {@link #hasPrevious()} before calling this method make
     * sure receive a non-{@literal null} value.
     */
    Pageable previousPageable();

}

