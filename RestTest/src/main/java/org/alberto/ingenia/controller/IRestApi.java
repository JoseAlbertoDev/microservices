/******************************************************************************
 * 
 *  $Id$
 * 
 * Copyright 2018 INGENIA S.A. All rights reserved.
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
package org.alberto.ingenia.controller;

import java.util.List;

import org.alberto.ingenia.model.Notas;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jamartin
 *
 */
public interface IRestApi {

	@RequestMapping(
			value = {"/getAllNotes"},
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Notas>> getListaConTodasLasNotas();
	
	@RequestMapping(
			value = {"/getAllNotesOf"},
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Notas>> getListaConLasNotasDeUnUsuario(@RequestParam("username") String username);
	
	@RequestMapping(
			value = {"/saveNota"},
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Notas> saveNota(@RequestBody Notas nota);
	
	public <T> ResponseEntity<List<T>> crearRepuesta(List<T> lista, HttpStatus status);
}
