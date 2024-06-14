package org.vdm.apirestpreproyecto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vdm.apirestpreproyecto.domain.*;
import org.vdm.apirestpreproyecto.repository.AdministradorRepository;
import org.vdm.apirestpreproyecto.repository.ArtistaRepository;
import org.vdm.apirestpreproyecto.repository.EmpresaRepository;
import org.vdm.apirestpreproyecto.repository.ImagenRepository;

import java.math.BigDecimal;
import java.util.*;

@SpringBootTest
class ApiRestPreProyectoApplicationTests {

    @Autowired
    ArtistaRepository artistaRepository;
    @Autowired
    EmpresaRepository empresaRepository;
    @Autowired
    ImagenRepository imagenRepository;
    @Autowired
    AdministradorRepository administradorRepository;

    @Test
    void contextLoads() {}

    @Test
    void pruebaCRUDPeliculaCategoria(){
        ////PRUEBAS DE CREACION ARTISTA-OFERTA////
    }

    @Test
    void pruebaCRUDTodo(){
        //PRUEBA CREAR Y GUARDAR UN ARTISTA
        Artista artista1 = Artista.builder()
                .nombre("VanGogh")
                .build();
        artistaRepository.save(artista1);
        //PRUEBA CREAR Y GUARDAR UN ARTISTA
        Artista artista2 = Artista.builder()
                .nombre("SrPelo")
                .build();
        artistaRepository.save(artista2);

        //Prueba crear y guardar varias Empresa
        Empresa empresa = new Empresa();
        empresa.setNombreEmpresa("Nintendo");
        empresaRepository.save(empresa);

        Empresa empresa1 = new Empresa();
        empresa1.setNombreEmpresa("Sega");
        empresaRepository.save(empresa1);

        Empresa empresa2 = new Empresa();
        empresa2.setNombreEmpresa("Capcom");
        empresaRepository.save(empresa2);

        //Prueba crear y guardar varios Administradores
        Administrador administrador1 = Administrador.builder()
                .privilegeLevel(1)
                .nombre("Maximo")
                .build();
        administradorRepository.save(administrador1);
        Administrador administrador2 = Administrador.builder()
                .privilegeLevel(2)
                .nombre("Steven")
                .build();
        administradorRepository.save(administrador2);
        Administrador administrador3 = Administrador.builder()
                .privilegeLevel(3)
                .nombre("Mario")
                .build();
        administradorRepository.save(administrador3);
        Administrador administrador4 = Administrador.builder()
                .privilegeLevel(2)
                .nombre("Luigi")
                .build();
        administradorRepository.save(administrador4);




        //Prueba crear y guardar una Imagenes
        Imagen imagen1 = Imagen.builder()
                .artista(artista1)
                .url("")
                .nombre("img1")
                .build();
        Imagen imagen2 = Imagen.builder()
                .artista(artista1)
                .url("")
                .nombre("img2")
                .build();
        Imagen imagen3 = Imagen.builder()
                .artista(artista1)
                .url("")
                .nombre("img3")
                .build();
        Imagen imagen4 = Imagen.builder()
                .artista(artista2)
                .url("")
                .nombre("img4")
                .build();
        imagenRepository.save(imagen1);
        imagenRepository.save(imagen2);
        imagenRepository.save(imagen3);
        imagenRepository.save(imagen4);

        //Creamos un PortFolio y lo insertamos en el Artista
        List<Imagen> listaImagenes1 = new ArrayList<>();
        listaImagenes1.add(imagen1);
        listaImagenes1.add(imagen2);
        artista1.setPortfolio(listaImagenes1);

        //Creamos una lista con el Artista
        Set<Artista> listaArtistas = new HashSet<>();
        listaArtistas.add(artista1);


        OfertaTrabajo ofertaTrabajo = OfertaTrabajo.builder()
                .duracionJornada(20)
                .avaiablePositions(2)
                .salarioBrutoMin(10000)
                .salarioBrutoMax(14000)
                .artistas(listaArtistas)
                .build();

    }
}