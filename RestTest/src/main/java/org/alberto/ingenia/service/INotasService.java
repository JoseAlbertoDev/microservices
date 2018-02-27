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
package org.alberto.ingenia.service;

import java.util.List;

import org.alberto.ingenia.model.Notas;

/**
 * @author jamartin
 *
 */
public interface INotasService {
	
	public List<Notas> getListNotas();
	
	public List<Notas> getNotasByUsername(String username);
	
}
