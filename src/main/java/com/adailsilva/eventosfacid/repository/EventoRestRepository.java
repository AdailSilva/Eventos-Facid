package com.adailsilva.eventosfacid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adailsilva.eventosfacid.models.Evento;

/**
 * @author AdailSilva
 */

@Repository
public interface EventoRestRepository extends CrudRepository<Evento, Long> {

}
