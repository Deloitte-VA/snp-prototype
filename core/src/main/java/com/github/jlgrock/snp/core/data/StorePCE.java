package com.github.jlgrock.snp.core.data;

import java.util.List;

import com.github.jlgrock.snp.core.domain.PCE;
import com.github.jlgrock.snp.core.model.parser.Lego;

/**
 * Store PCEs from LEGO document which have been replaced
 * with a classifier ID to the MongoDB
 *
 */
public class StorePCE {
	private final PceRepository repository;
		
	public StorePCE(final PceRepository repositoryIn) {
		repository = repositoryIn;
	}
	
	public void save(final List<Lego> legos, final String classifierID) {
		PCE pce = new PCE();
		repository.save(pce);
	}
	
}
