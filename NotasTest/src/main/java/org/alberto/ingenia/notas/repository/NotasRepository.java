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
package org.alberto.ingenia.notas.repository;

import java.util.List;

import org.alberto.ingenia.modelos.Notas;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jamartin
 *
 */
@Repository
public interface NotasRepository extends MongoRepository<Notas, String> {
	
	public List<Notas> findNotasByUsernameOrderByCabeceraAsc(String username);

}
