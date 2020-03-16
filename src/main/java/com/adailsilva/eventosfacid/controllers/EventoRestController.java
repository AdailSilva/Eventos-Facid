package com.adailsilva.eventosfacid.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.adailsilva.eventosfacid.models.Evento;
import com.adailsilva.eventosfacid.services.EventoService;

/**
 * @author AdailSilva
 */

@RestController
public class EventoRestController {

	@Autowired
	private EventoService eventoService;

	/**
	 * Recupera todos os eventos
	 * 
	 * @return ResponseEntity<List<Eventos>>
	 */
	@RequestMapping(value = "/wseventos", method = RequestMethod.GET)
	public ResponseEntity<List<Evento>> listAllCustomers() {
		final List<Evento> allEventos = eventoService.findAllEventos();
		if (allEventos.isEmpty()) {
			return new ResponseEntity<List<Evento>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Evento>>(allEventos, HttpStatus.OK);
	}

	/**
	 * Recupera um único evento
	 * 
	 * @param codigo
	 *            ID do evento
	 * @return ResponseEntity<Evento>
	 */
	@RequestMapping(value = "/wseventos/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Evento> getEvento(@PathVariable("codigo") final Long codigo) {
		final Evento fetchedEvento = eventoService.findById(codigo);
		if (fetchedEvento == null) {
			return new ResponseEntity<Evento>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Evento>(fetchedEvento, HttpStatus.OK);
	}

	/**
	 * Cria um Evento
	 * 
	 * @param evento
	 *            objeto a ser criado
	 * @param ueventoBuilder
	 *            UriComponentBuilder
	 * @return ResponseEntity<Void>
	 */
	@RequestMapping(value = "/wseventos", method = RequestMethod.POST)
	public ResponseEntity<Void> createEvento(@RequestBody final Evento evento, final UriComponentsBuilder ucBuilder) {

		if (eventoService.isEventoExist(evento)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		final Evento savedEvento = eventoService.saveEvento(evento);

		final HttpHeaders cabecalhos = new HttpHeaders();
		cabecalhos.setLocation(ucBuilder.path("/evento/{codigo}").buildAndExpand(savedEvento.getCodigo()).toUri());
		return new ResponseEntity<Void>(cabecalhos, HttpStatus.CREATED);
	}

	/**
	 * Atualizar um evento
	 * 
	 * @param codigo
	 *            ID do evento a ser atualizado
	 * 
	 * @param evento
	 *            objeto Evento de origem a ser atualizado
	 * @return ResponseEntity<Evento>
	 */
	@RequestMapping(value = "/wseventos/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Evento> updateEvento(@PathVariable("codigo") final Long codigo,
			@RequestBody final Evento evento) {
		final Evento updatedEvento = eventoService.updateEvento(codigo, evento);

		if (updatedEvento == null) {
			return new ResponseEntity<Evento>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Evento>(updatedEvento, HttpStatus.OK);
	}

	/**
	 * Corrigir um evento
	 * 
	 * @param codigo
	 *            ID do evento a ser corrigido
	 * @param evento
	 *            Objeto evento a ser corrigido
	 * @return ResponseEntity<Evento>
	 */
	@RequestMapping(value = "/wseventos/{codigo}", method = RequestMethod.PATCH)
	public ResponseEntity<Evento> patchEvento(@PathVariable("codigo") final Long codigo,
			@RequestBody final Evento evento) {
		final Evento patchedEvento = eventoService.patchEvento(codigo, evento);

		if (patchedEvento == null) {
			return new ResponseEntity<Evento>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Evento>(patchedEvento, HttpStatus.OK);
	}

	/**
	 * Excluir um evento
	 * 
	 * @param codigo
	 *            ID do evento a ser excluído
	 * @return ResponseEntity<Void>
	 */
	@RequestMapping(value = "/wseventos/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEvento(@PathVariable("codigo") final Long codigo) {
		Boolean excluirResultado = eventoService.deleteEvento(codigo);

		if (excluirResultado == null || !excluirResultado) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
