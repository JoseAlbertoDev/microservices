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
package org.alberto.ingenia.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.alberto.ingenia.controller.IRestApi;
import org.alberto.ingenia.model.Notas;
import org.alberto.ingenia.service.INotasService;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		lNotas = notasService.getListNotas();
		if (lNotas != null && !lNotas.isEmpty()) {
			return crearRepuesta(lNotas, HttpStatus.OK);
		}			
		return crearRepuesta(lNotas, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<Notas>> getListaConLasNotasDeUnUsuario(String username) {
		List<Notas> lNotas = new ArrayList<>();
		ResponseEntity<List<Notas>> response = new ResponseEntity<List<Notas>>(lNotas, HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}

	@Override
	public ResponseEntity<Notas> saveNota(Notas nota) {
		return null;
	}

	@Override
	public <T> ResponseEntity<List<T>> crearRepuesta(List<T> lista, HttpStatus status) {
		ResponseEntity<List<T>> response = new ResponseEntity<List<T>>(lista, status);
		return response;
	}
}
