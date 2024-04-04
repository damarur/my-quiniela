package es.damarur.myquiniela.config;

import es.damarur.myquiniela.domain.Quiniela;
import es.damarur.myquiniela.repository.TeamRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = TeamRepository.class)
@EnableJpaAuditing
@EntityScan(basePackageClasses = Quiniela.class)
public class RepositoryConfiguration {
}
