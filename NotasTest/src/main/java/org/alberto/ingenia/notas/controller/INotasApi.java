/******************************************************************************
 * 
 *  $Id$
 * 
 * $Date$ 
 * $Revision$
 * $URL$ 
 * $Author$ 
 * 
 * Fecha creación 27 feb. 2018
 * 
 * @autor jamartin
 *
 *
 * ***************************************************************************/
package org.alberto.ingenia.notas.controller;

import java.util.List;

import org.alberto.ingenia.notas.model.Notas;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jamartin
 *
 */
public interface INotasApi {

	@RequestMapping(
			value = {"/getAllNotes"},
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			method = RequestMethod.GET)
	public ResponseEntity<List<Notas>> getListaConTodasLasNotas();
	
	@RequestMapping(
			value = {"/getAllNotesOf"},
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			method = RequestMethod.GET)
	public ResponseEntity<List<Notas>> getListaConLasNotasDeUnUsuario(@RequestParam("username") String username);
	
	@RequestMapping(
			value = {"/saveNote"},
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			method = RequestMethod.POST)
	public ResponseEntity<Notas> saveNota(Notas nota);
	
	public <T> ResponseEntity<T> crearRespuesta(T lista, HttpStatus status);
}
