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
 * Fecha creación 1 mar. 2018
 * 
 * @autor jamartin
 *
 *
 * ***************************************************************************/
package org.alberto.ingenia.tablon.controller;

import java.util.List;

import org.alberto.ingenia.modelos.Notas;
import org.alberto.ingenia.tablon.feign.FeignNotas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jamartin
 *
 */
@RestController
public class TablonController {
	
	@Autowired
	private FeignNotas feignNotas;
	
	@RequestMapping(
			value = {"/getTodasLasNotas"},
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			method = RequestMethod.GET)
	public List<Notas> getNotas(){
		return feignNotas.getNotas();
	}
}
