package org.ins.claim;

import org.ins.claim.domain.Claim;
import org.ins.claim.repositories.ClaimRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Random;

@SpringBootApplication
@EnableJpaRepositories("org.ins.claim.repositories")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner dataSetup(ClaimRepository claimRepository) {
        return (args) -> {
            Random r = new Random();
            claimRepository.save(new Claim(r.nextLong(), "foo-bar", "vehicle"));
        };
    }
}
