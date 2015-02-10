package com.github.jlgrock.snp.client;

import com.github.jlgrock.snp.core.MyConnection;
import com.github.jlgrock.snp.core.data.PatientRepository;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jlgrock on 1/11/15.
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class MongoApplication implements CommandLineRunner {
    private static Logger LOGGER = LoggerFactory.getLogger(MongoApplication.class);

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MyConnection myConnection;

    public static void main(String[] args) throws Exception {
        LOGGER.info("Starting Mongo Application.");
        SpringApplication.run(MongoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        //print the current connection info
        myConnection.printAddress();

        //example of how to access the patients repository, which works much like any of the repositories
        printPatientCount();

        LOGGER.info("Inserting a patient...");
        Patient p1 = new Patient();
        p1.setId(1l);
        p1.setFirstName("Jason");
        p1.setMiddleName("Gerald");
        p1.setLastName("Bourne");
        p1.setGender(Gender.OTHER);
        p1.setRace(Race.OTHER);
        DateTime d = new DateTime("21/12/2012");
        p1.setDateOfBirth(d);
        patientRepository.save(p1);

        printPatientCount();

        LOGGER.info("Patients found with findAll():");
        LOGGER.info("-------------------------------");
        for (Patient patient: patientRepository.findAll()) {
            LOGGER.info(patient.toString());
        }
        LOGGER.info("");

        LOGGER.info("Deleting the previously inserted patient...");
        patientRepository.delete(p1);
        printPatientCount();

    }

    private void printPatientCount() {
        LOGGER.info("Current number of patients: {}", patientRepository.count());
    }

}
