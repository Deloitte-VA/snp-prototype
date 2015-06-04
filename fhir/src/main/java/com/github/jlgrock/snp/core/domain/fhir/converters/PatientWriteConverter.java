package com.github.jlgrock.snp.core.domain.fhir.converters;

import org.jvnet.hk2.annotations.Contract;

import com.github.jlgrock.snp.apis.converters.WriteConverter;

@Contract
public interface PatientWriteConverter extends WriteConverter<com.github.jlgrock.snp.core.domain.fhir.model.Patient, com.github.jlgrock.snp.domain.types.Patient> {

}
