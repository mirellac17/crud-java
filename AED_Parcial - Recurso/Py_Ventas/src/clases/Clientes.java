package clases;

public class Clientes {

	
	private int codigoCliente; 
	private  String nombres, apellidos,dirección; 
	private  String teléfono, dni;
	
	
	
	public Clientes(int codigoCliente, String nombres, String apellidos, String dirección, String teléfono,
			String dni) {
		//super();
		this.codigoCliente = codigoCliente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dirección = dirección;
		this.teléfono = teléfono;
		this.dni = dni;
	}



	public int getCodigoCliente() {
		return codigoCliente;
	}



	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}



	public String getNombres() {
		return nombres;
	}



	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getDirección() {
		return dirección;
	}



	public void setDirección(String dirección) {
		this.dirección = dirección;
	}



	public String getTeléfono() {
		return teléfono;
	}



	public void setTeléfono(String teléfono) {
		this.teléfono = teléfono;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
	
	
}
