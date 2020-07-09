package ec.com.altioracorp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"ec.com.altioracorp"})
@EnableJpaRepositories(basePackages="ec.com.altioracorp.repository")
@EnableTransactionManagement
@EntityScan(basePackages="ec.com.altioracorp.entities.dto")

public class EjercicioAltioraApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioAltioraApplication.class, args);
	}

}
