package org.vdm.apirestpreproyecto.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.vdm.apirestpreproyecto.modelo.Usuario;

import java.util.List;

@Entity

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empresa extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    private String nombre;


    @OneToMany(mappedBy = "empresa")
    @JsonIgnore
    @ToString.Exclude
    private List<OfertaTrabajo> listadoOfertas;

}