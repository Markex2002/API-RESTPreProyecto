package org.vdm.apirestpreproyecto;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBootWebMvcJdbcProyectoApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebMvcJdbcProyectoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		log.info("*******************************");
		log.info("*Prueba de arranque ClienteDAO*");
		log.info("*******************************");




		log.info("************************************");
		log.info("*FIN: Prueba de arranque ComercialDAO*");
		log.info("************************************");
	}
}