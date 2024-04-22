package app.clases;

public class ValoracionDO {
	private int idvaloraciones;
	private int puntaje;
	private boolean recomendado;
	private String comentario;
	private String fch_publi;
	private int clientes_idclientes;

	public ValoracionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValoracionDO(int idvaloraciones, int puntaje, boolean recomendado, String comentario, String fch_publi,
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

	public String getFch_publi() {
		return fch_publi;
	}

	public void setFch_publi(String fch_publi) {
		this.fch_publi = fch_publi;
	}

	public int getClientes_idclientes() {
		return clientes_idclientes;
	}

	public void setClientes_idclientes(int clientes_idclientes) {
		this.clientes_idclientes = clientes_idclientes;
	}

}
