package arreglos;


import clases.Producto;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ArregloProductos {

	// public class ArregloImpresoras {
	// Atributo privado
	private ArrayList<Producto> prod;
	private String archivo;

	// Constructor
	public ArregloProductos(String archivo) {
		prod = new ArrayList<Producto>();
		this.archivo = archivo;
		cargarProductos();
	}

	// Métodos de acceso: set/get
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getArchivo() {
		return archivo;
	}

	// Constructor
	// public ArregloProductos() {
	// prod = new ArrayList<Producto>();
	// adicionar(new Producto(2001, "Epson", 1350.0, 900, 100, 1000));
	// adicionar(new Producto(2002, "HP", 2300.0, 800, 200, 1000));
	// adicionar(new Producto(2003, "Samsung", 2100.0, 700, 300, 1000));
	// adicionar(new Producto(2004, "Sony", 1900.0, 600, 400, 1000));
	// adicionar(new Producto(2005, "LG", 1050.0, 500, 500, 1000));
	// adicionar(new Producto(2006, "Samsung", 4210.0, 400, 600, 1000));
	// adicionar(new Producto(2007, "Epson", 2090.0, 300, 700, 1000));
	// adicionar(new Producto(2008, "LG", 3520.0, 4000, 4000, 8000));
	// adicionar(new Producto(2009, "Canon", 3500.0, 100, 900, 1000));
	// adicionar(new Producto(2010, "Logitech", 2200.0, 500, 500, 1000));
//	}

	// Operaciones públicas básicas
	public void adicionar(Producto x) {
		prod.add(x);
	}

	public Producto obtener(int i) {
		return prod.get(i);
	}

	public int tamaño() {
		return prod.size();
	}

	public void eliminar(Producto x) {
		prod.remove(x);
	}

	public void reinicializarArreglo() {
		if (tamaño() > 0)
			prod.clear();
	}

	// }

	public Producto buscar(int codigo) {
		Producto x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigoProducto() == codigo)
				return x;
		}
		return null;
	}

	public Producto buscar(String nombre) {
		Producto x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);
			if (x.getNombre().equals(nombre))

				//// if (x.getStockMaximo().equals(StockMaximo))
				return x;
		}
		return null;
	}

	public Producto buscar(double precio) {
		Producto x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);
			if (x.getPrecio() == precio)
				return x;
		}
		return null;
	}

// Operaciones públicas complementarias
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 2001;
		else
			return obtener(tamaño() - 1).getCodigoProducto() + 1;
	}

	public void grabarProductos() {
		try {
			PrintWriter pw;
			String linea;
			Producto x;
			pw = new PrintWriter(new FileWriter("archivo"));
			for (int i = 0; i < prod.size(); i++) {
				x = prod.get(i);
//	for (int i=0; i<tamaño(); i++) {
//	x = obtener(i);
				linea = x.getCodigoProducto() + ";" + x.getPrecio() + ";" + x.getStockActual() + ";"
						+ x.getStockMinimo() + ";" + x.getStockMaximo();
//	x.getPeso() + ";" +
//	x.getEstatura(); 
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public void cargarProductos() {
		try {
			BufferedReader br;
			String linea, nombre;
			String s[];
			Double Precio;
			int stockActual;
			int stockMinimo;
			int stockMaximo;
			int codigoProducto;
//	double peso, estatura;
			br = new BufferedReader(new FileReader("archivo"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoProducto = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				Precio = Double.parseDouble(s[2].trim());
				stockMinimo = Integer.parseInt(s[3].trim());
				stockActual = Integer.parseInt(s[4].trim());
				stockMaximo = Integer.parseInt(s[5].trim());
//	peso = Double.parseDouble(s[2].trim());
//	estatura = Double.parseDouble(s[3].trim());
				adicionar(new Producto(codigoProducto, nombre, Precio, stockActual, stockMinimo, stockMaximo));

			}
			br.close();
		} catch (Exception e) {
		}
	}
}
