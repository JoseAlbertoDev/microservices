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
package org.alberto.ingenia.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.alberto.ingenia.controller.IRestApi;
import org.alberto.ingenia.model.Notas;
import org.alberto.ingenia.service.INotasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jamartin
 *
 */
@RestController
public class RestApi implements IRestApi {
	
	private final INotasService notasService;
	
	public RestApi(INotasService notasService) {
		super();
		this.notasService = notasService;
	}
	
	@Override
	public ResponseEntity<List<Notas>> getListaConTodasLasNotas() {
		List<Notas> lNotas = new ArrayList<>();
		ResponseEntity<List<Notas>> response = null;
		lNotas = notasService.getListNotas();
		if (lNotas != null && !lNotas.isEmpty()) {
			return crearRespuesta(lNotas, HttpStatus.OK);
		}			
		response = crearRespuesta(lNotas, HttpStatus.NO_CONTENT);
		return response;
	}

	@Override
	public ResponseEntity<List<Notas>> getListaConLasNotasDeUnUsuario(String username) {
		List<Notas> lNotas = new ArrayList<>();
		ResponseEntity<List<Notas>> response = null;
		if (username != null && !username.isEmpty()) {
			lNotas = notasService.getNotasByUsername(username);
			if (lNotas != null && !lNotas.isEmpty()) {
				response = crearRespuesta(lNotas, HttpStatus.OK);
			}
			response = crearRespuesta(lNotas, HttpStatus.NO_CONTENT);
		}
		response = crearRespuesta(lNotas, HttpStatus.BAD_REQUEST);
		return response;
	}

	@Override
	public ResponseEntity<Notas> saveNota(@RequestBody Notas nota) {
		Notas newNota = null;
		ResponseEntity<Notas> response = null;
		if(nota != null) {
			newNota = notasService.saveNota(nota);
			response = crearRespuesta(newNota, HttpStatus.OK);
		}
		response = crearRespuesta(newNota, HttpStatus.BAD_REQUEST);
		return response;
	}

	@Override
	public <T> ResponseEntity<T> crearRespuesta(T lista, HttpStatus status) {
		ResponseEntity<T> response = new ResponseEntity<T>(lista, status);
		return response;
	}
}
