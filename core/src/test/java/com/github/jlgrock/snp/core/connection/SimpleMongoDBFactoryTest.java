package com.github.jlgrock.snp.core.connection;

import com.github.jlgrock.snp.apis.connection.MongoDBConfiguration;
import com.github.jlgrock.snp.apis.connection.MongoDatabaseManager;
import com.github.jlgrock.snp.apis.connection.synchronization.TransactionSynchronizationManager;
import com.mongodb.DB;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

@Test
public class SimpleMongoDBFactoryTest {

    @Spy
    MongoDBConfiguration mongoDBConfiguration = new MongoDBConfiguration() {
        @Override
        public Optional<List<MongoCredential>> getUserCredentials() {
            return null;
        }

        @Override
        public Optional<ServerAddress> getHost() {
            return null;
        }

        @Override
        public Optional<List<ServerAddress>> getHosts() {
            return null;
        }

        @Override
        public String getDefaultDatabase() {
            return null;
        }
    };

    @Spy
    MongoDatabaseManager mongoDatabaseManagerIn = new MongoDatabaseManager() {
        @Override
        public void addDb(String key, DB session) {

        }

        @Override
        public DB removeDB(String dbName) {
            return null;
        }

        @Override
        public boolean containsDB(DB session) {
            return false;
        }

        @Override
        public boolean containsDB(String key) {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public DB getDB(String key) {
            return null;
        }
    };

    //Not used yet...
    @Mock
    TransactionSynchronizationManager synchronizationManagerIn;

    @BeforeMethod
    public void setUp() throws Exception {
        // Required to make this work on TestNG
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void testThatCredentialsAreAccessed() throws Exception {
//        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoDBConfiguration, mongoDatabaseManagerIn, synchronizationManagerIn);
//        simpleMongoDbFactory.db();
//        verify(mongoDBConfiguration).getHost();
//        verify(mongoDBConfiguration).getDefaultDatabase();
//    }
//
//    @Test
//    public void testThatManagerIsUsed() throws Exception {
//        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoDBConfiguration, mongoDatabaseManagerIn, synchronizationManagerIn);
//        simpleMongoDbFactory.db();
//        verify(mongoDatabaseManagerIn).addDb(anyString(), any(DB.class));
//    }
}
