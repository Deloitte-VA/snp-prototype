package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.apis.converters.ReadConverter;
import com.github.jlgrock.snp.domain.data.PatientTags;
import com.github.jlgrock.snp.domain.types.Gender;
import com.github.jlgrock.snp.domain.types.Patient;
import org.bson.Document;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;
import java.util.Optional;

/**
 * A Conversion class to convert between a MongoDB DBObject to an Patient object.
 */
@Service
@Named
public class PatientReadConverter extends AbstractReadConverter
        implements ReadConverter<Document, Patient> {

    @Override
    public Patient convert(final Document source) {
        Patient p = new Patient();
        p.setId(parseId(source));
        p.setFirstName(parseString(source, PatientTags.FIRST_NAME_TAG));
        p.setMiddleName(parseString(source, PatientTags.MIDDLE_NAME_TAG));
        p.setLastName(parseString(source, PatientTags.LAST_NAME_TAG));
        p.setGender(Gender.getValueById(parseInteger(source, PatientTags.GENDER_TAG)));
        p.setDateOfBirth(parseLocalDate(source, PatientTags.DATE_OF_BIRTH_TAG));

        Optional<Boolean> isDeceased = parseBoolean(source, PatientTags.DECEASED);
        if (isDeceased.isPresent()) {
            p.setDeceased(isDeceased.get());
        }

        p.setDateDeceased(parseLocalDate(source, PatientTags.DATE_DECEASED));
        return p;
    }
}

