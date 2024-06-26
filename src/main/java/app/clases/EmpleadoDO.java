package app.clases;

import java.sql.Date;

/**
 * La clase EmpleadoDO representa a un empleado en la base de datos.
 */

public class EmpleadoDO {
	private int idempleados;
	private String nombre;
	private String apellido;
	private Date fch_nac;
	private String correo;
	private String telefono;
	private String password;
	private String puesto;

	public EmpleadoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase EmpleadoDO.
	 *
	 * @param idempleados El ID del empleado.
	 * @param nombre El nombre del empleado.
	 * @param apellido El apellido del empleado.
	 * @param fch_nac La fecha de nacimiento del empleado.
	 * @param correo El correo electrónico del empleado.
	 * @param telefono El número de teléfono del empleado.
	 * @param password La contraseña del empleado.
	 * @param puesto El puesto del empleado.
	 */
	
	public EmpleadoDO(int idempleados, String nombre, String apellido, Date fch_nac, String correo, String telefono,
			String password, String puesto) {
		super();
		this.idempleados = idempleados;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fch_nac = fch_nac;
		this.correo = correo;
		this.telefono = telefono;
		this.password = password;
		this.puesto = puesto;
	}

	public int getIdempleados() {
		return idempleados;
	}

	public void setIdempleados(int idempleados) {
		this.idempleados = idempleados;
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

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

}
