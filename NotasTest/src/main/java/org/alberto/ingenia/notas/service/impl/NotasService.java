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
package org.alberto.ingenia.notas.service.impl;

import java.util.List;

import org.alberto.ingenia.modelos.Notas;
import org.alberto.ingenia.notas.repository.NotasRepository;
import org.alberto.ingenia.notas.service.INotasService;
import org.springframework.stereotype.Service;

/**
 * @author jamartin
 *
 */
@Service
public class NotasService implements INotasService {
	
	private final NotasRepository notasRepository;
	
	public NotasService(NotasRepository notasRepository) {
		super();
		this.notasRepository = notasRepository;
	}
	
	@Override
	public List<Notas> getListNotas() {
		return notasRepository.findAll();
	}

	@Override
	public List<Notas> getNotasByUsername(String username) {
		return notasRepository.findNotasByUsernameOrderByCabeceraAsc(username);
	}

	@Override
	public Notas saveNota(Notas nota) {
		return notasRepository.save(nota);
	}

}
