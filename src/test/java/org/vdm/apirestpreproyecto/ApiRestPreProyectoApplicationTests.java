package org.vdm.apirestpreproyecto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vdm.apirestpreproyecto.domain.*;
import org.vdm.apirestpreproyecto.repository.*;

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
    @Autowired
    OfertaRepository ofertaRepository;

    @Test
    void contextLoads() {}

    @Test
    void pruebaCRUDPeliculaCategoria(){
        ////PRUEBAS DE CREACION ARTISTA-OFERTA////
    }

    @Test
    void pruebaCRUDTodo(){
        //PRUEBA CREAR Y GUARDAR VARIOS ARTISTA
        Artista artista1 = Artista.builder()
                .nombre("VanGogh")
                .build();
        artistaRepository.save(artista1);
        Artista artista2 = Artista.builder()
                .nombre("SrPelo")
                .build();
        artistaRepository.save(artista2);

        //Prueba crear y guardar varias Empresa
        Empresa empresa1 = Empresa.builder()
                .nombreEmpresa("Nintendo")
                .numTlf(521522523)
                .build();
        empresaRepository.save(empresa1);

        Empresa empresa2 = Empresa.builder()
                .nombreEmpresa("Sega")
                .numTlf(123456789)
                .build();
        empresaRepository.save(empresa2);

        Empresa empresa3 = Empresa.builder()
                .nombreEmpresa("Capcom")
                .numTlf(222333444)
                .build();
        empresaRepository.save(empresa3);


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

        //Creamos un PortFolio y lo insertamos en el Artista//
        List<Imagen> listaImagenes1 = new ArrayList<>();
        listaImagenes1.add(imagen1);
        listaImagenes1.add(imagen2);
        artista1.setPortfolio(listaImagenes1);

        //Creamos una lista con el Artista//
        Set<Artista> listaArtistas = new HashSet<>();
        listaArtistas.add(artista1);


        //CREAMOS VARIAS OFERTAS DE TRABAJO//
        OfertaTrabajo ofertaTrabajo1 = OfertaTrabajo.builder()
                .empresa(empresa1)
                .duracionJornada(20)
                .avaiablePositions(2)
                .salarioBrutoMin(10000)
                .salarioBrutoMax(14000)
                .artistas(listaArtistas)
                .build();
        ofertaRepository.save(ofertaTrabajo1);
        OfertaTrabajo ofertaTrabajo2 = OfertaTrabajo.builder()
                .empresa(empresa2)
                .duracionJornada(20)
                .avaiablePositions(2)
                .salarioBrutoMin(6000)
                .salarioBrutoMax(20000)
                .build();
        ofertaRepository.save(ofertaTrabajo2);
    }
}