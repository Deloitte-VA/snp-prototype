package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.apis.data.Pageable;
import com.github.jlgrock.snp.apis.data.Sort;

/**
 * This class represents pageable information
 */
public class PageableImpl implements Pageable {

    private final int pageSize;
    private final int offSet;
    private final Sort sort;

    /**
     * constructs PageableImpl
     *
     * @param pageSize1 int
     */
    public PageableImpl(final int pageSize1) {
        this(pageSize1, 0);
    }

    /**
     * constructs PageableImpl
     *
     * @param pageSize1 int
     * @param offSet1   int
     */
    public PageableImpl(final int pageSize1, final int offSet1) {
        this(pageSize1, offSet1, null);
    }

    /**
     * constructs PageableImpl
     *
     * @param pageSize1 int
     * @param offSet1   int
     * @param sort1     int
     */
    public PageableImpl(final int pageSize1, final int offSet1, final Sort sort1) {
        this.pageSize = pageSize1;
        this.offSet = offSet1;
        this.sort = sort1;
    }

    @Override
    public int getPageNumber() {
        return offSet / pageSize;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public int getOffset() {
        return offSet;
    }

    @Override
    public Sort getSort() {

        return null;
    }

    @Override
    public Pageable next() {
        return new PageableImpl((offSet + pageSize), pageSize);
    }

    @Override
    public Pageable previousOrFirst() {
        if (offSet <= pageSize) {
            return new PageableImpl(pageSize);
        } else {
            return new PageableImpl((offSet - pageSize), pageSize);
        }
    }

    @Override
    public Pageable first() {
        return new PageableImpl(pageSize);
    }

    @Override
    public boolean hasPrevious() {
        if (offSet <= pageSize) {
            return false;
        } else {
            return true;
        }
    }
}
