package org.vdm.apirestpreproyecto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vdm.apirestpreproyecto.domain.*;
import org.vdm.apirestpreproyecto.repository.*;
import org.vdm.apirestpreproyecto.service.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@SpringBootTest
class ApiRestPreProyectoApplicationTests {

    @Autowired
    ArtistaService artistaService;
    @Autowired
    EmpresaService EmpresaService;
    @Autowired
    ImagenService imagenService;
    @Autowired
    AdministradorService administradorService;
    @Autowired
    OfertaService ofertaService;
    @Autowired
    IdiomaService idiomaService;
    @Autowired
    private EmpresaService empresaService;

    @Test
    void contextLoads() {}


    @Test
    void testPersistenciaOneToMany() {
        List<Imagen> listaImagenes = artistaService.one(1L).getPortfolio();
        listaImagenes.forEach(imagen -> System.out.println(imagen.getNombre()));
    }


    //TESTPRINCIPAL
    //PRUEBA DE TODOS LOS CRUDS Y CREACION DE RELACIONES
    @Test
    void pruebaCRUDTodo(){
        pruebaCRUDArtista();
        pruebaCRUDEmpresa();
        pruebaCRUDAdministrador();
        pruebaCRUDImagen();

        /////ESTO NO ES NECESARIO, EL PORTFOLIO SE CREA SOLO/////
        //Creamos un PortFolio y lo insertamos en el Artista//
        //List<Imagen> listaImagenes = imagenService.all();
        //List<Imagen> listaPotfolio = new ArrayList<>();

        //listaImagenes.forEach(imagen -> {
        //    if (imagen.getArtista().getId() == artistaService.one(1L).getId()) {
        //        listaPotfolio.add(imagen);
        //    }
        //});
        //artistaService.one(1L).setPortfolio(listaPotfolio);



        //IMPORTANTE TENER ARTISTAS EN LA DB//
        //Creamos una lista con el Artista//
        Set<Artista> listaArtistas1 = new HashSet<>();
        listaArtistas1.add(artistaService.one(1L));

        Set<Artista> listaArtistas2 = new HashSet<>();
        listaArtistas2.add(artistaService.one(2L));

        //Creamos una lista con el Artista//
        Set<Artista> listaArtistas3 = new HashSet<>();
        listaArtistas3.add(artistaService.one(1L));
        listaArtistas3.add(artistaService.one(2L));


        //PRUEBA DE LA CREACION DE MANYTOMANY//
        //CREAMOS VARIAS OFERTAS DE TRABAJO//
        OfertaTrabajo ofertaTrabajo1 = OfertaTrabajo.builder()
                .empresa(empresaService.one(1L))
                .duracionJornada(20)
                .avaiablePositions(2)
                .salarioBrutoMin(10000)
                .salarioBrutoMax(14000)
                .artistas(listaArtistas1)
                .build();
        ofertaService.save(ofertaTrabajo1);
        OfertaTrabajo ofertaTrabajo2 = OfertaTrabajo.builder()
                .empresa(empresaService.one(2L))
                .duracionJornada(20)
                .avaiablePositions(2)
                .salarioBrutoMin(6000)
                .salarioBrutoMax(20000)
                .artistas(listaArtistas2)
                .build();
        ofertaService.save(ofertaTrabajo2);
        OfertaTrabajo ofertaTrabajo3 = OfertaTrabajo.builder()
                .empresa(empresaService.one(1L))
                .duracionJornada(20)
                .avaiablePositions(1)
                .salarioBrutoMin(12000)
                .salarioBrutoMax(24000)
                .artistas(listaArtistas3)
                .build();
        ofertaService.save(ofertaTrabajo3);


        //LLamamos al test de Idioma
        pruebaCRUDIdioma();
    }

    /////PRUEBA DEL CRUD DE ARTISTA/////
    @Test
    void pruebaCRUDArtista(){
        //CREAR
        //PRUEBA CREAR Y GUARDAR VARIOS ARTISTA
        Artista artista1 = Artista.builder()
                .nombre("VanGogh")
                .yearsOfExperience(6)
                .build();
        artistaService.save(artista1);
        Artista artista2 = Artista.builder()
                .nombre("SrPelo")
                .yearsOfExperience(4)
                .build();
        artistaService.save(artista2);
        Artista artista3 = Artista.builder()
                .nombre("Markex")
                .yearsOfExperience(10)
                .build();
        artistaService.save(artista3);


        //BORRAR
        artistaService.delete(3L);

        //EDITAR
        artista2.setNombre("SrPelonazo");
        artistaService.save(artista2);
    }

    /////PRUEBA DEL CRUD DE EMPRESA/////
    @Test
    void pruebaCRUDEmpresa(){
        //CREAR
        //PRUEBA CREAR Y GUARDAR VARIAS EMPRESAS
        Empresa empresa1 = Empresa.builder()
                .nombreEmpresa("Nintendo")
                .numTlf(521522523)
                .nombreRepresentante("Pedro")
                .build();
        EmpresaService.save(empresa1);
        Empresa empresa2 = Empresa.builder()
                .nombreEmpresa("Sega")
                .numTlf(123456789)
                .nombreRepresentante("Lucas")
                .build();
        EmpresaService.save(empresa2);
        Empresa empresa3 = Empresa.builder()
                .nombreEmpresa("Capcom")
                .nombreRepresentante("Marcos")
                .numTlf(222333444)
                .build();
        EmpresaService.save(empresa3);
        Empresa empresa4 = Empresa.builder()
                .nombreEmpresa("Mobius")
                .nombreRepresentante("Juan")
                .numTlf(222333444)
                .build();
        EmpresaService.save(empresa4);


        //BORRAR
        empresaService.delete(4L);

        //EDITAR
        empresa1.setNombreEmpresa("Noentiendo");
        empresaService.save(empresa1);
    }

    /////PRUEBA DEL CRUD DE ADMINISTRADOR/////
    @Test
    void pruebaCRUDAdministrador(){
        //CREAR
        //PRUEBA CREAR Y GUARDAR VARIOS ADMINISTRADORES
        Administrador administrador1 = Administrador.builder()
                .privilegeLevel(1)
                .nombre("Maximo")
                .build();
        administradorService.save(administrador1);
        Administrador administrador2 = Administrador.builder()
                .privilegeLevel(2)
                .nombre("Steven")
                .build();
        administradorService.save(administrador2);
        Administrador administrador3 = Administrador.builder()
                .privilegeLevel(3)
                .nombre("Mario")
                .build();
        administradorService.save(administrador3);
        Administrador administrador4 = Administrador.builder()
                .privilegeLevel(2)
                .nombre("Luigi")
                .build();
        administradorService.save(administrador4);

        //BORRAR
        administradorService.delete(4L);

        //EDITAR
        administrador1.setNombre("Waluigi");
        administradorService.save(administrador1);
    }

    /////PRUEBA DEL CRUD DE IDIOMAS/////
    @Test
    void pruebaCRUDIdioma(){
        //IMPORTANTE TENER ARTISTAS EN LA DB//
        //Creamos una lista con el Artista//
        Set<Artista> listaArtistas1 = new HashSet<>();
        listaArtistas1.add(artistaService.one(1L));

        Set<Artista> listaArtistas2 = new HashSet<>();
        listaArtistas2.add(artistaService.one(2L));

        //Creamos una lista con el Artista//
        Set<Artista> listaArtistas3 = new HashSet<>();
        listaArtistas3.add(artistaService.one(1L));
        listaArtistas3.add(artistaService.one(2L));
        //Importante que esto no este vacio o fallará
        OfertaTrabajo ofertaTrabajo = ofertaService.one(1L);

        //Creacion de un Date
        LocalDateTime fechaActual = LocalDateTime.now();
        ZonedDateTime zonedDateTime = fechaActual.atZone(ZoneId.systemDefault());
        Date dateFechaActrual = Date.from(zonedDateTime.toInstant());


        //CREAR
        Idioma idioma1 = Idioma.builder()
                .ultimaActualizacion(dateFechaActrual)
                .artistas(listaArtistas1)
                .ofertaTrabajo(ofertaTrabajo)
                .nombre("Spanish")
                .build();
        idiomaService.save(idioma1);
        Idioma idioma2 = Idioma.builder()
                .ultimaActualizacion(dateFechaActrual)
                .nombre("English")
                .artistas(listaArtistas2)
                .ofertaTrabajo(ofertaTrabajo)
                .build();
        idiomaService.save(idioma2);
        Idioma idioma3 = Idioma.builder()
                .ultimaActualizacion(dateFechaActrual)
                .artistas(listaArtistas3)
                .ofertaTrabajo(ofertaTrabajo)
                .nombre("French")
                .build();
        idiomaService.save(idioma3);
        Idioma idioma4 = Idioma.builder()
                .ultimaActualizacion(dateFechaActrual)
                .artistas(listaArtistas1)
                .ofertaTrabajo(ofertaTrabajo)
                .nombre("Japanese")
                .build();
        idiomaService.save(idioma4);

        //BORRAR
        idiomaService.delete(4L);

        //EDITAR
        //idioma3.setNombre("Chinese");
        //idiomaService.save(idioma3);
    }

    /////PRUEBA DEL CRUD DE IMAGEN/////
    @Test
    void pruebaCRUDImagen(){
        //Importante que esto no este vacio o fallará
        Artista artista = artistaService.one(1L);

        //CREAR
        Imagen imagen1 = Imagen.builder()
                .artista(artista)
                .url("/imgs/img1.png")
                .nombre("img1")
                .build();
        Imagen imagen2 = Imagen.builder()
                .artista(artista)
                .url("/imgs/img2.png")
                .nombre("img2")
                .build();
        Imagen imagen3 = Imagen.builder()
                .artista(artista)
                .url("/imgs/img3.png")
                .nombre("img3")
                .build();
        Imagen imagen4 = Imagen.builder()
                .artista(artista)
                .url("/imgs/img4.png")
                .nombre("img4")
                .build();
        imagenService.save(imagen1);
        imagenService.save(imagen2);
        imagenService.save(imagen3);
        imagenService.save(imagen4);

        //BORRAR
        imagenService.delete(4L);

        //EDITAR
        imagen3.setNombre("img999");
        imagenService.save(imagen3);
    }
}