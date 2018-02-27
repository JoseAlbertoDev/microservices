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
package org.alberto.ingenia.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author jamartin
 *
 */
@Document(collection = "notas")
public class Notas {
	
	private String id;
	@NotNull
	private String cabecera;
	private String mensaje;
	private String username;
	
	public Notas() {
		super();
	}
	
	public Notas(String cabecera, String mensaje, String username) {
		super();
		this.cabecera = cabecera;
		this.mensaje = mensaje;
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCabecera() {
		return cabecera;
	}

	public void setCabecera(String cabecera) {
		this.cabecera = cabecera;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
