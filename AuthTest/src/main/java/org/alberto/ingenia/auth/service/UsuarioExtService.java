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
package org.alberto.ingenia.auth.service;

import org.alberto.ingenia.auth.model.UsuarioExt;
import org.alberto.ingenia.auth.repository.UsuarioExtRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author jamartin
 *
 */
@Service
public class UsuarioExtService implements UserDetailsService {
	
	private final UsuarioExtRepository usuarioRepository;
	
	public UsuarioExtService(UsuarioExtRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioExt usuario = usuarioRepository.findUsuarioExtByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return usuario;
	}

}
