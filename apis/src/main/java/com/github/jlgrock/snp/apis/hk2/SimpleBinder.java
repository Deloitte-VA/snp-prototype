package com.github.jlgrock.snp.apis.hk2;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 * A Simple Binder to use whenever a single value should be passed into hk2.
 */
public class SimpleBinder<T> extends AbstractBinder {
    private T var;
    private Class<? super T> clazz;

    public SimpleBinder(T varIn, Class<? super T> clazzIn) {
        var = varIn;
        clazz = clazzIn;
    }

    @Override
    protected void configure() {
        bindFactory(new MockFactory<>(var)).to(clazz);
    }

    private class MockFactory implements Factory<T> {

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
