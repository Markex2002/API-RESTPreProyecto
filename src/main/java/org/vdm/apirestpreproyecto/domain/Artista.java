package org.vdm.apirestpreproyecto.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.vdm.apirestpreproyecto.modelo.Usuario;

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
    @OneToMany(mappedBy = "artista")
    @JsonIgnore
    @ToString.Exclude
    private List<Imagen> portfolio;

    @OneToMany(mappedBy = "artista")
    @JsonIgnore
    @ToString.Exclude
    private List<Idioma> idiomasHablados;

    @ManyToMany(
            mappedBy = "artistas")
    @ToString.Exclude
    @JsonIgnore
    Set<OfertaTrabajo> ofertasTrabajos = new HashSet<>();
}