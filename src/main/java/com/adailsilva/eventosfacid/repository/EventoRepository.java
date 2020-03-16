package com.adailsilva.eventosfacid.repository;

import org.springframework.data.repository.CrudRepository;

import com.adailsilva.eventosfacid.models.Evento;

/**
 * @author AdailSilva
 */

public interface EventoRepository extends CrudRepository<Evento, String> {
	Evento findByCodigo(long codigo);

}
