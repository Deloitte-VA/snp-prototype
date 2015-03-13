package com.github.jlgrock.snp.core.data;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

public interface NewInterface2 {
	
//Page Method Signatures
	
		/**
		 * Returns the number of total pages.
		 * 
		 * @return the number of toral pages
		 */
		int getTotalPages();

		/**
		 * Returns the total amount of elements.
		 * 
		 * @return the total amount of elements
		 */
		long getTotalElements();
		
		
		
//Slice Method Signatures
		
		/**
		 * Returns the number of the current {@link Slice}. Is always non-negative.
		 * 
		 * @return the number of the current {@link Slice}.
		 */
		int getNumber();

		/**
		 * Returns the size of the {@link Slice}.
		 * 
		 * @return the size of the {@link Slice}.
		 */
		int getSize();

		/**
		 * Returns the number of elements currently on this {@link Slice}.
		 * 
		 * @return the number of elements currently on this {@link Slice}.
		 */
		int getNumberOfElements();

		/**
		 * Returns the page content as {@link List}.
		 * 
		 * @return
		 */
		List<T> getContent();

		/**
		 * Returns whether the {@link Slice} has content at all.
		 * 
		 * @return
		 */
		boolean hasContent();
		
		/**
		 * Returns the sorting parameters for the {@link Slice}.
		 * 
		 * @return
		 */
		Sort getSort();

		/**
		 * Returns whether the current {@link Slice} is the first one.
		 * 
		 * @return
		 */
		boolean isFirst();

		/**
		 * Returns whether the current {@link Slice} is the last one.
		 * 
		 * @return
		 */
		boolean isLast();

		/**
		 * Returns if there is a next {@link Slice}.
		 * 
		 * @return if there is a next {@link Slice}.
		 */
		boolean hasNext();
		
		/**
		 * Returns if there is a previous {@link Slice}.
		 * 
		 * @return if there is a previous {@link Slice}.
		 */
		boolean hasPrevious();

		/**
		 * Returns the {@link Pageable} to request the next {@link Slice}. Can be {@literal null} in case the current
		 * {@link Slice} is already the last one. Clients should check {@link #hasNext()} before calling this method to make
		 * sure they receive a non-{@literal null} value.
		 * 
		 * @return
		 */
		Pageable nextPageable();

		/**
		 * Returns the {@link Pageable} to request the previous {@link Slice}. Can be {@literal null} in case the current
		 * {@link Slice} is already the first one. Clients should check {@link #hasPrevious()} before calling this method make
		 * sure receive a non-{@literal null} value.
		 * 
		 * @return
		 */
		Pageable previousPageable();
		
}
