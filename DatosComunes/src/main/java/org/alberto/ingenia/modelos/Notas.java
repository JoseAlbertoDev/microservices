/******************************************************************************
 * 
 *  $Id$
 * 
 * $Date$ 
 * $Revision$
 * $URL$ 
 * $Author$ 
 * 
 * Fecha creación 1 mar. 2018
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
@Document(collection = "notas")
public class Notas {
	
	private String id;
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
	 * Método para obtener el valor de la propiedad cabecera
	 * @return El valor de cabecera
	 */
	public String getCabecera() {
		return cabecera;
	}

	/**
	 * Método para asignar el valor de la propiedad cabecera
	 * @param cabecera Valor a asignar a cabecera
	 */
	public void setCabecera(String cabecera) {
		this.cabecera = cabecera;
	}

	/**
	 * Método para obtener el valor de la propiedad mensaje
	 * @return El valor de mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Método para asignar el valor de la propiedad mensaje
	 * @param mensaje Valor a asignar a mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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
	
}
