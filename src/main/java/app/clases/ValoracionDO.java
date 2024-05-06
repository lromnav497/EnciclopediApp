package app.clases;

import java.sql.Date;

/**
 * La clase ValoracionDO representa a una valoración en la base de datos.
 */

public class ValoracionDO {
	private int idvaloraciones;
	private int puntaje;
	private boolean recomendado;
	private String comentario;
	private Date fch_publi;
	private int clientes_idclientes;

	public ValoracionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase ValoracionDO.
	 *
	 * @param idvaloraciones El ID de la valoración.
	 * @param puntaje El puntaje de la valoración.
	 * @param recomendado Si la valoración es recomendada.
	 * @param comentario El comentario de la valoración.
	 * @param fch_publi La fecha de publicación de la valoración.
	 * @param clientes_idclientes El ID del cliente que hizo la valoración.
	 */
	
	public ValoracionDO(int idvaloraciones, int puntaje, boolean recomendado, String comentario, Date fch_publi,
			int clientes_idclientes) {
		super();
		this.idvaloraciones = idvaloraciones;
		this.puntaje = puntaje;
		this.recomendado = recomendado;
		this.comentario = comentario;
		this.fch_publi = fch_publi;
		this.clientes_idclientes = clientes_idclientes;
	}

	public int getIdvaloraciones() {
		return idvaloraciones;
	}

	public void setIdvaloraciones(int idvaloraciones) {
		this.idvaloraciones = idvaloraciones;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public boolean isRecomendado() {
		return recomendado;
	}

	public void setRecomendado(boolean recomendado) {
		this.recomendado = recomendado;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFch_publi() {
		return fch_publi;
	}

	public void setFch_publi(Date fch_publi) {
		this.fch_publi = fch_publi;
	}

	public int getClientes_idclientes() {
		return clientes_idclientes;
	}

	public void setClientes_idclientes(int clientes_idclientes) {
		this.clientes_idclientes = clientes_idclientes;
	}

}
