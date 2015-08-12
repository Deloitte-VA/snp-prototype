package com.github.jlgrock.snp.apis.data;

import org.jvnet.hk2.annotations.Contract;

/**
 * An Abstraction level, to separate the implementation from the queries
 *
 * @param <DT> the domain objects to store in the collection
 * @param <ID> the type of the id
 */
@Contract
public interface MongoRepository<DT, ID> {

    /**
     * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
     *
     * @param pageable the details on how the results should be returned
     * @return a page of entities
     */
    Page<DT> findAll(Pageable pageable);

    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed
     * the entity instance completely.
     *
     * @param <S> a type that extends the id type
     * @param entity the entity to save
     *
     * @return the saved entity
     */
    <S extends DT> DT save(S entity);

    /**
     * Saves all given entities.
     *
     * @param entities the entities to save
     * @param <S> a type that matches the domain object store
     * @return the saved entities
     *
     * throws IllegalArgumentException in case the given entity is (@literal null}.
     */
    <S extends DT> Iterable<S> save(Iterable<S> entities);

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal null} if none found
     *
     * throws IllegalArgumentException if {@code id} is {@literal null}
     */
    DT findOneById(ID id);

    /**
     * Returns whether an entity with the given id exists.
     *
     * @param id must not be {@literal null}.
     * @return true if an entity with the given id exists, {@literal false} otherwise
     *
     * throws IllegalArgumentException if {@code id} is {@literal null}
     */
    boolean existsById(ID id);

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    Iterable<DT> findAll();

    /**
     * Returns all instances of the type with the given IDs.
     *
     * @param ids the id's to find
     * @return all of the results, brought back into a single iterable collection.  Please note, that you should be
     *          using Pageable versions if the expected output is large.
     */
    Iterable<DT> findAllById(Iterable<ID> ids);

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities
     */
    long count();

    /**
	 * Deletes the entity with the given id.
	 *
	 * @param id
	 *            must not be {@literal null}.
	 *
	 *            throws IllegalArgumentException in case the given {@code id}
	 *            is {@literal null}
	 */
	void deleteById(ID id);

	/**
	 * Deletes a given entity.
	 *
	 * @param entity
	 *            the entity to delete
	 *
	 *            throws IllegalArgumentException in case the given entity is
	 *            (@literal null}.
	 */
	void delete(DT entity);

	/**
	 * Deletes the given entities.
	 *
	 * @param entities
	 *            the entitites to delete
	 *
	 *            throws IllegalArgumentException in case the given
	 *            {@link Iterable} is (@literal null}.
	 */
	void delete(Iterable<? extends DT> entities);

	/**
	 * Deletes all entities managed by the repository.
	 */
	void deleteAll();

}

