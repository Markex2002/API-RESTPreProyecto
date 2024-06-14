package org.vdm.apirestpreproyecto.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vdm.apirestpreproyecto.domain.OfertaTrabajo;

@Repository
public interface OfertaRepository extends JpaRepository<OfertaTrabajo, Long> {

}