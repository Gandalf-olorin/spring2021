package mdef;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositorySearchesResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import mdef.entidades.Comision;
import mdef.entidades.Fusil;
import mdef.entidades.Militar;
import mdef.entidades.Unidad;
import mdef.rest.ComisionController;
import mdef.rest.FusilController;
import mdef.rest.MixIns;

@Configuration
@ComponentScan("mdef.rest")
public class ConfiguracionPorJava {

	@Bean
	public Fusil getFusilBean() {
		Fusil fusil = new Fusil();
		return fusil;

	}

	@Bean
	public ObjectMapper getObjectMapper() {

		ObjectMapper mapper = new ObjectMapper();
		mapper.addMixIn(Fusil.class, MixIns.Fusil.class);
		mapper.addMixIn(Unidad.class, MixIns.Unidad.class);
		mapper.addMixIn(Militar.class, MixIns.Militar.class);
		mapper.addMixIn(Comision.class, MixIns.Comision.class);

		return mapper;
	}

	@Bean
	RepresentationModelProcessor<RepositorySearchesResource> addSearchLinks(RepositoryRestConfiguration config) {
		Map<Class<?>, Class<?>> controllersRegistrados = new HashMap<>();
		controllersRegistrados.put(Fusil.class, FusilController.class);
		controllersRegistrados.put(Comision.class, ComisionController.class);

		return new RepresentationModelProcessor<RepositorySearchesResource>() {

			@SuppressWarnings("deprecation")
			@Override
			public RepositorySearchesResource process(RepositorySearchesResource searchResource) {

				if (controllersRegistrados.containsKey(searchResource.getDomainType())) {
					Method[] metodos = controllersRegistrados.get(searchResource.getDomainType()).getDeclaredMethods();
					for (Method m : metodos) {
						if (!m.isAnnotationPresent(ResponseBody.class))
							continue;
						try {
							Object[] pathVars = Stream.of(m.getParameters())
									.filter(p -> p.isAnnotationPresent(PathVariable.class))
									.map(p -> "(" + p.getName() + ")").collect(Collectors.toList()).toArray();
							URI uri = linkTo(m, pathVars).toUri();
							String path = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(),
									config.getBasePath() + uri.getPath(), uri.getQuery(), uri.getFragment()).toString()
											.replace("(", "{").replace(")", "}");
							String requestParams = Stream.of(m.getParameters())
									.filter(p -> p.isAnnotationPresent(RequestParam.class)).map(Parameter::getName)
									.collect(Collectors.joining(","));
							searchResource.add(new Link(path + "{?" + requestParams + "}", m.getName()));
						} catch (URISyntaxException e) {
							e.printStackTrace();
						}
					}
				}

				return searchResource;
			}

		};
	}

	@Bean
	CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("*"));
		config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
		source.registerCorsConfiguration("/**", config);

		return new CorsFilter(source);
	}

}
