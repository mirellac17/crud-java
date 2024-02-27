package gui;
import clases.Reportes;

import arreglos.AregloReportes;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JTextArea;

public class GuiReportes extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabel lblcodigoVenta;
	private JLabel lblcodigoCliente;
	private JLabel lblcodigoProducto;
	private JLabel lbl_Fecha;
	private JLabel lbl_Importe_subtotal;
	private JLabel lbl_Importe_del_IGV;
	private JLabel lbl_Importe_total;
	private JLabel lblEstadoCivil;
	private JTextField txtcodigoVenta;
	private JTextField txtcodigoCliente;
	private JTextField txtcodigoProducto;
	private JTextField txt_Fecha;
	private JTextField txt_Importe_subtotal;
	private JTextField txt_Importe_del_IGV;
	private JTextField txt_Importe_total;
	private JComboBox<String> cboEstadoCivil;
	private JScrollPane scrollPane;
	private JButton btnBuscar;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JTable tblReportes;
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
					GuiReportes frame = new GuiReportes();
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
	public GuiReportes() {
	//	setBounds(100, 100, 450, 300);
		
			setMaximizable(true);
			setIconifiable(true);
			setClosable(true);
			// setBounds(100, 100, 450, 300);

			setResizable(true);
			setTitle("Reportes | Listado general de ventas mostrando en cada caso");
			setBounds(100, 100, 800, 600);
			getContentPane().setLayout(null);

			lblcodigoVenta = new JLabel("Código de Venta");
			lblcodigoVenta.setBounds(10, 10, 110, 23);
			getContentPane().add(lblcodigoVenta);

			lblcodigoCliente = new JLabel("Código de Cliente");
			lblcodigoCliente.setBounds(10, 35, 86, 23);
			getContentPane().add(lblcodigoCliente);

			lbl_Importe_subtotal = new JLabel("Importe Subtotal");
			lbl_Importe_subtotal.setBounds(10, 60, 86, 23);
			getContentPane().add(lbl_Importe_subtotal);

			lbl_Importe_del_IGV = new JLabel("Importe_del_IGV ");
			lbl_Importe_del_IGV.setBounds(10, 85, 86, 23);
			getContentPane().add(lbl_Importe_del_IGV);

			lbl_Importe_total = new JLabel("Importe Total");
			lbl_Importe_total.setBounds(10, 110, 70, 23);
			getContentPane().add(lbl_Importe_total);

			lblEstadoCivil = new JLabel("Estado civil");
			lblEstadoCivil.setBounds(10, 135, 86, 23);
			getContentPane().add(lblEstadoCivil);

			txtcodigoVenta = new JTextField();
			txtcodigoVenta.setBounds(106, 10, 86, 23);
			getContentPane().add(txtcodigoVenta);
			txtcodigoVenta.setColumns(10);

			txtcodigoCliente = new JTextField();
			txtcodigoCliente.setBounds(105, 35, 236, 23);
			getContentPane().add(txtcodigoCliente);
			txtcodigoCliente.setColumns(10);

			txt_Importe_subtotal = new JTextField();
			txt_Importe_subtotal.setBounds(106, 60, 86, 23);
			getContentPane().add(txt_Importe_subtotal);
			txt_Importe_subtotal.setColumns(10);

			txt_Importe_del_IGV = new JTextField();
			txt_Importe_del_IGV.setBounds(106, 85, 86, 23);
			getContentPane().add(txt_Importe_del_IGV);
			txt_Importe_del_IGV.setColumns(10);

			txt_Importe_total = new JTextField();
			txt_Importe_total.setBounds(106, 110, 86, 23);
			getContentPane().add(txt_Importe_total);
			txt_Importe_total.setColumns(10);

			cboEstadoCivil = new JComboBox<String>();
			cboEstadoCivil.setEditable(true);
			cboEstadoCivil.setModel(
					new DefaultComboBoxModel<String>(new String[] { "Soltero", "Casado", "Viudo", "Divorciado" }));
			cboEstadoCivil.setBounds(106, 135, 86, 23);
			getContentPane().add(cboEstadoCivil);

			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 170, 775, 360);
			getContentPane().add(scrollPane);

			tblReportes = new JTable();
			tblReportes.setFillsViewportHeight(true);
			scrollPane.setViewportView(tblReportes);

			modelo = new DefaultTableModel();
			modelo.addColumn("CÓDIGO DE VENTA");
			modelo.addColumn("CÓDIGO DE CLIENTE");
			modelo.addColumn("CODIGO DEL PRODUCTO");
			modelo.addColumn("FECHA");
			modelo.addColumn("IMPORTE SUBTOTAL (S/)");
			modelo.addColumn("IMPORTE DEL IGV (S/)");
			modelo.addColumn("IMPORTE TOTAL A PAGAR (S/)");
//			modelo.addColumn("NOMBRES Y APELLIDOS DEL CLIENTE");
			// modelo.addColumn("IMC = peso/estatura²");
		
			tblReportes.setModel( modelo);
			//tblReportes.setModel(new DefaultTableModel(
//				new Object[][] {
			//	},
		//		new String[] {
		//		}
		//	));
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

					buscarReportes();
				}
				// {
				// public void actionPerformed(ActionEvent e) {
				// Clientes buscar(String dni);
				// Clientes buscar(int codigo);
				// consultarClientes();

			});
			btnBuscar.setIcon(new ImageIcon(Ventas.class.getResource("/imagenes/Img/loupe16.png")));
			btnBuscar.setBounds(240, 10, 101, 23);
			getContentPane().add(btnBuscar);

			btnAdicionar = new JButton("Ingreso");
			btnAdicionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					adicionarReportes();
				}
			});
			btnAdicionar.setIcon(new ImageIcon(Ventas.class.getResource("/imagenes/Img/add-event16.png")));
			// btnAdicionar.addActionListener(this);
			btnAdicionar.setBounds(10, 540, 120, 23);
			getContentPane().add(btnAdicionar);

			btnConsultar = new JButton("Consultar x Venta");
			btnConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					consultarReportes();
				}
			});
			btnConsultar.setIcon(new ImageIcon(Ventas.class.getResource("/imagenes/Img/file16.png")));
			// btnConsultar.addActionListener(this);
			btnConsultar.setBounds(135, 540, 120, 23);
			getContentPane().add(btnConsultar);

			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modificarReportes();

				}
			});
			btnModificar.setIcon(new ImageIcon(Ventas.class.getResource("/imagenes/Img/edit16.png")));
			// btnModificar.addActionListener(this);
			btnModificar.setBounds(260, 540, 120, 23);
			getContentPane().add(btnModificar);

			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					eliminarReportes();

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
			lblcodigoProducto.setBounds(355, 35, 104, 23);
			getContentPane().add(lblcodigoProducto);

			txtcodigoProducto = new JTextField();
			txtcodigoProducto.setColumns(10);
			txtcodigoProducto.setBounds(469, 35, 251, 23);
			getContentPane().add(txtcodigoProducto);

			lbl_Fecha = new JLabel("Fecha");
			lbl_Fecha.setBounds(355, 69, 70, 23);
			getContentPane().add(lbl_Fecha);

			txt_Fecha = new JTextField();
			txt_Fecha.setColumns(10);
			txt_Fecha.setBounds(469, 69, 251, 23);
			getContentPane().add(txt_Fecha);
			
			JButton btnReportar = new JButton("Reportar");
			btnReportar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			

					
				}
			});
			btnReportar.setIcon(new ImageIcon(GuiReportes.class.getResource("/imagenes/Img/hoja-de-calculo16.png")));
			btnReportar.setBounds(240, 135, 101, 23);
	//		getContentPane().add(btnReportar);
			
			btnListar = new JButton("Listar");
			btnListar.setBounds(240, 85, 101, 23);
//			getContentPane().add(btnListar);

			ajustarAnchoColumnas();
			listar();
		}

		// Declaración global
		AregloReportes ap = new AregloReportes();
		private JButton btnListar;

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

			txt_Importe_subtotal.setText("");
			txt_Fecha.setText("");
			txt_Importe_del_IGV.setText("");
			txt_Importe_total.setText("");
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
				adicionarReportes();
				break;
			case CONSULTAR:
				consultarReportes();
				break;
			case MODIFICAR:
				modificarReportes();
				break;
			case ELIMINAR:
				eliminarReportes();
			}
		}

		protected void actionPerformedBtnBuscar(ActionEvent arg0) {
			consultarReportes();
		}

		protected void actionPerformedBtnVolver(ActionEvent arg0) {
			txtcodigoVenta.setText("");
			txtcodigoCliente.setText("");
			txtcodigoProducto.setText("");
			txt_Importe_subtotal.setText("");
			txt_Fecha.setText("");

			txt_Importe_del_IGV.setText("");
			txt_Importe_total.setText("");
			txtcodigoVenta.setEditable(false);
			habilitarEntradas(false);
			habilitarBotones(true);
		}

		// Métodos tipo void (sin parámetros)
		void ajustarAnchoColumnas() {
			TableColumnModel tcm = tblReportes.getColumnModel();
			tcm.getColumn(0).setPreferredWidth(anchoColumna(10)); // código de venta
			tcm.getColumn(1).setPreferredWidth(anchoColumna(20)); // código de cliente
			tcm.getColumn(2).setPreferredWidth(anchoColumna(20)); // código de producto
			tcm.getColumn(3).setPreferredWidth(anchoColumna(20)); // fecha
			tcm.getColumn(4).setPreferredWidth(anchoColumna(20)); // importe subtotal
			tcm.getColumn(5).setPreferredWidth(anchoColumna(20)); // importe del IGV
			tcm.getColumn(6).setPreferredWidth(anchoColumna(20)); //  importe total
		//	tcm.getColumn(7).setPreferredWidth(anchoColumna(20)); // nombres y apellidos
		
		}

		void listar() {
			Reportes x;
			modelo.setRowCount(0);
			for (int i = 0; i < ap.tamaño(); i++) {
				x = ap.obtener(i);
				Object[] fila = { x.getCodigoVenta(), x.getCodigoCliente(),
						// x.getDni(),
						x.getCodigoProducto(), // + ";" +
						x.getImporte_subtotal(), // + ";" +
						x.getFecha(), // + ";" +
						x.getImporte_del_IGV(),// + ";"
						x.getImporte_total()// + ";"
						// x.getPeso(),
						// x.getEstatura(),
						// enTextoEstadoCivil(x.getEstado()),
						// x.imc()
				};
				modelo.addRow(fila);
			}
		}


	//super();	
		
		void buscarReportes() {
			try {
				Reportes x = ap.buscar(leerCodigo());
				if (x != null) {
					txtcodigoVenta.setText("" + x.getCodigoVenta());
					txtcodigoCliente.setText("" + x.getCodigoCliente());
					txtcodigoProducto.setText("" + x.getCodigoProducto());
					txt_Fecha.setText("" + x.getFecha());
					txt_Importe_subtotal.setText("" + x.getImporte_subtotal());
					txt_Importe_del_IGV.setText("" + x.getImporte_del_IGV());
					txt_Importe_total.setText("" + x.getImporte_total());
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

		void consultarReportes() {
			try {
				Reportes x = ap.buscar(leerVentas());
				if (x != null) {
					txtcodigoVenta.setText("" + x.getCodigoVenta());
					txtcodigoCliente.setText("" + x.getCodigoCliente());
					txtcodigoProducto.setText("" + x.getCodigoProducto());
					txt_Importe_subtotal.setText("" + x.getImporte_subtotal());
					txt_Fecha.setText("" + x.getFecha());
					txt_Importe_del_IGV.setText("" + x.getFecha());
					txtcodigoVenta.requestFocus();
				} else
					error("Los PRODUCTOS " + leerVentas() + " no existe", txtcodigoCliente);
			} catch (Exception e) {
				error("Ingrese PRODUCTO correcto", txtcodigoProducto);
			}
		}

		void adicionarReportes() {
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
				double importe_subtotal = leerImporte_subtotal();
				// String dni = leerDni();
				if (ap.buscar(importe_subtotal) == null)
					try {
						double importe_del_IGV = leerImporte_del_IGV();
					//	double precio = leerPrecio();
						// int stockMinimo = leerStockMinimo();
						// String dirección = leerDirección();
						// double peso = leerPeso();
						try {
							double importe_total = leerImporte_total();
						//	String fecha = leerFecha();
							// int stockMaximo = leerStockMaximo();
							/// int stockActual = leerStockActual();
							// String teléfono = leerTelefono();
							// String dni = leerDni();
							// double estatura = leerEstatura();
							// int estado = leerPosEstado();

							Reportes nueva = new Reportes(codigoVenta, codigoCliente, codigoProducto, fecha,importe_subtotal,importe_del_IGV,importe_total);

							
							
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

							txt_Importe_subtotal.setText("");
							txt_Fecha.setText("");
							// txtTelefono.setText("");
							// txtStockActual.setText("");
							txt_Importe_del_IGV.setText("");
							// txtCorreo.setText("");
							txtcodigoCliente.requestFocus();
						} catch (Exception e) {
							error("Ingrese CORREO correctO", txt_Importe_total);
						}
					} catch (Exception e) {
						error("Ingrese STOCK MAXIMO correcto", txt_Importe_del_IGV);
					}
				else
					error("Ingrese STOCK ACTUAL correcto", txt_Importe_subtotal);
			} else
				error("Ingrese todos los datos", txtcodigoCliente);
		}

		void eliminarReportes() {
			try {
				int codigo = leerCodigo();
				Reportes x = ap.buscar(codigo);
				if (x != null) {
					ap.eliminar(x);
					listar();
					txtcodigoVenta.setText("");
					txtcodigoCliente.setText("");
					txtcodigoProducto.setText("");
					txt_Importe_subtotal.setText("");
					txt_Fecha.setText("");
					txt_Importe_del_IGV.setText("");
					// txtCorreo.setText("");
					txtcodigoVenta.requestFocus();
				} else
					error("El código " + codigo + " no existe", txtcodigoVenta);
			} catch (Exception e) {
				error("Ingrese CÓDIGO correcto", txtcodigoVenta);
			}
		}

		void modificarReportes() {
			try {
				Reportes x = ap.buscar(leerCodigo());
				String Reportes = leerVentas();
				if (Reportes.length() > 0) {
					int codigoVenta = leerCodigoVenta();
					int codigoCliente = leerCodigoCliente();
					// int StockActual = leerStockActual();
					// int stockMaximo = leerStockMaximo();
					 String fecha = leerFecha();
					Reportes y = ap.buscar(leerCodigoCliente());
					if (y == null || x.equals(y))
						try {
							// double Precio = leerPrecio();
							// double peso = leerPeso();
							int codigoProducto = leerCodigoProducto();
						//	int cantidad = leerCantidad();

					//		 double precio = leerPrecio();
							// String Dirección = leerDirección();
						
							try {
								double importe_subtotal = leerImporte_subtotal();
								double importe_del_IGV = leerImporte_del_IGV();
								double importe_total = leerImporte_total();
								
								//String Fecha = leerFecha();
								x.setCodigoVenta(codigoVenta);
								x.setCodigoCliente(codigoCliente);
								x.setCodigoProducto(codigoProducto);
								x.setFecha(fecha);
								x.setImporte_subtotal(importe_subtotal);
								x.setImporte_del_IGV(importe_del_IGV);
								x.setImporte_total(importe_total);
								// x.setPeso(peso);
								// x.setEstatura(estatura);
								// x.setEstado(estado);
								
								
								listar();
								txtcodigoVenta.requestFocus();
							} catch (Exception e) {
								error("Ingrese STOCK ACTUAL correcta", txt_Importe_subtotal);
							}
						} catch (Exception e) {
							error("Ingrese STOCK MINIMO correcto", txt_Fecha);
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
			txt_Fecha.setEditable(sino);

			txt_Importe_subtotal.setEditable(sino);
			txt_Importe_del_IGV.setEditable(sino);
			txt_Importe_total.setEditable(sino);
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

		int leerImporte_subtotal() {
			return Integer.parseInt(txt_Importe_subtotal.getText().trim());
		}

		String leerFecha() {
			return txt_Fecha.getText().trim();
		}

		double leerImporte_del_IGV() {
			return Double.parseDouble(txt_Importe_del_IGV.getSelectedText());
		}
		
		double leerImporte_total() {
			return Double.parseDouble(txt_Importe_total.getSelectedText());
		}
		
		// Métodos tipo void sin parámetros
	//	void imprimir() {
	//	imprimir("");
	//	}

		
		
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
		
		// Métodos tipo void con parámetros
//		void imprimir(String s) {
//		txtS.append(s + "\n");
//		}
	}

