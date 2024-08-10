package com.agpf.recrutamento.configuration;

import org.flywaydb.core.Flyway;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;

@Configuration
public class RepairFlyMigration {
    protected final Logger log = LoggerFactory.getLogger(RepairFlyMigration.class);

    @Bean
    public FlywayMigrationStrategy cleanMigrateStrategy() {
        return new FlywayMigrationStrategy() {

            @Override
            public void migrate(Flyway flyway) {
                flyway.repair();
                flyway.migrate();
            }
        };
    }
}