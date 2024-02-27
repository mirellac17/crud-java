package clases;

public class Alumno {
	
	private int codigo; 
	private  String nombre; 
	private  int nota1, nota2;

	public Alumno(int codigo, String nombre, int nota1, int nota2) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.nota1 = nota1;
		this.nota2 = nota2;
		
	}
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNota1() {
		return nota1;
	}

	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}

	public int getNota2() {
		return nota2;
	}

	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}
	public double promedio() {
		return (nota1 + nota2) / 2.0;

		// TODO Auto-generated method stub
	//	return 0;
		
		
	}

	

	public String mejorAlumno(Alumno x) {
	if (this.promedio() > x.promedio())
	return this.nombre;
	else
	return x.nombre;
	}
	
	
	
	//protected void actionPerformedBtnProcesar(ActionEvent arg0) {
	//	Alumno a = new Alumno(12345, "Juan", 13, 15);
	//	Alumno b = new Alumno(67890, "Pedro", 12, 13);
	//	String mejor = a.mejorAlumno(b);
	//	imprimir("Mejor alumno : " + mejor);
	
//}
}
