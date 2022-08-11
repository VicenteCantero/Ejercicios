package com.bosonit.ConfigurationProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ConfigurationPropertiesScan

public class ConfigurationPropertiesApplication {


	@Autowired
	private SimpleProperties simpleProperties;

	@Autowired
	private InmutableProperties inmutableProperties;

	@Autowired
	private NestedProperties nestedProperties;

	@Autowired
	private ConvertedProperties convertedProperties;

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationPropertiesApplication.class, args);
	}

	//@Autowired
	//private BeanProperties beanProperties;

	@PostConstruct
	private void postInit(){
		System.out.println("Simple propierties info...");
		System.out.println(simpleProperties);


		//System.out.println("Inmutable propierties info...");
		//System.out.println(inmutableProperties);

		//System.out.println("Nested propierties info...");
		//System.out.println(nestedProperties);

		/*System.out.println("Converted propierties info...");
		System.out.println(convertedProperties.getDuration().toNanos() + "ns");
		System.out.println(convertedProperties.getPeriod().getYears() + "years" + convertedProperties.getPeriod().getDays()+ "days");
		System.out.println(convertedProperties.getDatasize().toTerabytes() + "TB");
		System.out.println(convertedProperties.getCustomProperty().getName());
		System.out.println(convertedProperties.getCustomProperty().isInmutable());*/

		//System.out.println("Bean propierties info...");
		//System.out.println(beanProperties.getName());
	}

	@ConfigurationProperties(prefix= "bean")
	@Bean
	BeanProperties beanProperties(){
		return new BeanProperties();
	}
}
