package org.vdm.apirestpreproyecto.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    private String url;
    private String nombre;

    @ManyToOne()
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;
}