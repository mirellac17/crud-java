package arreglos;

import clases.Reportes;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class AregloReportes {

	// public class ArregloImpresoras {
	// Atributo privado
	private ArrayList<Reportes> report;
	private String archivo;

	// Constructor
	public void ArregloReportes(String archivo) {
			report = new ArrayList<Reportes>();
			this.archivo = archivo;
			cargarReportes();
		}

	// Métodos de acceso: set/get
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getArchivo() {
		return archivo;
	}

	// Constructor
	// public ArregloReportes() {
	// report = new ArrayList<Reportes>();
	// adicionar(new Reportes(3001,1001,2001,01/01/2024,1000,180,1180.0));
	// adicionar(new Reportes(3002,1002,2001,02/01/2024,210,37.8, 247.8));
	// adicionar(new Reportes(3003,1003,2001,03/01/2024,310,55.8, 365.8));
	// adicionar(new Reportes(3004,1004,2001,04/01/2024,140, 25.2,165.2));
	// adicionar(new Reportes(3005,1005,2001,05/01/2024,510,91.8,601.8));
	// adicionar(new Reportes(3006,1006,2001,06/01/2024,106,19.08,125.08));
	// adicionar(new Reportes(3007,1007,2001,07/01/2024,710,127.8,837.8));
	// adicionar(new Reportes(3008,1008,2001,08/01/2024,180,32.4,212.4));
	// adicionar(new Reportes(3009,1009,2001,09/01/2024,910,163.8,1073.8));
	// adicionar(new Reportes(3010,1010,2001,10/01/2024,110,19.8,129.8));
//		}

	// Operaciones públicas básicas
	public void adicionar(Reportes x) {
		report.add(x);
	}

	public Reportes obtener(int i) {
		return report.get(i);
	}

	public int tamaño() {
		return report.size();
	}

	public void eliminar(Reportes x) {
		report.remove(x);
	}

	public void reinicializarArreglo() {
		if (tamaño() > 0)
			report.clear();
	}

	// }

//		public Venta buscar(int codigoVenta) {
//			Venta x;
	// for (int i = 0; i < tamaño(); i++) {
	// x = obtener(i);
	// if (x.getCodigoVenta() == codigoVenta)
	// return x;
	// else
	// if (x.getCodigoCliente() == codigoCliente)
	// return x;
	// else
	/// if (x.getCodigoProducto() == codigoProducto)
	// return x;
	// }
	// return null;

	// }

	public Reportes buscar(int codigo) {
		Reportes x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigoVenta() == codigo)
				return x;
		}
		return null;
	}

	public Reportes buscar(String fecha) {
		Reportes x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);
			if (x.getFecha().equals(fecha))
				return x;
		}
		return null;
	}
	
	public Reportes buscar(double importe_subtotal) {
		Reportes x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);
			if (x.getImporte_subtotal() == importe_subtotal)
				return x;
		}
		return null;
	}
	
//		public Venta buscar(int codigoCliente) {
//			Venta x;
//			for (int i = 0; i < tamaño(); i++) {
//				x = obtener(i);
//				if (x.getCodigoCliente() == codigoCliente)
	//
	//// if (x.getStockMaximo().equals(StockMaximo))
//					return x;
//			}
//			return null;
//		}

//		public Venta buscar(int codigoProducto) {
//			Venta x;
//			for (int i = 0; i < tamaño(); i++) {
//				x = obtener(i);
//				if (x.getCodigoProducto() == codigoProducto)
//					return x;
	// }
	// return null;
	// }

	// Operaciones públicas complementarias
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 50001;
		else
			return obtener(tamaño() - 1).getCodigoVenta() + 1;
	}

	public void grabarReportes() {
		try {
			PrintWriter pw;
			String linea;
			Reportes x;
			pw = new PrintWriter(new FileWriter("archivo"));
			for (int i = 0; i < report.size(); i++) {
				x = report.get(i);
//		for (int i=0; i<tamaño(); i++) {
//		x = obtener(i);
				linea = x.getCodigoVenta() + ";" + x.getCodigoCliente() + ";" + x.getCodigoProducto() + ";"
						+ x.getFecha() + ";" + x.getImporte_subtotal() + ";" + x.getImporte_del_IGV() + ";"
						+ x.getImporte_total();
//		x.getPeso() + ";" +
//		x.getEstatura(); 

				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public void cargarReportes() {
		try {
			BufferedReader br;
			String linea, fecha;
			String s[];
			Double importe_subtotal, importe_del_IGV, importe_total;
			int codigoVenta;
			int codigoCliente;
			int codigoProducto;
			// int cantidad;
//		double peso, estatura;
			br = new BufferedReader(new FileReader("archivo"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoVenta = Integer.parseInt(s[0].trim());
				codigoCliente = Integer.parseInt(s[1].trim());
				codigoProducto = Integer.parseInt(s[2].trim());
				// cantidad = Integer.parseInt(s[3].trim());
				importe_subtotal = Double.parseDouble(s[3].trim());
				importe_del_IGV = Double.parseDouble(s[4].trim());
				importe_total = Double.parseDouble(s[5].trim());
				fecha = (s[6].trim());
//		peso = Double.parseDouble(s[2].trim());
//		estatura = Double.parseDouble(s[3].trim());
				adicionar(new Reportes(codigoVenta, codigoCliente, codigoProducto, fecha, importe_subtotal,
						importe_del_IGV, importe_total));

			}
			br.close();
		} catch (Exception e) {
		}
	}
}
