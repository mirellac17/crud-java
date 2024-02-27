package gui;

import clases.Venta;

import arreglos.ArregloVentas;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
//import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
//import javax.swing.border.MatteBorder;
//import java.awt.Color;

public class Ventas extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblcodigoVenta;
	private JLabel lblcodigoCliente;
	private JLabel lblcodigoProducto;
	private JLabel lblprecio;
	private JLabel lblcantidad;
	private JLabel lblfecha;
	private JLabel lblCorreo;
	private JLabel lblEstadoCivil;
	private JTextField txtcodigoVenta;
	private JTextField txtcodigoCliente;
	private JTextField txtcodigoProducto;
	private JTextField txtprecio;
	private JTextField txtcantidad;
	private JTextField txtfecha;
	private JTextField txtCorreo;
	private JComboBox<String> cboEstadoCivil;
	private JScrollPane scrollPane;
	private JButton btnBuscar;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JTable tblVentas;
	private DefaultTableModel modelo;

	// Tipo de operación a procesar:Adicionar,Consultar,Modificar o Eliminar
		private int tipoOperacion;
		// Constantes para los tipos de operaciones
		public final static int ADICIONAR = 0;
		public final static int CONSULTAR = 1;
		public final static int MODIFICAR = 2;
		public final static int ELIMINAR = 3;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas frame = new Ventas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventas() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		// setBounds(100, 100, 450, 300);

		setResizable(true);
		setTitle("Ventas | Boleta de Pago");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);

		lblcodigoVenta = new JLabel("Código de Venta");
		lblcodigoVenta.setBounds(10, 10, 110, 23);
		getContentPane().add(lblcodigoVenta);

		lblcodigoCliente = new JLabel("Código de Cliente");
		lblcodigoCliente.setBounds(10, 35, 120, 23);
		getContentPane().add(lblcodigoCliente);

		lblcantidad = new JLabel("Cantidad");
		lblcantidad.setBounds(10, 60, 70, 23);
		getContentPane().add(lblcantidad);

		lblfecha = new JLabel("Fecha");
		lblfecha.setBounds(10, 85, 70, 23);
		getContentPane().add(lblfecha);

		lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(10, 110, 70, 23);
		getContentPane().add(lblCorreo);

		lblEstadoCivil = new JLabel("Estado civil");
		lblEstadoCivil.setBounds(10, 135, 86, 23);
		getContentPane().add(lblEstadoCivil);

		txtcodigoVenta = new JTextField();
		txtcodigoVenta.setBounds(131, 10, 86, 23);
		getContentPane().add(txtcodigoVenta);
		txtcodigoVenta.setColumns(10);

		txtcodigoCliente = new JTextField();
		txtcodigoCliente.setBounds(130, 35, 236, 23);
		getContentPane().add(txtcodigoCliente);
		txtcodigoCliente.setColumns(10);

		txtcantidad = new JTextField();
		txtcantidad.setBounds(131, 60, 86, 23);
		getContentPane().add(txtcantidad);
		txtcantidad.setColumns(10);

		txtfecha = new JTextField();
		txtfecha.setBounds(131, 85, 86, 23);
		getContentPane().add(txtfecha);
		txtfecha.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(131, 110, 86, 23);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);

		cboEstadoCivil = new JComboBox<String>();
		cboEstadoCivil.setEditable(true);
		cboEstadoCivil.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Soltero", "Casado", "Viudo", "Divorciado" }));
		cboEstadoCivil.setBounds(131, 135, 86, 23);
		getContentPane().add(cboEstadoCivil);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 775, 360);
		getContentPane().add(scrollPane);

		tblVentas = new JTable();
		tblVentas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblVentas);

		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO DEL CLIENTE");
		modelo.addColumn("NOMBRES Y APELLIDOS DEL CLIENTE");
		modelo.addColumn("CODIGO DEL PRODUCTO");
		modelo.addColumn("NOMBRE DEL PRODUCTO");
		modelo.addColumn("CANTIDAD DE UNIDADES ADQUIRIDAS");
		modelo.addColumn("PRECIO UNITARIO");
		modelo.addColumn("IMPORTE SUBTOTAL (S/)");
		modelo.addColumn("IMPORTE DEL IGV (S/)");
		modelo.addColumn("IMPORTE TOTAL A PAGAR (S/)");
		// modelo.addColumn("IMC = peso/estatura²");
		
		tblVentas.setModel( modelo);
		//tblVentas.setModel(new DefaultTableModel(
		//	new Object[][] {
		//	},
		//	new String[] {
		//	}
	//	));
		// new Object[][] {
		// },
		// new String[] {
		// }
		// );

//		btnBuscar = new JButton("Buscar");
		// btnBuscar.addActionListener(this);
		// btnBuscar.setEnabled(false);
//		btnBuscar.setBounds(240, 10, 101, 23);
//		getContentPane().add(btnBuscar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				buscarVentas();
			}
			// {
			// public void actionPerformed(ActionEvent e) {
			// Clientes buscar(String dni);
			// Clientes buscar(int codigo);
			// consultarClientes();

		});
		btnBuscar.setIcon(new ImageIcon(Ventas.class.getResource("/imagenes/Img/loupe16.png")));
		btnBuscar.setBounds(265, 10, 101, 23);
		getContentPane().add(btnBuscar);

		btnAdicionar = new JButton("Ingreso");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarVentas();
			}
		});
		btnAdicionar.setIcon(new ImageIcon(Ventas.class.getResource("/imagenes/Img/add-event16.png")));
		// btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 540, 120, 23);
		getContentPane().add(btnAdicionar);

		btnConsultar = new JButton("Consultar x Venta");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarVentas();
			}
		});
		btnConsultar.setIcon(new ImageIcon(Ventas.class.getResource("/imagenes/Img/file16.png")));
		// btnConsultar.addActionListener(this);
		btnConsultar.setBounds(135, 540, 120, 23);
		getContentPane().add(btnConsultar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarVentas();

			}
		});
		btnModificar.setIcon(new ImageIcon(Ventas.class.getResource("/imagenes/Img/edit16.png")));
		// btnModificar.addActionListener(this);
		btnModificar.setBounds(260, 540, 120, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				eliminarVentas();

			}

		});
		btnEliminar.setIcon(new ImageIcon(Ventas.class.getResource("/imagenes/Img/multiply.png")));
		// btnEliminar.addActionListener(this);
		btnEliminar.setBounds(385, 540, 120, 23);
		getContentPane().add(btnEliminar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnAceptar.setIcon(new ImageIcon(Ventas.class.getResource("/imagenes/Img/save16.png")));
		btnAceptar.setBounds(510, 540, 120, 23);
		getContentPane().add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVolver.setIcon(new ImageIcon(Ventas.class.getResource("/imagenes/Img/delete16.png")));
		btnVolver.setBounds(664, 540, 120, 23);
		getContentPane().add(btnVolver);

		lblcodigoProducto = new JLabel("Código de Producto");
		lblcodigoProducto.setBounds(385, 35, 120, 23);
		getContentPane().add(lblcodigoProducto);

		txtcodigoProducto = new JTextField();
		txtcodigoProducto.setColumns(10);
		txtcodigoProducto.setBounds(510, 35, 251, 23);
		getContentPane().add(txtcodigoProducto);

		lblprecio = new JLabel("Precio");
		lblprecio.setBounds(385, 69, 70, 23);
		getContentPane().add(lblprecio);

		txtprecio = new JTextField();
		txtprecio.setColumns(10);
		txtprecio.setBounds(510, 69, 251, 23);
		getContentPane().add(txtprecio);

		ajustarAnchoColumnas();
		listar();
	}

	// Declaración global
	ArregloVentas ap = new ArregloVentas("archivo");

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion = ADICIONAR;

		txtcodigoVenta.setText("" + ap.codigoCorrelativo());
		txtcodigoCliente.setText("");
		txtcodigoProducto.setText("");

		txtcantidad.setText("");
		txtprecio.setText("");
		txtfecha.setText("");
		txtCorreo.setText("");
		habilitarEntradas(true);
		habilitarBotones(false);
		txtcodigoCliente.requestFocus();
	}

	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		tipoOperacion = CONSULTAR;
		txtcodigoVenta.setEditable(true);
		habilitarBotones(false);
		txtcodigoVenta.requestFocus();
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipoOperacion = MODIFICAR;
		txtcodigoVenta.setEditable(true);
		habilitarEntradas(true);
		habilitarBotones(false);
		txtcodigoVenta.requestFocus();
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipoOperacion = ELIMINAR;
		txtcodigoVenta.setEditable(true);
		habilitarBotones(false);
	}

	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
		case ADICIONAR:
			adicionarVentas();
			break;
		case CONSULTAR:
			consultarVentas();
			break;
		case MODIFICAR:
			modificarVentas();
			break;
		case ELIMINAR:
			eliminarVentas();
		}
	}

	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		consultarVentas();
	}

	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		txtcodigoVenta.setText("");
		txtcodigoCliente.setText("");
		txtcodigoProducto.setText("");
		txtcantidad.setText("");
		txtprecio.setText("");

		txtfecha.setText("");
		txtCorreo.setText("");
		txtcodigoVenta.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
	}

	// Métodos tipo void (sin parámetros)
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblVentas.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10)); // código del cliente
		tcm.getColumn(1).setPreferredWidth(anchoColumna(20)); // nombres y apellidos del cliiente
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20)); // código del producto
		tcm.getColumn(3).setPreferredWidth(anchoColumna(20)); // Nombre del producto
		tcm.getColumn(4).setPreferredWidth(anchoColumna(20)); // Cantidad de unidades adquiridas
		tcm.getColumn(5).setPreferredWidth(anchoColumna(20)); // Precio Unitario
		tcm.getColumn(6).setPreferredWidth(anchoColumna(20)); // Importe subtotal
		tcm.getColumn(7).setPreferredWidth(anchoColumna(20)); // Importe del IGV
		tcm.getColumn(8).setPreferredWidth(anchoColumna(20)); // Importe total a pagar
	}

	void listar() {
		Venta x;
		modelo.setRowCount(0);
		for (int i = 0; i < ap.tamaño(); i++) {
			x = ap.obtener(i);
			Object[] fila = { x.getCodigoVenta(), x.getCodigoCliente(),
					// x.getDni(),
					x.getCodigoProducto(), // + ";" +

					x.getCantidad(), // + ";" +
					x.getPrecio(), // + ";" +
					x.getFecha()// + ";"
					// x.getPeso(),
					// x.getEstatura(),
					// enTextoEstadoCivil(x.getEstado()),
					// x.imc()
			};
			modelo.addRow(fila);
		}
	}

	void buscarVentas() {
		try {
			Venta x = ap.buscar(leerCodigo());
			if (x != null) {
				txtcodigoVenta.setText("" + x.getCodigoVenta());
				txtcodigoCliente.setText("" + x.getCodigoCliente());
				txtcodigoProducto.setText("" + x.getCodigoProducto());

				txtcantidad.setText("" + x.getCantidad());
				txtprecio.setText("" + x.getPrecio());
				txtfecha.setText("" + x.getFecha());
				// txtPeso.setText("" + x.getPeso());
				// txtEstatura.setText("" + x.getEstatura());
				// cboEstadoCivil.setSelectedIndex(x.getEstado());
				txtcodigoVenta.requestFocus();
			} else
				error("El código " + leerCodigo() + " no existe", txtcodigoVenta);
		} catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtcodigoVenta);
		}
	}

	void consultarVentas() {
		try {
			Venta x = ap.buscar(leerVentas());
			if (x != null) {
				txtcodigoVenta.setText("" + x.getCodigoVenta());
				txtcodigoCliente.setText("" + x.getCodigoCliente());
				txtcodigoProducto.setText("" + x.getCodigoProducto());
				txtcantidad.setText("" + x.getCantidad());
				txtprecio.setText("" + x.getPrecio());
				txtfecha.setText("" + x.getFecha());
				txtcodigoVenta.requestFocus();
			} else
				error("Los PRODUCTOS " + leerVentas() + " no existe", txtcodigoCliente);
		} catch (Exception e) {
			error("Ingrese PRODUCTO correcto", txtcodigoProducto);
		}
	}

	void adicionarVentas() {
		int codigoVenta = leerCodigoVenta();
	//	int codigoCliente = leerCodigoCliente();
	//	int codigoProducto = leerCodigoProducto();
	//	int cantidad = leerCantidad();
		String fecha = leerFecha();
		if (fecha.length() > 0) {
	//	if (codigoProducto.length() > 0) {
			int codigoCliente = leerCodigoCliente();
			int codigoProducto = leerCodigoProducto();

			// int stockActual = leerStockActual();
			int cantidad = leerCantidad();
			// String dni = leerDni();
			if (ap.buscar(cantidad) == null)
				try {
					double precio = leerPrecio();
					// int stockMinimo = leerStockMinimo();
					// String dirección = leerDirección();
					// double peso = leerPeso();
					try {
					//	String fecha = leerFecha();
						// int stockMaximo = leerStockMaximo();
						/// int stockActual = leerStockActual();
						// String teléfono = leerTelefono();
						// String dni = leerDni();
						// double estatura = leerEstatura();
						// int estado = leerPosEstado();

						Venta nueva = new Venta(codigoVenta, codigoCliente, codigoProducto, cantidad, precio, fecha);

						// (int codigoProducto, String nombre, double precio, int stockActual, int
						// stockMinimo,
						// int stockMaximo)
						// Clientes nueva = new Clientes(codigo, nombres, dni);
						// dni, peso,
						// estatura, estado);
						ap.adicionar(nueva);
						listar();
						txtcodigoVenta.setText("" + ap.codigoCorrelativo());
						txtcodigoVenta.setText("");
						txtcodigoCliente.setText("");
						txtcodigoProducto.setText("");

						txtcantidad.setText("");
						txtprecio.setText("");
						// txtTelefono.setText("");
						// txtStockActual.setText("");
						txtfecha.setText("");
						// txtCorreo.setText("");
						txtcodigoCliente.requestFocus();
					} catch (Exception e) {
						error("Ingrese CORREO correctO", txtCorreo);
					}
				} catch (Exception e) {
					error("Ingrese STOCK MAXIMO correcto", txtfecha);
				}
			else
				error("Ingrese STOCK ACTUAL correcto", txtcantidad);
		} else
			error("Ingrese todos los datos", txtcodigoCliente);
	}

	void eliminarVentas() {
		try {
			int codigo = leerCodigo();
			Venta x = ap.buscar(codigo);
			if (x != null) {
				ap.eliminar(x);
				listar();
				txtcodigoVenta.setText("");
				txtcodigoCliente.setText("");
				txtcodigoProducto.setText("");
				txtcantidad.setText("");
				txtprecio.setText("");
				txtfecha.setText("");
				// txtCorreo.setText("");
				txtcodigoVenta.requestFocus();
			} else
				error("El código " + codigo + " no existe", txtcodigoVenta);
		} catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtcodigoVenta);
		}
	}

	void modificarVentas() {
		try {
			Venta x = ap.buscar(leerCodigo());
			String Venta = leerVentas();
			if (Venta.length() > 0) {
				int codigoVenta = leerCodigoVenta();
				int codigoCliente = leerCodigoCliente();
				// int StockActual = leerStockActual();
				// int stockMaximo = leerStockMaximo();
				 String fecha = leerFecha();
				Venta y = ap.buscar(leerCodigoCliente());
				if (y == null || x.equals(y))
					try {
						// double Precio = leerPrecio();
						// double peso = leerPeso();
						int codigoProducto = leerCodigoProducto();
						int cantidad = leerCantidad();

						 double precio = leerPrecio();
						// String Dirección = leerDirección();
						try {
							//String Fecha = leerFecha();
							x.setCodigoVenta(codigoVenta);
							x.setCodigoCliente(codigoCliente);
							x.setCodigoProducto(codigoProducto);
							x.setCantidad(cantidad);
							x.setPrecio(precio);
							x.setFecha(fecha);
							// x.setPeso(peso);
							// x.setEstatura(estatura);
							// x.setEstado(estado);
							listar();
							txtcodigoVenta.requestFocus();
						} catch (Exception e) {
							error("Ingrese STOCK ACTUAL correcta", txtcantidad);
						}
					} catch (Exception e) {
						error("Ingrese STOCK MINIMO correcto", txtprecio);
					}
				else
					error("Ingrese PRECIO correcto", txtcodigoProducto);
			} else
				error("Ingrese PRODUCTO correcto", txtcodigoCliente);
		} catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtcodigoVenta);
		}
	}

	// Métodos tipo void (con parámetros)
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}

	void habilitarBotones(boolean sino) {
		if (tipoOperacion != ADICIONAR)
			btnBuscar.setEnabled(!sino);
		btnAdicionar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		if (tipoOperacion == CONSULTAR)
			btnAceptar.setEnabled(false);
		else
			btnAceptar.setEnabled(!sino);
		btnVolver.setEnabled(!sino);
	}

	void habilitarEntradas(boolean sino) {
		txtcodigoCliente.setEditable(sino);
		txtcodigoProducto.setEditable(sino);
		txtprecio.setEditable(sino);

		txtcantidad.setEditable(sino);
		txtfecha.setEditable(sino);
		txtCorreo.setEditable(sino);
		cboEstadoCivil.setEnabled(sino);
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	// Métodos que retornan valor (sin parámetros)

	int leerCodigo() {
		return Integer.parseInt(txtcodigoVenta.getText().trim());
	}

	String leerVentas() {
		return txtcodigoCliente.getText().trim();
	}

	int leerCodigoVenta() {
		// return txtPrecio.getText().trim();
		return Integer.parseInt(txtcodigoVenta.getText().trim());
	}

	int leerCodigoCliente() {
		// return txtPrecio.getText().trim();
		return Integer.parseInt(txtcodigoCliente.getText().trim());
	}

	int leerCodigoProducto() {
		// return txtPrecio.getText().trim();
		return Integer.parseInt(txtcodigoProducto.getText().trim());
	}

	int leerCantidad() {
		return Integer.parseInt(txtcantidad.getText().trim());
	}

	double leerPrecio() {
		return Double.parseDouble(txtprecio.getText().trim());
	}

	String leerFecha() {
		return txtfecha.getSelectedText();
	}
	// double leerPeso() {
	// return Double.parseDouble(txtDni.getText().trim());
	// }
	// double leerEstatura() {
	// return Double.parseDouble(txtCorreo.getText().trim());
	// }
	// int leerPosEstado() {
	// return cboEstadoCivil.getSelectedIndex();
	// }

	// Métodos que retornan valor (con parámetros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	String enTextoEstadoCivil(int i) {
		return cboEstadoCivil.getItemAt(i);
	}

}
