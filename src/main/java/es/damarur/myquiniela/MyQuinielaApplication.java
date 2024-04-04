package es.damarur.myquiniela;

import es.damarur.myquiniela.config.RepositoryConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackageClasses = {
				RepositoryConfiguration.class
		}
)
public class MyQuinielaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyQuinielaApplication.class, args);
	}

}
