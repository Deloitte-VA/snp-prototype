package com.github.jlgrock.snp.core;

import com.github.jlgrock.snp.core.converters.*;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan
@EnableMongoRepositories("com.github.jlgrock.snp.core.data")
@PropertySource("classpath:application.properties")
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private String port;

    @Override
    public CustomConversions customConversions() {
        List<Converter<?, ?>> converterList = new ArrayList<>();
        converterList.add(new PatientReadConverter());
        converterList.add(new PatientWriteConverter());
        converterList.add(new EncounterReadConverter(new ObservationReadConverter()));
        converterList.add(new EncounterWriteConverter(new ObservationWriteConverter()));
        return new CustomConversions(converterList);
    }

    @Override
    protected String getDatabaseName() {
    	return "test";
    }

    @Override
    public MongoClient mongo() throws Exception {
        return new MongoClient(host + ":" + port);
    }
}

