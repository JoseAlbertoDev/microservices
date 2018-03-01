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
package org.alberto.ingenia.notas.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.alberto.ingenia.modelos.Notas;
import org.alberto.ingenia.notas.controller.INotasApi;
import org.alberto.ingenia.notas.service.INotasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jamartin
 *
 */
@RestController
public class NotasApi implements INotasApi {
	
	private final INotasService notasService;
	
	public NotasApi(INotasService notasService) {
		super();
		this.notasService = notasService;
	}
	
	@Override
	public ResponseEntity<List<Notas>> getListaConTodasLasNotas() {
		List<Notas> lNotas = new ArrayList<>();
		ResponseEntity<List<Notas>> response = null;
		lNotas = notasService.getListNotas();
		response = crearRespuesta(lNotas, HttpStatus.NO_CONTENT);
		if (lNotas != null && !lNotas.isEmpty()) {
			response = crearRespuesta(lNotas, HttpStatus.OK);
		}			
		return response;
	}

	@Override
	public ResponseEntity<List<Notas>> getListaConLasNotasDeUnUsuario(String username) {
		List<Notas> lNotas = new ArrayList<>();
		ResponseEntity<List<Notas>> response = null;
		response = crearRespuesta(lNotas, HttpStatus.BAD_REQUEST);
		if (username != null && !username.isEmpty()) {
			lNotas = notasService.getNotasByUsername(username);
			response = crearRespuesta(lNotas, HttpStatus.NO_CONTENT);
			if (lNotas != null && !lNotas.isEmpty()) {
				response = crearRespuesta(lNotas, HttpStatus.OK);
			}
		}
		return response;
	}

	@Override
	public ResponseEntity<Notas> saveNota(@RequestBody Notas nota) {
		Notas newNota = null;
		ResponseEntity<Notas> response = null;
		response = crearRespuesta(newNota, HttpStatus.BAD_REQUEST);
		if(nota != null) {
			newNota = notasService.saveNota(nota);
			response = crearRespuesta(newNota, HttpStatus.OK);
		}
		return response;
	}

	@Override
	public <T> ResponseEntity<T> crearRespuesta(T lista, HttpStatus status) {
		ResponseEntity<T> response = new ResponseEntity<T>(lista, status);
		return response;
	}
}
