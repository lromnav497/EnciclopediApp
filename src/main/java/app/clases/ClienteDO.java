package app.clases;

import java.sql.Date;

public class ClienteDO {
	private int idclientes;
	private String nombre;
	private String apellido;
	private Date fch_nac;
	private String correo;
	private String telefono;
	private String password;
	private boolean afiliado;
	private boolean acept_publi;
	
	public ClienteDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClienteDO(int idclientes, String nombre, String apellido, Date fch_nac, String correo, String telefono,
			String password, boolean afiliado, boolean acept_publi) {
		super();
		this.idclientes = idclientes;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fch_nac = fch_nac;
		this.correo = correo;
		this.telefono = telefono;
		this.password = password;
		this.afiliado = afiliado;
		this.acept_publi = acept_publi;
	}

	public int getIdclientes() {
		return idclientes;
	}

	public void setIdclientes(int idclientes) {
		this.idclientes = idclientes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFch_nac() {
		return fch_nac;
	}

	public void setFch_nac(Date fch_nac) {
		this.fch_nac = fch_nac;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAfiliado() {
		return afiliado;
	}

	public void setAfiliado(boolean afiliado) {
		this.afiliado = afiliado;
	}

	public boolean isAcept_publi() {
		return acept_publi;
	}

	public void setAcept_publi(boolean acept_publi) {
		this.acept_publi = acept_publi;
	}
	
}
