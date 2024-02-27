package arreglos;
import clases.Alumno;
import java.util.ArrayList;


public class ArregloAlumnos {
	
	

	// Atributo privado
	private ArrayList <Alumno> alu;
	// Constructor
	public ArregloAlumnos() {
	alu = new ArrayList <Alumno> ();
	alu.add(new Alumno(123, "Ana", 19, 17));
	alu.add(new Alumno(456, "Juan", 15, 14));
	alu.add(new Alumno(789, "Pedro", 19, 15));
	alu.add(new Alumno(302, "David", 13, 18));
	}
	// Operaciones públicas básicas
	public int tamaño() {
	return alu.size();
	}
	public Alumno obtener(int i) {
	return alu.get(i);
	}
	// Operaciones públicas complementarias
	public double promedioGeneral() {
	double suma = 0.0;
	for (int i=0; i<tamaño(); i++)
	suma += obtener(i).promedio();
	return suma / tamaño();
	}
	
/*	public int sumaNumeros() {
		int suma = 0;
		for (int i=0; i<tamaño(); i++)
		suma += n[i];
		return suma;
		}
		public int posPrimerNumeroMenorA25() {
		for (int i=0; i<tamaño(); i++)
		if (n[i] < 25)
		return i;
		return -1;
		}
		public void generar() {
			for (int i=0; i<tamaño(); i++)
			n[i] = aleatorio(100, 999);
			}
	*/		// Método privado
			private int aleatorio(int min, int max) {
			return (int)((max - min + 1) * Math.random()) + min;
			}
	
	
	}

	


