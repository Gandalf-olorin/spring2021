package mdef;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import mdef.rest.ConfiguracionRest;

@SpringBootApplication
@ImportResource({ "classpath:config/jpa-config.xml" })
@Import({ ConfiguracionPorJava.class, ConfiguracionRest.class })
public class ExamenSpring2021Application {
//Comandante Puentes
	public static void main(String[] args) {
		SpringApplication.run(ExamenSpring2021Application.class, args);
	}

}
