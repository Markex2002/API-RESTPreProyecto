package org.vdm.apirestpreproyecto.domain;

import jakarta.persistence.*;
import lombok.*;
import org.vdm.apirestpreproyecto.modelo.Usuario;


@Entity

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Administrador extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    private String nombre;


}