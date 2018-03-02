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
package org.alberto.ingenia.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author jamartin
 *
 */
@Configuration
public class Configuraciones {

	@Bean
	public PasswordEncoder oauth2ClientEncoder() {
		return new BCryptPasswordEncoder(4);
	}
	
	@Bean
	public PasswordEncoder oauth2UserEncoder() {
		return new BCryptPasswordEncoder(8);
	}
	
}
