package org.vdm.apirestpreproyecto;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.vdm.apirestpreproyecto.domain.Artista;
import org.vdm.apirestpreproyecto.domain.Empresa;
import org.vdm.apirestpreproyecto.domain.Imagen;
import org.vdm.apirestpreproyecto.repository.ArtistaRepository;
import org.vdm.apirestpreproyecto.repository.EmpresaRepository;
import org.vdm.apirestpreproyecto.repository.ImagenRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class PreProyectoApplication implements CommandLineRunner{

	@Autowired
	ArtistaRepository artistaRepository;
	@Autowired
	EmpresaRepository empresaRepository;
	@Autowired
	ImagenRepository imagenRepository;



	public static void main(String[] args) {
		SpringApplication.run(PreProyectoApplication.class, args);
	}
	
	@Override
	public void run(String... args){
		log.info("*******************************");
		log.info("*Prueba de arranque ClienteDAO*");
		log.info("*******************************");


		log.info("************************************");
		log.info("*FIN: Prueba de arranque ComercialDAO*");
		log.info("************************************");
	}
}