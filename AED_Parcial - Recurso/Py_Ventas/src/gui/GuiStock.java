package gui;

import clases.Stock;
import arreglos.ArregloStock;

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

public class GuiStock extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblCodigo;
	private JLabel lblProductos;
	private JLabel lblPrecio;
	private JLabel lblStockMinimo;
	private JLabel lblStockActual;
	private JLabel lblStockMaximo;
	private JLabel lblCorreo;
	private JLabel lblEstadoCivil;
	private JTextField txtCodigo;
	private JTextField txtProductos;
	private JTextField txtPrecio;
	private JTextField txtStockMinimo;
	private JTextField txtStockActual;
	private JTextField txtStockMaximo;
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
	private JTable tblStock;
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
					GuiStock frame = new GuiStock();
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
	
	public GuiStock() {
		//setBounds(100, 100, 450, 300);
		
			setMaximizable(true);
			setIconifiable(true);
			setClosable(true);
			// setBounds(100, 100, 450, 300);

			setResizable(true);
			setTitle("Almacén | Stock de Productos");
			setBounds(100, 100, 800, 600);
			getContentPane().setLayout(null);

			lblCodigo = new JLabel("C\u00F3digo");
			lblCodigo.setBounds(10, 10, 110, 23);
			getContentPane().add(lblCodigo);

			lblProductos = new JLabel("Producto");
			lblProductos.setBounds(10, 35, 70, 23);
			getContentPane().add(lblProductos);

			lblStockActual = new JLabel("Stock Actual");
			lblStockActual.setBounds(10, 60, 70, 23);
			getContentPane().add(lblStockActual);

			lblStockMaximo = new JLabel("Stock Máximo");
			lblStockMaximo.setBounds(10, 85, 70, 23);
			getContentPane().add(lblStockMaximo);

			lblCorreo = new JLabel("Correo");
			lblCorreo.setBounds(10, 110, 70, 23);
			getContentPane().add(lblCorreo);

			lblEstadoCivil = new JLabel("Estado civil");
			lblEstadoCivil.setBounds(10, 135, 86, 23);
			getContentPane().add(lblEstadoCivil);

			txtCodigo = new JTextField();
			txtCodigo.setBounds(90, 10, 86, 23);
			getContentPane().add(txtCodigo);
			txtCodigo.setColumns(10);

			txtProductos = new JTextField();
			txtProductos.setBounds(90, 35, 251, 23);
			getContentPane().add(txtProductos);
			txtProductos.setColumns(10);

			txtStockActual = new JTextField();
			txtStockActual.setBounds(90, 60, 86, 23);
			getContentPane().add(txtStockActual);
			txtStockActual.setColumns(10);

			txtStockMaximo = new JTextField();
			txtStockMaximo.setBounds(90, 85, 86, 23);
			getContentPane().add(txtStockMaximo);
			txtStockMaximo.setColumns(10);

			txtCorreo = new JTextField();
			txtCorreo.setBounds(90, 110, 86, 23);
			getContentPane().add(txtCorreo);
			txtCorreo.setColumns(10);

			cboEstadoCivil = new JComboBox<String>();
			cboEstadoCivil.setEditable(true);
			cboEstadoCivil.setModel(
					new DefaultComboBoxModel<String>(new String[] { "Soltero", "Casado", "Viudo", "Divorciado" }));
			cboEstadoCivil.setBounds(90, 135, 86, 23);
			getContentPane().add(cboEstadoCivil);

			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 170, 775, 360);
			getContentPane().add(scrollPane);

			tblStock = new JTable();
			tblStock.setFillsViewportHeight(true);
			scrollPane.setViewportView(tblStock);

			modelo = new DefaultTableModel();
			modelo.addColumn("CÓDIGO");
			modelo.addColumn("PRODUCTO");
			modelo.addColumn("PRECIO");
			modelo.addColumn("STOCK ACTUAL");
			modelo.addColumn("STOCK MINIMO");
			modelo.addColumn("STOCK MAXIMO");
			// modelo.addColumn("PESO (kg)");
			// modelo.addColumn("ESTATURA (mts)");
			// modelo.addColumn("ESTADO CIVIL");
			// modelo.addColumn("IMC = peso/estatura²");
			tblStock.setModel(modelo);
			// new Object[][] {
			// },
			// new String[] {
			// }
			// );

//			btnBuscar = new JButton("Buscar");
			// btnBuscar.addActionListener(this);
			// btnBuscar.setEnabled(false);
//			btnBuscar.setBounds(240, 10, 101, 23);
//			getContentPane().add(btnBuscar);

			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					buscarStock();
				}
				// {
				// public void actionPerformed(ActionEvent e) {
				// Clientes buscar(String dni);
				// Clientes buscar(int codigo);
				// consultarClientes();

			});
			btnBuscar.setIcon(new ImageIcon(GuiStock.class.getResource("/imagenes/Img/loupe16.png")));
			btnBuscar.setBounds(240, 10, 101, 23);
			getContentPane().add(btnBuscar);

			btnAdicionar = new JButton("Ingreso");
			btnAdicionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					adicionarStock();
				}
			});
			btnAdicionar.setIcon(new ImageIcon(GuiStock.class.getResource("/imagenes/Img/add-event16.png")));
			// btnAdicionar.addActionListener(this);
			btnAdicionar.setBounds(10, 540, 120, 23);
			getContentPane().add(btnAdicionar);

			btnConsultar = new JButton("Consultar x Producto");
			btnConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					consultarStock();
				}
			});
			btnConsultar.setIcon(new ImageIcon(GuiStock.class.getResource("/imagenes/Img/file16.png")));
			// btnConsultar.addActionListener(this);
			btnConsultar.setBounds(135, 540, 120, 23);
			getContentPane().add(btnConsultar);

			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modificarStock();

				}
			});
			btnModificar.setIcon(new ImageIcon(GuiStock.class.getResource("/imagenes/Img/edit16.png")));
			// btnModificar.addActionListener(this);
			btnModificar.setBounds(260, 540, 120, 23);
			getContentPane().add(btnModificar);

			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					eliminarStock();

				}

			});
			btnEliminar.setIcon(new ImageIcon(GuiStock.class.getResource("/imagenes/Img/multiply.png")));
			// btnEliminar.addActionListener(this);
			btnEliminar.setBounds(385, 540, 120, 23);
			getContentPane().add(btnEliminar);

			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			btnAceptar.setIcon(new ImageIcon(GuiStock.class.getResource("/imagenes/Img/save16.png")));
			btnAceptar.setBounds(510, 540, 120, 23);
			getContentPane().add(btnAceptar);

			btnVolver = new JButton("Volver");
			btnVolver.setIcon(new ImageIcon(GuiStock.class.getResource("/imagenes/Img/delete16.png")));
			btnVolver.setBounds(664, 540, 120, 23);
			getContentPane().add(btnVolver);

			lblPrecio = new JLabel("Precio");
			lblPrecio.setBounds(355, 35, 70, 23);
			getContentPane().add(lblPrecio);

			txtPrecio = new JTextField();
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(435, 35, 251, 23);
			getContentPane().add(txtPrecio);

			lblStockMinimo = new JLabel("Stock Mínimo");
			lblStockMinimo.setBounds(355, 69, 70, 23);
			getContentPane().add(lblStockMinimo);

			txtStockMinimo = new JTextField();
			txtStockMinimo.setColumns(10);
			txtStockMinimo.setBounds(435, 69, 251, 23);
			getContentPane().add(txtStockMinimo);

			ajustarAnchoColumnas();
			listar();
		}

		// Declaración global
		ArregloStock ap = new ArregloStock("archivo");

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
			txtCodigo.setText("" + ap.codigoCorrelativo());
			txtProductos.setText("");
			txtPrecio.setText("");

			txtStockActual.setText("");
			txtStockMinimo.setText("");
			// txtsStockActual.setText("");
			txtStockMaximo.setText("");
			txtCorreo.setText("");
			habilitarEntradas(true);
			habilitarBotones(false);
			txtProductos.requestFocus();
		}

		protected void actionPerformedBtnConsultar(ActionEvent arg0) {
			tipoOperacion = CONSULTAR;
			txtCodigo.setEditable(true);
			habilitarBotones(false);
			txtCodigo.requestFocus();
		}

		protected void actionPerformedBtnModificar(ActionEvent arg0) {
			tipoOperacion = MODIFICAR;
			txtCodigo.setEditable(true);
			habilitarEntradas(true);
			habilitarBotones(false);
			txtCodigo.requestFocus();
		}

		protected void actionPerformedBtnEliminar(ActionEvent arg0) {
			tipoOperacion = ELIMINAR;
			txtCodigo.setEditable(true);
			habilitarBotones(false);
		}

		protected void actionPerformedBtnAceptar(ActionEvent arg0) {
			switch (tipoOperacion) {
			case ADICIONAR:
				adicionarStock();
				break;
			case CONSULTAR:
				consultarStock();
				break;
			case MODIFICAR:
				modificarStock();
				break;
			case ELIMINAR:
				eliminarStock();
			}
		}

		protected void actionPerformedBtnBuscar(ActionEvent arg0) {
			consultarStock();
		}

		protected void actionPerformedBtnVolver(ActionEvent arg0) {
			txtCodigo.setText("");
			txtProductos.setText("");
			txtPrecio.setText("");
			txtStockActual.setText("");
			txtStockMinimo.setText("");

			txtStockMaximo.setText("");
			txtCorreo.setText("");
			txtCodigo.setEditable(false);
			habilitarEntradas(false);
			habilitarBotones(true);
		}

		// Métodos tipo void (sin parámetros)
		void ajustarAnchoColumnas() {
			TableColumnModel tcm = tblStock.getColumnModel();

			tcm.getColumn(0).setPreferredWidth(anchoColumna(10)); // código
			tcm.getColumn(1).setPreferredWidth(anchoColumna(20)); // productos
			tcm.getColumn(2).setPreferredWidth(anchoColumna(20)); // precio
			tcm.getColumn(3).setPreferredWidth(anchoColumna(20)); // stockMinimo
			tcm.getColumn(4).setPreferredWidth(anchoColumna(20)); // stockActual
			tcm.getColumn(5).setPreferredWidth(anchoColumna(20)); // stockMaximo

		}

		void listar() {
			Stock x;
			modelo.setRowCount(0);
			for (int i = 0; i < ap.tamaño(); i++) {
				x = ap.obtener(i);
				Object[] fila = { x.getCodigoProducto(), x.getNombre(),
						// x.getDni(),
						x.getPrecio(), // + ";" +

						x.getStockActual(), // + ";" +
						x.getStockMinimo(), // + ";" +
						x.getStockMaximo()// + ";"
						// x.getPeso(),
						// x.getEstatura(),
						// enTextoEstadoCivil(x.getEstado()),
						// x.imc()
				};
				modelo.addRow(fila);
			}
		}

		void buscarStock() {
			try {
				Stock x = ap.buscar(leerCodigo());
				if (x != null) {
					txtProductos.setText(x.getNombre());
					txtPrecio.setText("" + x.getPrecio());

					txtStockActual.setText("" + x.getStockActual());
					txtStockMinimo.setText("" + x.getStockMinimo());
					txtStockMaximo.setText("" + x.getStockMaximo());
					// txtPeso.setText("" + x.getPeso());
					// txtEstatura.setText("" + x.getEstatura());
					// cboEstadoCivil.setSelectedIndex(x.getEstado());
					txtCodigo.requestFocus();
				} else
					error("El código " + leerCodigo() + " no existe", txtCodigo);
			} catch (Exception e) {
				error("Ingrese CÓDIGO correcto", txtCodigo);
			}
		}

		void consultarStock() {
	//		try {
	//			Stock = ap.buscar(leerProductos());
	//			if (x != null) {
				//	txtProductos.setText("" + x.getCodigoProducto());
			//		txtProductos.setText("" + x.getNombre());
	//				txtPrecio.setText("" + x.getPrecio());
	//				txtStockActual.setText("" + x.getStockActual());
	//				txtStockMinimo.setText("" + x.getStockMinimo());
	//				txtStockMaximo.setText("" + x.getStockMaximo());
	//				txtCodigo.requestFocus();
	//			} else
//					error("Los PRODUCTOS " + leerProductos() + " no existe", txtProductos);
	//		} catch (Exception e) {
//				error("Ingrese PRODUCTO correcto", txtPrecio);
//			}
		}

		void adicionarStock() {
			int codigo = leerCodigo();
			String productos = leerProductos();
			if (productos.length() > 0) {
//revisa
				double precio = leerPrecio();

				// int stockActual = leerStockActual();
				int stockMaximo = leerStockMaximo();
				// String dni = leerDni();
				if (ap.buscar(stockMaximo) == null)
					try {
						int stockActual = leerStockActual();
						// int stockMinimo = leerStockMinimo();
						// String dirección = leerDirección();
						// double peso = leerPeso();
						try {
							int stockMinimo = leerStockMinimo();
							// int stockMaximo = leerStockMaximo();
							/// int stockActual = leerStockActual();
							// String teléfono = leerTelefono();
							// String dni = leerDni();
							// double estatura = leerEstatura();
							// int estado = leerPosEstado();

							Stock nueva = new Stock(codigo, productos, precio, stockActual, stockMinimo, stockMaximo);

							// (int codigoProducto, String nombre, double precio, int stockActual, int
							// stockMinimo,
							// int stockMaximo)
							// Clientes nueva = new Clientes(codigo, nombres, dni);
							// dni, peso,
							// estatura, estado);
							ap.adicionar(nueva);
							listar();
							txtCodigo.setText("" + ap.codigoCorrelativo());
							txtProductos.setText("");
							txtPrecio.setText("");

							txtStockActual.setText("");
							txtStockMinimo.setText("");
							// txtTelefono.setText("");
							// txtStockActual.setText("");
							txtStockMaximo.setText("");
							txtCorreo.setText("");
							txtProductos.requestFocus();
						} catch (Exception e) {
							error("Ingrese CORREO correctO", txtCorreo);
						}
					} catch (Exception e) {
						error("Ingrese STOCK MAXIMO correcto", txtStockMaximo);
					}
				else
					error("Ingrese STOCK ACTUAL correcto", txtStockActual);
			} else
				error("Ingrese todos los datos", txtProductos);
		}

		void eliminarStock() {
			try {
				int codigo = leerCodigo();
				Stock x = ap.buscar(codigo);
				if (x != null) {
					ap.eliminar(x);
					listar();
					txtCodigo.setText("");
					txtProductos.setText("");
					txtPrecio.setText("");
					txtStockMinimo.setText("");
					txtStockActual.setText("");
					txtStockMaximo.setText("");
					txtCorreo.setText("");
					txtCodigo.requestFocus();
				} else
					error("El código " + codigo + " no existe", txtCodigo);
			} catch (Exception e) {
				error("Ingrese CÓDIGO correcto", txtCodigo);
			}
		}

		void modificarStock() {
			try {
				Stock x = ap.buscar(leerCodigo());
				String stock = leerProductos();
				if (stock.length() > 0) {
					double precio = leerPrecio();
					// int StockActual = leerStockActual();
					// int stockMaximo = leerStockMaximo();
					// String dni = leerDni();
					Stock y = ap.buscar(precio);
					if (y == null || x.equals(y))
						try {
							// double Precio = leerPrecio();
							// double peso = leerPeso();
							int stockActual = leerStockActual();

							int stockMinimo = leerStockMinimo();
							// String Dirección = leerDirección();
							try {
								int stockMaximo = leerStockMaximo();

								// int stockMinimo = leerStockMinimo();
								// int stockActual = leerStockActual();
								// String Telefono = leerTelefono();
								// double estatura = leerEstatura();
								// int estado = leerPosEstado();
								x.setNombre(stock);
								x.setPrecio(precio);
//revisa stock
								x.setStockActual(stockActual);
								x.setStockMinimo(stockMinimo);
								x.setStockMaximo(stockMaximo);
								// x.setPeso(peso);
								// x.setEstatura(estatura);
								// x.setEstado(estado);
								listar();
								txtCodigo.requestFocus();
							} catch (Exception e) {
								error("Ingrese STOCK ACTUAL correcta", txtStockActual);
							}
						} catch (Exception e) {
							error("Ingrese STOCK MINIMO correcto", txtStockMinimo);
						}
					else
						error("Ingrese PRECIO correcto", txtPrecio);
				} else
					error("Ingrese PRODUCTO correcto", txtProductos);
			} catch (Exception e) {
				error("Ingrese CÓDIGO correcto", txtCodigo);
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
			txtProductos.setEditable(sino);
			txtPrecio.setEditable(sino);
			txtStockMinimo.setEditable(sino);

			txtStockActual.setEditable(sino);
			txtStockMaximo.setEditable(sino);
			txtCorreo.setEditable(sino);
			cboEstadoCivil.setEnabled(sino);
		}

		void mensaje(String s) {
			JOptionPane.showMessageDialog(this, s);
		}

		// Métodos que retornan valor (sin parámetros)

		int leerCodigo() {
			return Integer.parseInt(txtCodigo.getText().trim());
		}

		String leerProductos() {
			return txtProductos.getText().trim();
		}

		double leerPrecio() {
			// return txtPrecio.getText().trim();
			return Double.parseDouble(txtPrecio.getText().trim());
		}

		int leerStockMinimo() {
			return Integer.parseInt(txtStockMinimo.getText().trim());
		}

		int leerStockActual() {
			return Integer.parseInt(txtStockActual.getText().trim());
		}

		int leerStockMaximo() {
			return Integer.parseInt(txtStockMaximo.getText().trim());
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



		