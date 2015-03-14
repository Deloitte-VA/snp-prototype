package com.github.jlgrock.snp.apis.data;

import org.jvnet.hk2.annotations.Contract;

/**
 * The methods required if something can return pages of information.
 */
@Contract
public interface Pageable {
    /**
     * @return the page to be returned.
     */
    int getPageNumber();

    /**
     * @return the number of items of that page
     */
    int getPageSize();

    /**
     * @return the offset to be taken
     */
    int getOffset();

    /**
     * @return the sorting parameters.
     */
    Sort getSort();

    /**
     * @return the {@link Pageable} requesting the next {@link Page}.
     */
    Pageable next();

    /**
     * @return the previous {@link Pageable} or the first {@link Pageable} if the current one already is the first one.
     */
    Pageable previousOrFirst();

    /**
     * @return the {@link Pageable} requesting the first page.
     */
    Pageable first();

    /**
     * @return whether there's a previous {@link Pageable} we can access from the current one. Will return
     * {@literal false} in case the current {@link Pageable} already refers to the first page.
     */
    boolean hasPrevious();
}
