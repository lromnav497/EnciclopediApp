package app.clases;

import java.sql.Date;

public class PedidoDO {
	private int idpedidos;
	private String contenido;
	private Date fch_compra;
	private double total_precio;

	public PedidoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PedidoDO(int idpedidos, String contenido, Date fch_compra, double total_precio) {
		super();
		this.idpedidos = idpedidos;
		this.contenido = contenido;
		this.fch_compra = fch_compra;
		this.total_precio = total_precio;
	}

	public int getIdpedidos() {
		return idpedidos;
	}

	public void setIdpedidos(int idpedidos) {
		this.idpedidos = idpedidos;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFch_compra() {
		return fch_compra;
	}

	public void setFch_compra(Date fch_compra) {
		this.fch_compra = fch_compra;
	}

	public double getTotal_precio() {
		return total_precio;
	}

	public void setTotal_precio(double total_precio) {
		this.total_precio = total_precio;
	}

}
