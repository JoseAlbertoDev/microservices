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
package org.alberto.ingenia;

import java.util.List;

import static org.junit.Assert.*;

import org.alberto.ingenia.modelos.Notas;
import org.alberto.ingenia.notas.NotasServer;
import org.alberto.ingenia.notas.service.INotasService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jamartin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = NotasServer.class)
public class NotasServerTest {
	
	@Autowired
	private INotasService notasService;

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	public void contextLoad() {
		mongoTemplate.dropCollection(Notas.class);
		Notas nota1 = new Notas("Cabecera","Mensaje","Alberto");
		Notas nota2 = new Notas("Cabecera2","Mensaje2","Jose");
		notasService.saveNota(nota1);
		notasService.saveNota(nota2);
		List<Notas> lN1 = notasService.getListNotas();
		assertTrue(lN1.size() == 2);
		List<Notas> lN2 = notasService.getNotasByUsername("Alberto");
		assertTrue(lN2.get(0).getUsername().equals("Alberto"));
	}
	
}
