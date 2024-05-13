package app.clases;


//Clase KoalaDO
public class AvestruzDO {
private String nombre;
private int id;

public AvestruzDO() {
	super();
	// TODO Auto-generated constructor stub
}

public AvestruzDO(String nombre, int id) {
	super();
	this.nombre = nombre;
	this.id = id;
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

//Funcion toString para cuando se pida imprimir por pantalla salga los datos de
	// la siguiente manera
	@Override
	public String toString() {
		return nombre;
	}
}




