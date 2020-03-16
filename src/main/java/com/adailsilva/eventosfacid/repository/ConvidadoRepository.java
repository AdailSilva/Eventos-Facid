package com.adailsilva.eventosfacid.repository;

import org.springframework.data.repository.CrudRepository;

import com.adailsilva.eventosfacid.models.Convidado;
import com.adailsilva.eventosfacid.models.Evento;

/**
 * @author AdailSilva
 */

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
	Iterable<Convidado> findByEvento(Evento evento);

	// criando busca específica por rg para deletar um convidado
	Convidado findByRg(String rg);
}
