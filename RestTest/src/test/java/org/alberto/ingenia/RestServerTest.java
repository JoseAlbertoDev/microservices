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
package org.alberto.ingenia;

import org.alberto.ingenia.model.Notas;
import org.alberto.ingenia.service.INotasService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jamartin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestServerTest {
	
	@Autowired
	private INotasService notasService;

	@Test
	public void contextLoad() {
		Notas nota1 = new Notas("Cabecera","Mensaje","Alberto");
		Notas nota2 = new Notas("Cabecera2","Mensaje2","Jose");
	}
	
}
