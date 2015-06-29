package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.apis.converters.WriteConverter;
import com.github.jlgrock.snp.domain.data.PatientTags;
import com.github.jlgrock.snp.domain.data.SharedTags;
import com.github.jlgrock.snp.domain.types.Patient;
import org.bson.Document;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;

/**
 * A Conversion class to convert between an Patient objects and a MongoDB DBObject.
 */
@Service
@Named
public class PatientWriteConverter implements WriteConverter<Patient, Document> {

    @Override
    public Document convert(final Patient source) {
        Document dbo = new Document();
        if (source.getId() != null) {
            dbo.put(SharedTags.ID_TAG, source.getId());
        }
        if (source.getFirstName() != null) {
            dbo.put(PatientTags.FIRST_NAME_TAG, source.getFirstName());
        }
        if (source.getMiddleName() != null) {
            dbo.put(PatientTags.MIDDLE_NAME_TAG, source.getMiddleName());
        }
        if (source.getLastName() != null) {
            dbo.put(PatientTags.LAST_NAME_TAG, source.getLastName());
        }
        if (source.getGender() != null) {
            dbo.put(PatientTags.GENDER_TAG, source.getGender().getId());
        }
        if (source.getDateOfBirth() != null) {
            dbo.put(PatientTags.DATE_OF_BIRTH_TAG, source.getDateOfBirth().toEpochDay());
        }
        if (source.isDeceased() != null) {
            dbo.put(PatientTags.DECEASED, String.valueOf(source.isDeceased()));
        }
        if (source.getDateDeceased() != null) {
            dbo.put(PatientTags.DATE_DECEASED, source.getDateDeceased().toEpochDay());
        }
        if (source.getFhirId() != null) {
            dbo.put(PatientTags.FHIR_ID_TAG, source.getFhirId());
        }
        return dbo;
    }
}

