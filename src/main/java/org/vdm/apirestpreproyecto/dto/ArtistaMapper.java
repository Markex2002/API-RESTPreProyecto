package org.vdm.apirestpreproyecto.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.vdm.apirestpreproyecto.domain.Artista;

@Mapper
public interface ArtistaMapper {

    ArtistaMapper INSTANCE = Mappers.getMapper(ArtistaMapper.class);

    @Mapping(source = "id_artista", target = "id_artista")
    ArtistaDTO artistaAArtistaDTO(Artista artista);
}