package app.clases;

//Clase KoalaDO
public class KoalaDO {
 private String nombre;
 private int id;
 private int id_Avestruz;
 
public KoalaDO() {
	super();
	// TODO Auto-generated constructor stub
}

public KoalaDO(String nombre, int id, int id_Avestruz) {
	super();
	this.nombre = nombre;
	this.id = id;
	this.id_Avestruz = id_Avestruz;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getIdAvestruz() {
	return id_Avestruz;
}

public void setid_Avestruz(int id_Avestruz) {
	this.id_Avestruz = id_Avestruz;
}

//Funcion toString para cuando se pida imprimir por pantalla salga los datos de
	// la siguiente manera
	@Override
	public String toString() {
		return nombre;
	}
	
}




