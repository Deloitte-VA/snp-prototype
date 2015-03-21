package com.github.jlgrock.snp.integration.connection;

import com.github.jlgrock.snp.apis.connection.MongoDatabaseManager;
import com.github.jlgrock.snp.apis.connection.configuration.MongoDbConfiguration;
import com.github.jlgrock.snp.apis.connection.synchronization.TransactionSynchronizationManager;
import com.github.jlgrock.snp.core.connection.SimpleMongoDbFactory;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;

@Test
public class SimpleMongoDbFactoryTest {

    @Mock
    ServerAddress serverAddress;

    @Spy
    MongoDbConfiguration mongoDBConfiguration = new MongoDbConfiguration() {
        @Override
        public Optional<List<MongoCredential>> getUserCredentials() {
            return Optional.ofNullable(null);
        }

        @Override
        public Optional<ServerAddress> getHost() {
            return Optional.of(serverAddress);
        }

        @Override
        public Optional<List<ServerAddress>> getHosts() {
            return null;
        }

        @Override
        public String getDefaultDatabase() {
            return "bla";
        }
    };

    @Spy
    MongoDatabaseManager mongoDatabaseManagerIn = new MongoDatabaseManager() {
        @Override
        public void addDb(String key, DB session) {

        }

        @Override
        public DB removeDb(String dbName) {
            return null;
        }

        @Override
        public boolean containsDb(DB session) {
            return false;
        }

        @Override
        public boolean containsDb(String key) {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public DB getDb(String key) {
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

    @Test
    public void testThatCredentialsAreAccessed() throws Exception {
        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoDBConfiguration, mongoDatabaseManagerIn, synchronizationManagerIn);
        simpleMongoDbFactory.db();
        verify(mongoDBConfiguration).getHost();
        verify(mongoDBConfiguration).getDefaultDatabase();
    }

    @Test
    public void testThatManagerIsUsed() throws Exception {
        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoDBConfiguration, mongoDatabaseManagerIn, synchronizationManagerIn);
        simpleMongoDbFactory.db();
        verify(mongoDatabaseManagerIn).addDb(anyString(), any(DB.class));
    }
}
