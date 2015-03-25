package com.github.jlgrock.snp.web.controllers;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Simple Binder to use whenever a single value should be passed into hk2.
 */
public class SimpleBinder<T> extends AbstractBinder {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleBinder.class);

    private final T var;
    private final Class<? super T> clazz;

    public SimpleBinder(final T varIn, final Class<? super T> clazzIn) {
        LOGGER.debug("Creating and binding using SimpleBinder for class [" + clazzIn + "]");
        var = varIn;
        clazz = clazzIn;
    }

    @Override
    protected void configure() {
        bindFactory(new MockFactory(var)).to(clazz);
    }

    private class MockFactory implements Factory<T> {
        private T factoryVar;

        public MockFactory(T factoryVarIn) {
            factoryVar = factoryVarIn;
        }

        @Override
        public T provide() {
            return var;
        }

        @Override
        public void dispose(final T instance) {
            //does nothing for disposal.  If you need this, please don't use this class.
        }
    }
}
