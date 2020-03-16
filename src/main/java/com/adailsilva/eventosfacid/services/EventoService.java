package com.adailsilva.eventosfacid.services;

import java.util.List;

import com.adailsilva.eventosfacid.models.Evento;

/**
 * @author AdailSilva
 */

public interface EventoService {

	/**
	 * Para retornar um objeto evento obtido por ID (codigo)
	 * 
	 * @param eventoId
	 *            evento ID (codigo)
	 * @return Evento object
	 */
	Evento findById(Long eventoCodigo);

	/**
	 * @return a lista de todos os eventos
	 */
	List<Evento> findAllEventos();

	/**
	 * @param evento
	 *            Entidade do evento a ser salva
	 */
	Evento saveEvento(Evento evento);

	/**
	 * @param evento
	 *            Entidade evento para verificar a existência
	 * @return true, se existir; caso contrário, retorna false
	 */
	Boolean isEventoExist(Evento evento);

	/**
	 * @param id
	 *            ID (codigo) do evento a ser atualizado
	 * @param evento
	 *            entidade evento atualizada
	 * @return entidade evento atualizada
	 */
	Evento updateEvento(Long codigo, Evento evento);

	/**
	 * @param id
	 *            ID (codigo) do evento a ser atualizado
	 * @param evento
	 *            entidade evento atualizada
	 * @return entidade evento remendada
	 */
	Evento patchEvento(Long codigo, Evento evento);

	/**
	 * @param id
	 *            ID (codigo) do evento a ser excluído
	 * @return true, se excluído; caso contrário, retorna false
	 */
	Boolean deleteEvento(Long codigo);

}
