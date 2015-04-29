package com.github.jlgrock.snp.core.data;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.apis.connection.MongoDatabaseManager;
import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.connection.configuration.MongoDbConfiguration;
import com.github.jlgrock.snp.apis.connection.synchronization.TransactionSynchronizationManager;
import com.github.jlgrock.snp.core.connection.SimpleMongoDbFactory;
import com.github.jlgrock.snp.core.converters.PatientReadConverter;
import com.github.jlgrock.snp.core.converters.PatientWriteConverter;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;

public class PatientRepositoryImplTest {
	
	//@Mock
	//private SimpleMongoDbFactory mdbf;
	//@Mock
	//private MongoDbConfiguration mongoDbConfiguration;
	//@Mock
	//private MongoDatabaseManager mongoDatabaseManagerIn;
	//@Mock
	//private TransactionSynchronizationManager synchronizationManagerIn;
	//private PatientReadConverter prc = new PatientReadConverter();
	//private PatientWriteConverter pwc = new PatientWriteConverter();
	//@Spy
	//private PatientRepositoryImpl pri;
	//private MongoCollection mc = Mockito.mock(MongoCollection.class);
	//private MongoDatabase mdb = Mockito.mock(MongoDatabase.class);
	
	@Mock
	private PatientRepositoryImpl pri;
	
	//private List<Patient> list = new ArrayList();
	
	@BeforeMethod
	public void setUp() throws Exception {
		
		
		
		
		
		//mdbf = new SimpleMongoDbFactory(mongoDbConfiguration, mongoDatabaseManagerIn, synchronizationManagerIn);
		
		//pri = new PatientRepositoryImpl(mdbf, prc, pwc);
		/**
		Patient patient1 = new Patient();
		patient1.setFirstName("Justin");
		patient1.setLastName("Grant");
		patient1.setGender(Gender.MALE);
		patient1.setRace(Race.CAUCASIAN);
		patient1.setDateOfBirth(LocalDate.of(2001, 1, 1));
		list.add(patient1);
		
		Patient patient2 = new Patient();
		patient2.setFirstName("Soyun");
		patient2.setLastName("Choi");
		patient2.setGender(Gender.FEMALE);
		patient2.setRace(Race.ASIAN);
		patient2.setDateOfBirth(LocalDate.of(2002, 2, 2));
		list.add(patient2);
		
		Patient patient3 = new Patient();
		patient3.setFirstName("Rodney");
		patient3.setLastName("Johnson");
		patient3.setGender(Gender.MALE);
		patient3.setRace(Race.BLACK_AFRICAN_AMERICAN);
		patient3.setDateOfBirth(LocalDate.of(2003, 3, 3));
		list.add(patient3);
		
		Patient patient4 = new Patient();
		patient4.setFirstName("Vikram");
		patient4.setLastName("Bhole");
		patient4.setGender(Gender.MALE);
		patient4.setRace(Race.ASIAN);
		patient4.setDateOfBirth(LocalDate.of(2004, 4, 4));
		list.add(patient4);
	
		Patient patient5 = new Patient();
		patient5.setFirstName("Sunny");
		patient5.setLastName("Vashisht");
		patient5.setGender(Gender.MALE);
		patient5.setRace(Race.ASIAN);
		patient5.setDateOfBirth(LocalDate.of(2005, 5, 5));
		list.add(patient5);
	
		Patient patient6 = new Patient();
		patient6.setFirstName("Shane");
		patient6.setLastName("Lewis");
		patient6.setGender(Gender.MALE);
		patient6.setRace(Race.CAUCASIAN);
		patient6.setDateOfBirth(LocalDate.of(2006, 6, 6));
		list.add(patient6);
	
	**/
	
		
	
	}
	
	@Test
	public void testFindAllByLastName(){
		Document query = new Document() {{
            put("lastName", "Grant");
        }};
		 when(pri.executeQueryAndTransformResults(query)).thenReturn(list);
        //doReturn(list).when(pri.executeQueryAndTransformResults(query));
		 assertEquals("Justin", pri.findAllByLastName("Grant").get(0).getFirstName());
	}
	
	
   /* public List<Patient> findAllByLastName(String lastName) {
        Document query = new Document() {{
            put("lastName", lastName);
        }};
        return executeQueryAndTransformResults(query);
    }
	
	
	
	@Test
	public void addCustomerWithDummyTest() {
	 Customer dummy = mock(Customer.class);
	 AddressBook addressBook = new AddressBook();
	 addressBook.addCustomer(dummy);
	 AssertJUnit.assertEquals(1, addressBook.getNumberOfCustomers());
	}
	
	@Test
	public void testGetHighestPricedTrade() throws Exception {
	  Price price1 = new Price(10); 
	  Price price2 = new Price(15);
	  Price price3 = new Price(25);
	 
	  PricingRepository pricingRepository = mock(PricingRepository.class);
	  when(pricingRepository.getPriceForTrade(any(Trade.class)))
	    .thenReturn(price1, price2, price3);
	   
	  PricingService service = new SimplePricingService(pricingRepository);
	  Price highestPrice = service.getHighestPricedTrade(getTrades());
	  
	  AssertJUnit.assertEquals(price3.getAmount(), highestPrice.getAmount());
	}*/
	
	
}
