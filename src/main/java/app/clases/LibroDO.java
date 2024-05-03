package app.clases;

import java.sql.Date;

public class LibroDO {
	private int idlibros;
	private String nombre;
	private String categoria;
	private String autor;
	private String editorial;
	private Date fch_publi;
	private String imagen;

	public LibroDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LibroDO(int idlibros, String nombre, String categoria, String autor, String editorial, Date fch_publi,
			String imagen) {

		super();
		this.idlibros = idlibros;
		this.nombre = nombre;
		this.categoria = categoria;
		this.autor = autor;
		this.editorial = editorial;
		this.fch_publi = fch_publi;
		this.imagen = imagen;
	}

	public int getIdlibros() {
		return idlibros;
	}

	public void setIdlibros(int idlibros) {
		this.idlibros = idlibros;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Date getFch_publi() {
		return fch_publi;
	}

	public void setFch_publi(Date fch_publi) {
		this.fch_publi = fch_publi;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
