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
package org.alberto.ingenia.modelos;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author jamartin
 *
 */
@Document(collection = "usuarios")
public class Usuario {

	private String id;
	private String username;
	private String password;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String username, String password) {
		this(username, password, true, true, true, true);
	}
	
	public Usuario(String username, String password, boolean accountNonExpired, 
			boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;		
	}
	
	/**
	 * Método para obtener el valor de la propiedad id
	 * @return El valor de id
	 */
	public String getId() {
		return id;
	}
	/**
	 * Método para asignar el valor de la propiedad id
	 * @param id Valor a asignar a id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Método para obtener el valor de la propiedad username
	 * @return El valor de username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Método para asignar el valor de la propiedad username
	 * @param username Valor a asignar a username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Método para obtener el valor de la propiedad password
	 * @return El valor de password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Método para asignar el valor de la propiedad password
	 * @param password Valor a asignar a password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Método para obtener el valor de la propiedad accountNonExpired
	 * @return El valor de accountNonExpired
	 */
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	/**
	 * Método para asignar el valor de la propiedad accountNonExpired
	 * @param accountNonExpired Valor a asignar a accountNonExpired
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	/**
	 * Método para obtener el valor de la propiedad accountNonLocked
	 * @return El valor de accountNonLocked
	 */
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	/**
	 * Método para asignar el valor de la propiedad accountNonLocked
	 * @param accountNonLocked Valor a asignar a accountNonLocked
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	/**
	 * Método para obtener el valor de la propiedad credentialsNonExpired
	 * @return El valor de credentialsNonExpired
	 */
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	/**
	 * Método para asignar el valor de la propiedad credentialsNonExpired
	 * @param credentialsNonExpired Valor a asignar a credentialsNonExpired
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	/**
	 * Método para obtener el valor de la propiedad enabled
	 * @return El valor de enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}
	/**
	 * Método para asignar el valor de la propiedad enabled
	 * @param enabled Valor a asignar a enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
