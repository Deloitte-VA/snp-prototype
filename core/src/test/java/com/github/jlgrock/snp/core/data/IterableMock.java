package com.github.jlgrock.snp.core.data;

import com.mongodb.Block;
import com.mongodb.CursorType;
import com.mongodb.Function;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;

import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 *
 */
public class IterableMock implements FindIterable<Document> {

        private Collection<Document> c;

        public IterableMock(final Collection<Document> cIn) {
            c = cIn;
        }

        @Override
        public FindIterable<Document> filter(Bson filter) {
            return null;
        }

        @Override
        public FindIterable<Document> limit(int limit) {
            return null;
        }

        @Override
        public FindIterable<Document> skip(int skip) {
            return null;
        }

        @Override
        public FindIterable<Document> maxTime(long maxTime, TimeUnit timeUnit) {
            return null;
        }

        @Override
        public FindIterable<Document> modifiers(Bson modifiers) {
            return null;
        }

        @Override
        public FindIterable<Document> projection(Bson projection) {
            return null;
        }

        @Override
        public FindIterable<Document> sort(Bson sort) {
            return null;
        }

        @Override
        public FindIterable<Document> noCursorTimeout(boolean noCursorTimeout) {
            return null;
        }

        @Override
        public FindIterable<Document> oplogReplay(boolean oplogReplay) {
            return null;
        }

        @Override
        public FindIterable<Document> partial(boolean partial) {
            return null;
        }

        @Override
        public FindIterable<Document> cursorType(CursorType cursorType) {
            return null;
        }

        @Override
        public FindIterable<Document> batchSize(int batchSize) {
            return null;
        }

        @Override
        public MongoCursor<Document> iterator() {
            return null;
        }

        @Override
        public Document first() {
        	
        Iterator<Document> id1 = c.iterator();
        return id1.next();
        
        }

        @Override
        public <U> MongoIterable<U> map(Function<Document, U> mapper) {
            return null;
        }

        @Override
        public void forEach(Block<? super Document> block) {
            c.forEach(block::apply);
        }

        @Override
        public void forEach(Consumer<? super Document> consumer) {
            c.forEach(consumer::accept);
        }

        @Override
        public <A extends Collection<? super Document>> A into(A target) {
            return null;
        }
    };
