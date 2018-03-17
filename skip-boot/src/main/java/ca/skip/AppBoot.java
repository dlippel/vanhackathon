package ca.skip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import ca.skip.api.config.CORSFilter;
import ca.skip.api.config.WebInitializer;
import ca.skip.api.controller.ControllersPackageInfo;
import ca.skip.service.ServicePackageInfo;

@EnableAutoConfiguration
@PropertySource(value = "classpath:database.properties", ignoreResourceNotFound = true)
@ComponentScan(basePackageClasses = { WebInitializer.class, ControllersPackageInfo.class, ServicePackageInfo.class })
public class AppBoot {

	/**
	 * Instancia do filter somente para o spring-boot
	 */
	@Bean
	public CORSFilter getCorsFilter() {
		return new CORSFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(AppBoot.class, args);
	}
}