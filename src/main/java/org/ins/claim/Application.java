package org.ins.claim;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.ins.claim.domain.Claim;
import org.ins.claim.repositories.ClaimRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import java.util.Random;

@SpringBootApplication
@EnableR2dbcRepositories
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get("r2dbc:h2:mem:///test?options=DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
    }

    @Bean
    ConnectionFactoryInitializer initializer(@Qualifier("connectionFactory") ConnectionFactory connectionFactory) {

        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ByteArrayResource(("CREATE SEQUENCE primary_key;"
                + "DROP TABLE IF EXISTS claim;"
                + "CREATE TABLE claim (id SERIAL PRIMARY KEY, filing_timestamp BIGINT, policyholder_id VARCHAR(100) NOT NULL, claim_category VARCHAR(100) NOT NULL);")
                .getBytes())));

        return initializer;
    }


    @Bean
    public CommandLineRunner dataSetup(ClaimRepository claimRepository) {
        return (args) -> {
            Random r = new Random();
            claimRepository.save(new Claim(Math.abs(r.nextLong()), "foo-bar", "vehicle")).block();
        };
    }
}
