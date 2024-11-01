package com.nivieus.test_apis.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Profile("gcloud")
@Configuration
public class CloudSqlConnectionPoolFactory {

        private static final String INSTANCE_CONNECTION_NAME = "niveustraining:us-central1:varun-assignment2";
        private static final String DB_USER = "";
        private static final String DB_PASS = "";
        private static final String DB_NAME = "";

        @Bean
        public static DataSource createConnectionPool() {
            // create a new configuration and set the database credentials
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(String.format("jdbc:postgresql:///%s", DB_NAME));
            config.setUsername(DB_USER);
            config.setPassword(DB_PASS);
            config.addDataSourceProperty("socketFactory", "com.google.cloud.sql.postgres.SocketFactory");
            config.addDataSourceProperty("cloudSqlInstance", INSTANCE_CONNECTION_NAME);

            // Initialize the connection pool using the configuration object.
            return new HikariDataSource(config);
        }

}
