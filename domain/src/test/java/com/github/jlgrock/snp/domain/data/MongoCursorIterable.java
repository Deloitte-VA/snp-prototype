package com.github.jlgrock.snp.domain.data;

import java.util.Collection;
import java.util.List;

import org.bson.Document;

import com.mongodb.ServerAddress;
import com.mongodb.ServerCursor;
import com.mongodb.client.MongoCursor;

public class MongoCursorIterable implements MongoCursor<Document>{
	
	private Collection<Document> newC;
	private int cursor = 0;
	
    public MongoCursorIterable(final Collection<Document> cIn) {
        newC = cIn;
    }

	@Override
	public void close() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public boolean hasNext() {
		return cursor < newC.size();
		//return newC.iterator().hasNext();
	}

	@Override
	public Document next() {
		cursor++;
		return newC.iterator().next();
	}

	@Override
	public Document tryNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerCursor getServerCursor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerAddress getServerAddress() {
		// TODO Auto-generated method stub
		return null;
	}

}
