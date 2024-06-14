package org.vdm.apirestpreproyecto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vdm.apirestpreproyecto.domain.Artista;
import org.vdm.apirestpreproyecto.domain.Empresa;
import org.vdm.apirestpreproyecto.domain.Imagen;
import org.vdm.apirestpreproyecto.domain.OfertaTrabajo;
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

    @Test
    void contextLoads() {}

    @Test
    void pruebaCRUDPeliculaCategoria(){
        ////PRUEBAS DE CREACION ARTISTA-OFERTA////
    }

    @Test
    void pruebaCRUDArtista(){
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

        //Prueba crear y guardar una Empresa
        Empresa empresa = new Empresa();
        empresa.setNombre("Nintendo");
        empresaRepository.save(empresa);


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