package com.github.jlgrock.snp.domain.types;

import com.google.common.base.MoreObjects;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

/**
 * The domain object that represents a single encounter in a patient visit.  Each encounter can consist
 * of multiple {@link com.github.jlgrock.snp.domain.types.Observation Observation} objects.
 */
public class Encounter extends AbstractMongoDomainObject {

    private String subject;
    
    private String encounterClass;

    private String status;

    private String participant;

    private String fhirId;

    @NotNull
    private ObjectId patientId;

    private List<Observation> observations;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("subject", subject)
                .add("encounterClass", encounterClass)
                .add("status", status)
                .add("participant", participant)
                .add("patientId", patientId)
                .add("observations", observations)
                .add("fhirId", fhirId)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), subject, encounterClass, status, participant, patientId, observations);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Encounter other = (Encounter) obj;
        return Objects.equals(getId(), other.getId())
                && Objects.equals(subject, other.subject)
                && Objects.equals(encounterClass, other.encounterClass)
                && Objects.equals(status, other.status)
                && Objects.equals(participant, other.participant)
                && Objects.equals(patientId, other.patientId)
                && Objects.equals(observations, other.observations)
                && Objects.equals(fhirId, other.fhirId);
    }

    public String getFhirId() {
        return fhirId;
    }

    public void setFhirId(final String fhirIdIn) {
        fhirId = fhirIdIn;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(final List<Observation> pObservations) {
        observations = pObservations;
    }

    public ObjectId getPatientId() {
        return patientId;
    }

	public void setPatientId(final ObjectId patientIdIn) {
        patientId = patientIdIn;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(final String statusIn) {
		status = statusIn;
	}

	public String getEncounterClass() {
		return encounterClass;
	}

	public void setEncounterClass(final String encounterClassIn) {
        encounterClass = encounterClassIn;
	}

	public String getParticipant() {
		return participant;
	}

	public void setParticipant(final String participantIn) {
		participant = participantIn;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(final String subjectIn) {
		subject = subjectIn;
	}
}

