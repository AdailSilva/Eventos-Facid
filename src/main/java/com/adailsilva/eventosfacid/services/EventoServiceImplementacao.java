package com.adailsilva.eventosfacid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adailsilva.eventosfacid.models.Evento;
import com.adailsilva.eventosfacid.repository.EventoRestRepository;

/**
 * @author AdailSilva
 */

@Service("eventoService")
public class EventoServiceImplementacao implements EventoService {

	@Autowired
	private EventoRestRepository eventoRepository;

	@Override
	public Evento findById(final Long eventoCodigo) {
		return eventoRepository.findOne(eventoCodigo);
	}

	@Override
	public List<Evento> findAllEventos() {
		return (List<Evento>) eventoRepository.findAll();
	}

	@Override
	public Evento saveEvento(final Evento evento) {
		return eventoRepository.save(evento);
	}

	@Override
	public Boolean isEventoExist(final Evento evento) {
		if (evento.getCodigo() > 0) { // era [ != null ] ao invéz de [ > 0 ]
			final Evento existingEvento = eventoRepository.findOne(evento.getCodigo());
			if (existingEvento == null) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public Evento updateEvento(final Long codigo, final Evento evento) {

		final Evento fetchedEvento = eventoRepository.findOne(codigo);
		if (fetchedEvento == null) {
			return null;
		}
		fetchedEvento.setNome(evento.getNome());
		fetchedEvento.setLocal(evento.getLocal());
		fetchedEvento.setData(evento.getData());
		fetchedEvento.setHorario(evento.getHorario());

		eventoRepository.save(fetchedEvento);

		return fetchedEvento;
	}

	@Override
	public Evento patchEvento(Long codigo, Evento evento) {

		final Evento fetchedEvento = eventoRepository.findOne(codigo);
		if (fetchedEvento == null) {
			return null;
		}

		if (evento.getNome() != null) {
			fetchedEvento.setNome(evento.getNome());
		}

		if (evento.getLocal() != null) {
			fetchedEvento.setLocal(evento.getLocal());
		}

		eventoRepository.save(fetchedEvento);

		return fetchedEvento;
	}

	@Override
	public Boolean deleteEvento(final Long codigo) {
		final Evento fetchedEvento = eventoRepository.findOne(codigo);
		if (fetchedEvento == null) {
			return false;
		} else {
			eventoRepository.delete(fetchedEvento);
			return true;
		}
	}

}
