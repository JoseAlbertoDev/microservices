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
package org.alberto.ingenia.auth;

import java.util.Collection;

import org.alberto.ingenia.auth.model.Cliente;
import org.alberto.ingenia.auth.model.UsuarioExt;
import org.alberto.ingenia.auth.repository.ClienteRepository;
import org.alberto.ingenia.auth.repository.UsuarioExtRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jamartin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthServerTest {

	@Autowired
	private PasswordEncoder oauth2UserEncoder;
	
	@Autowired
	private PasswordEncoder oauth2ClientEncoder;
	
	@Autowired
	private UsuarioExtRepository usuarioExtRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Test
	public void contextLoads() {
		
		usuarioExtRepository.deleteAll();
		clienteRepository.deleteAll();
		Cliente cliente1 = new Cliente(
				"cliente-acceso-general",
				oauth2ClientEncoder.encode("general"),
				"write,read",
				//Aquí se deben incluir todos los recursos a los que este cliente tiene permiso
				//En caso de no indicar ninguno, entiene que tiene acceso a todos los recursos.
				"auth",
				"password,refresh_token",
				"USER",86400,172800);
		
		Collection<GrantedAuthority> both = AuthorityUtils.createAuthorityList("ROLE_ADMIN","ROLE_USER");
		Collection<GrantedAuthority> user = AuthorityUtils.createAuthorityList("ROLE_USER");
		UsuarioExt usuario = new UsuarioExt("Alberto", oauth2UserEncoder.encode("password"), both);
		UsuarioExt usuario1 = new UsuarioExt("Jose", oauth2UserEncoder.encode("password"), user);
		usuarioExtRepository.insert(usuario);
		usuarioExtRepository.insert(usuario1);
		clienteRepository.insert(cliente1);
	}
}
