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
package org.alberto.ingenia.notas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author jamartin
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories
public class NotasServer {
	
	public static void main(String[] args) {
		SpringApplication.run(NotasServer.class, args);
	}
	
}
