package com.java.nas.cassie.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;

/**
 * Utility class for getting the CassandraOperations object.
 * @author Naser Ahmed
 * @version 1.0
 */

@Configuration
@PropertySource(value = { "classpath:application.properties" })
public class CassandraConfig extends AbstractCassandraConfiguration {


    @Value("${spring.data.cassandra.contact-points}")
    private String host;

    @Value("${spring.data.cassandra.port}")
    private int port;

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keyspaceName;

    @Override
    protected String getContactPoints() {
        return host;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Bean
    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(getContactPoints());
        cluster.setKeyspaceCreations(getKeyspaceCreations());
        cluster.setPort(getPort());
        return cluster;
    }
}
