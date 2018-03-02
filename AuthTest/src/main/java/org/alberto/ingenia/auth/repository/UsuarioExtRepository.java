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
 * Fecha creación 2 mar. 2018
 * 
 * @autor jamartin
 *
 *
 * ***************************************************************************/
package org.alberto.ingenia.auth.repository;

import java.util.List;

import org.alberto.ingenia.auth.model.UsuarioExt;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jamartin
 *
 */
@Repository
public interface UsuarioExtRepository extends MongoRepository<UsuarioExt, String> {

	public List<UsuarioExt> findAllOrderByUsername();
	
	public UsuarioExt findUsuarioExtByUsername(String username);
	
}
