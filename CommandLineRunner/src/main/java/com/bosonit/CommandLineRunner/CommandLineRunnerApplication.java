package com.bosonit.CommandLineRunner;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CommandLineRunnerApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(CommandLineRunnerApplication.class);

	public static void main(String[] args) {

		LOG.info("\n START: empezando app");


		SpringApplication.run(CommandLineRunnerApplication.class, args);

		LOG.info("\n STOP: terminando app");
	}

	@Override
	public void run(String... args) throws Exception {

		LOG.info("EXECUTING : command line runner");

		for (int i = 0; i <= 10; i++) {
			LOG.info("Count =" + i);
		}
	}
}
