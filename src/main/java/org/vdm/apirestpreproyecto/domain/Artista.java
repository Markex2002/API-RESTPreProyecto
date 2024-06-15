package org.vdm.apirestpreproyecto.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.vdm.apirestpreproyecto.modelo.Usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "artista")

@EqualsAndHashCode(callSuper = true)

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Artista extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@EqualsAndHashCode.Include
    private long id_artista;
    private String nombre;
    private int yearsOfExperience;

    @Column(name = "Porfolio")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "artista")
    @JsonIgnore
    @ToString.Exclude
    private List<Imagen> portfolio;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "artistas")
    @JsonIgnore
    @ToString.Exclude
    private List<Idioma> idiomasHablados = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "artistas")
    @ToString.Exclude
    @JsonIgnore
    Set<OfertaTrabajo> ofertasTrabajos = new HashSet<>();
}