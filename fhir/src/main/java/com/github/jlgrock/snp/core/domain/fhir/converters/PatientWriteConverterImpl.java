package com.github.jlgrock.snp.core.domain.fhir.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.jvnet.hk2.annotations.Service;

import com.github.jlgrock.snp.apis.converters.WriteConverter;
import com.github.jlgrock.snp.core.domain.fhir.model.Code;
import com.github.jlgrock.snp.core.domain.fhir.model.DateTime;
import com.github.jlgrock.snp.domain.types.Gender;

@Service
public class PatientWriteConverterImpl implements PatientWriteConverter{

	@Override
	public com.github.jlgrock.snp.domain.types.Patient convert(
			com.github.jlgrock.snp.core.domain.fhir.model.Patient source) {
		com.github.jlgrock.snp.domain.types.Patient patientOut = new com.github.jlgrock.snp.domain.types.Patient();
		
		// convert name
		patientOut.setFirstName(source.getName().get(0).getGiven().get(0).toString());
		patientOut.setMiddleName(source.getName().get(0).getGiven().get(1).toString());
		patientOut.setLastName(source.getName().get(0).getFamily().get(0).toString());
		
		patientOut.setGender(convertGender(source.getGender().getCoding().get(0).getCode()));
		patientOut.setDateOfBirth(convertDateTimeToLocalDate(source.getBirthDate()));
		patientOut.setDeceased(source.getDeceasedBoolean().isValue());
		patientOut.setDateDeceased(convertDateTimeToLocalDate(source.getDeceasedDateTime()));
		return patientOut;
	}
	
	protected Gender convertGender(Code genderCode) {
		switch (genderCode.getValue()) {
		case "M":
			return Gender.MALE;
		case "F":
			return Gender.FEMALE;
		case "UN":
			return Gender.OTHER;
		default:
			return Gender.OTHER;
		}
	}
	
	protected LocalDate convertDateTimeToLocalDate(DateTime dateTime) {
		return LocalDate.parse(dateTime.getValue(), DateTimeFormatter.ISO_INSTANT);
	}
}
