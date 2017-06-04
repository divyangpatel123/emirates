package com.emirates.flight.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author divyang.patel
 * The Class RepositoryConfiguration.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.emirates.flight"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
