package mdef;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.databind.ObjectMapper;

import mdef.entidades.Comision;
import mdef.entidades.Militar;
import mdef.rest.MixIns;

@Configuration
@PropertySource({ "classpath:config/rest.properties", "classpath:config/jackson.properties" })
@ComponentScan("mdef")
public class ConfiguracionPorJava {

	@Bean
	public ObjectMapper getObjectMapper() {

		ObjectMapper mapper = new ObjectMapper();
		mapper.addMixIn(Militar.class, MixIns.Militares.class);
		mapper.addMixIn(Comision.class, MixIns.Comisiones.class);

		return mapper;
	}
}
