package com.github.jlgrock.snp.apis.data;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Sort option for queries.
 */
public class Sort implements Iterable<Sort.Order> {

    /**
     * The default direction that will be set if nothing else is provided.
     */
    public static final Direction DEFAULT_DIRECTION = Direction.ASC;

    private final List<Order> orders;

    /**
     * Creates a new {@link Sort} instance using the given {@link Order}s.
     *
     * @param ordersIn must not be {@literal null}.
     */
    public Sort(final Order... ordersIn) {
        this(Arrays.asList(ordersIn));
    }

    /**
     * Creates a new {@link Sort} instance.
     *
     * @param ordersIn must not be {@literal null} or contain {@literal null}.
     */
    public Sort(final List<Order> ordersIn) {
        Preconditions.checkNotNull(ordersIn, "You have to provide at least one sort property to sort by!");
        Preconditions.checkArgument(ordersIn.isEmpty(), "You have to provide at least one sort property to sort by!");
        orders = ordersIn;
    }

    /**
     * Creates a new {@link Sort} instance. Order defaults to ascending.
     *
     * @param properties must not be {@literal null} or contain {@literal null} or empty strings
     */
    public Sort(final String... properties) {
        this(DEFAULT_DIRECTION, properties);
    }

    /**
     * Creates a new {@link Sort} instance.
     *
     * @param direction  defaults to {@link Sort#DEFAULT_DIRECTION} (for {@literal null} cases, too)
     * @param properties must not be {@literal null}, empty or contain {@literal null} or empty strings.
     */
    public Sort(final Direction direction, final String... properties) {
        this(direction, properties == null ? new ArrayList<String>() : Arrays.asList(properties));
    }

    /**
     * Creates a new {@link Sort} instance.
     *
     * @param direction  defaults to {@link Sort#DEFAULT_DIRECTION} (for {@literal null} cases, too)
     * @param properties must not be {@literal null} or contain {@literal null} or empty strings.
     */
    public Sort(final Direction direction, final List<String> properties) {

        if (properties == null || properties.isEmpty()) {
            throw new IllegalArgumentException("You have to provide at least one property to sort by!");
        }

        orders = new ArrayList<>(properties.size());

        for (String property : properties) {
            orders.add(new Order(direction, property));
        }
    }

    /**
     * @param sort can be {@literal null}.
     * @return a new {@link Sort} consisting of the {@link Order}s of the current {@link Sort} combined with the given
     * ones.
     */
    public Sort and(final Sort sort) {

        if (sort == null) {
            return this;
        }

        ArrayList<Order> these = new ArrayList<>(this.orders);

        for (Order order : sort) {
            these.add(order);
        }

        return new Sort(these);
    }

    /**
     * Returns the order registered for the given property.
     *
     * @param property the property to search for
     * @return Returns the order registered for the given property, or null if it does not exist.
     */
    public Order getOrderFor(final String property) {

        for (Order order : this) {
            if (order.getProperty().equals(property)) {
                return order;
            }
        }

        return null;
    }

    @Override
    public Iterator<Order> iterator() {
        return orders.iterator();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Sort that = (Sort) o;

        return Objects.equal(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(DEFAULT_DIRECTION, orders);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("orders", orders)
                .toString();
    }

    /**
     * Sort directions.
     */
    public static enum Direction {

        ASC, DESC;

    }


    /**
     * Possible ways to handle nulls.
     */
    public static enum NullHandling {

        /**
         * Lets the data store decide what to do with nulls.
         */
        NATIVE,

        /**
         * A hint to the used data store to order entries with null values before non null entries.
         */
        NULLS_FIRST,

        /**
         * A hint to the used data store to order entries with null values after non null entries.
         */
        NULLS_LAST;
    }

    /**
     * PropertyPath implements the pairing of an {@link Direction} and a property. It is used to provide input for
     * {@link Sort}
     */
    public static class Order {

        private static final boolean DEFAULT_IGNORE_CASE = false;

        private final Direction direction;
        private final String property;
        private final boolean ignoreCase;
        private final NullHandling nullHandling;

        /**
         * Creates a new {@link Order} instance. if order is {@literal null} then order defaults to
         * {@link Sort#DEFAULT_DIRECTION}
         *
         * @param directionIn can be {@literal null}, will default to {@link Sort#DEFAULT_DIRECTION}
         * @param propertyIn  must not be {@literal null} or empty.
         */
        public Order(final Direction directionIn, final String propertyIn) {
            this(directionIn, propertyIn, DEFAULT_IGNORE_CASE, null);
        }

        /**
         * Creates a new {@link Order} instance. if order is {@literal null} then order defaults to
         * {@link Sort#DEFAULT_DIRECTION}
         *
         * @param directionIn        can be {@literal null}, will default to {@link Sort#DEFAULT_DIRECTION}
         * @param propertyIn         must not be {@literal null} or empty.
         * @param nullHandlingHintIn can be {@literal null}, will default to {@link NullHandling#NATIVE}.
         */
        public Order(final Direction directionIn, final String propertyIn, final NullHandling nullHandlingHintIn) {
            this(directionIn, propertyIn, DEFAULT_IGNORE_CASE, nullHandlingHintIn);
        }

        /**
         * Creates a new {@link Order} instance. Takes a single property. Direction defaults to
         * {@link Sort#DEFAULT_DIRECTION}.
         *
         * @param propertyIn must not be {@literal null} or empty.
         */
        public Order(final String propertyIn) {
            this(DEFAULT_DIRECTION, propertyIn);
        }

        /**
         * Creates a new {@link Order} instance. if order is {@literal null} then order defaults to
         * {@link Sort#DEFAULT_DIRECTION}
         *
         * @param directionIn    can be {@literal null}, will default to {@link Sort#DEFAULT_DIRECTION}
         * @param propertyIn     must not be {@literal null} or empty.
         * @param ignoreCaseIn   true if sorting should be case insensitive. false if sorting should be case sensitive.
         * @param nullHandlingIn can be {@literal null}, will default to {@link NullHandling#NATIVE}.
         */
        private Order(final Direction directionIn, final String propertyIn, final boolean ignoreCaseIn, final NullHandling nullHandlingIn) {
            Preconditions.checkNotNull(propertyIn, "Property must not null or empty!");
            direction = directionIn == null ? DEFAULT_DIRECTION : directionIn;
            property = propertyIn;
            ignoreCase = ignoreCaseIn;
            nullHandling = nullHandlingIn == null ? NullHandling.NATIVE : nullHandlingIn;
        }

        /**
         * @return the order the property shall be sorted for.
         */
        public Direction getDirection() {
            return direction;
        }

        /**
         * @return the property to order for.
         */
        public String getProperty() {
            return property;
        }

        /**
         * @return whether sorting for this property shall be ascending.
         */
        public boolean isAscending() {
            return direction.equals(Direction.ASC);
        }

        /**
         * @return whether or not the sort will be case sensitive.
         */
        public boolean isIgnoreCase() {
            return ignoreCase;
        }

        /**
         * @param order the given direction for the order
         * @return a new {@link Order} with the given {@link Order}.
         */
        public Order with(final Direction order) {
            return new Order(order, property, nullHandling);
        }

        /**
         * @param propertiesIn the properties to sort by
         * @return a new {@link Sort} instance for the given properties.
         */
        public Sort withProperties(final String... propertiesIn) {
            return new Sort(direction, propertiesIn);
        }

        /**
         * @return a new {@link Order} with case insensitive sorting enabled.
         */
        public Order ignoreCase() {
            return new Order(direction, property, true, nullHandling);
        }

        /**
         * @param nullHandlingIn can be {@literal null}.
         * @return a {@link Order} with the given {@link NullHandling}.
         */
        public Order with(final NullHandling nullHandlingIn) {
            return new Order(direction, property, ignoreCase, nullHandlingIn);
        }

        /**
         * @return a {@link Order} with {@link NullHandling#NULLS_FIRST} as null handling hint.
         */
        public Order nullsFirst() {
            return with(NullHandling.NULLS_FIRST);
        }

        /**
         * @return a {@link Order} with {@link NullHandling#NULLS_LAST} as null handling hint.
         */
        public Order nullsLast() {
            return with(NullHandling.NULLS_LAST);
        }

        /**
         * @return a {@link Order} with {@link NullHandling#NATIVE} as null handling hint.
         */
        public Order nullsNative() {
            return with(NullHandling.NATIVE);
        }

        /**
         * @return the used {@link NullHandling} hint, which can but may not be respected by the used datastore.
         */
        public NullHandling getNullHandling() {
            return nullHandling;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(direction, property, ignoreCase, nullHandling);
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Order that = (Order) o;

            return Objects.equal(direction, that.direction) &&
                    Objects.equal(property, that.property) &&
                    Objects.equal(ignoreCase, that.ignoreCase) &&
                    Objects.equal(nullHandling, that.nullHandling);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("direction", direction)
                    .add("property", property)
                    .add("ignoreCase", ignoreCase)
                    .add("nullHandling", nullHandling)
                    .toString();
        }
    }
}

