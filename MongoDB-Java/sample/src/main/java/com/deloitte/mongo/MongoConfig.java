package com.deloitte.mongo;

import com.deloitte.mongo.converters.PatientReadConverter;
import com.deloitte.mongo.converters.PatientWriteConverter;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.host}")
    String host;

    @Value("${spring.data.mongodb.port}")
    String port;

    @Bean
    @Override
    public CustomConversions customConversions() {
        List<Converter> converterList = new ArrayList<Converter>();
        converterList.add(new PatientReadConverter());
        converterList.add(new PatientWriteConverter());
        return new CustomConversions(converterList);
    }

    @Override
    protected String getDatabaseName() {
        return "bla";
    }

    @Override
    public MongoClient mongo() throws Exception {
        return new MongoClient(host + ":" + port);
    }
}
