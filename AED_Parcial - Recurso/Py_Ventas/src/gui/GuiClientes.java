package gui;

import clases.Clientes;
import arreglos.ArregloClientes;

//import java.awt.Dimension;
//import java.awt.Dimension;
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
//import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;

//import java.util.ArrayList;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import javax.swing.table.*;

//public class DlgPersona extends JDialog implements ActionListener {

import javax.swing.JInternalFrame;
//import java.awt.event.ActionListener;

public class GuiClientes extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDirección;

	private JLabel lblTelefono;
	private JLabel lblDni;
	private JLabel lblCorreo;
	private JLabel lblEstadoCivil;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDirección;

	private JTextField txtTeléfono;
	private JTextField txtDni;
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
	private JTable tblClientes;
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
					GuiClientes frame = new GuiClientes();
					frame.setVisible(true);
					
		//			 GuiClientes clie = new GuiClientes();

	//				 Dimension desktopSize = escritorio.getSize();
	//				 Dimension FrameSize=clie.getSize();
		//			 clie.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
	//				 escritorio.add(clie);
		//			 clie.setVisible(true);
//
					// clie.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiClientes() {
		setIconifiable(true);
		setResizable(true);
	
		setMaximizable(true);
		setTitle("Mantenimiento | Clientes");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);

		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 10, 110, 23);
		getContentPane().add(lblCodigo);

		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(10, 35, 70, 23);
		getContentPane().add(lblNombres);

		lblTelefono = new JLabel("Teléfono");
		lblTelefono.setBounds(10, 60, 70, 23);
		getContentPane().add(lblTelefono);

		lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 85, 70, 23);
		getContentPane().add(lblDni);

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

		txtNombres = new JTextField();
		txtNombres.setBounds(90, 35, 251, 23);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);

		txtTeléfono = new JTextField();
		txtTeléfono.setBounds(90, 60, 86, 23);
		getContentPane().add(txtTeléfono);
		txtTeléfono.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(90, 85, 86, 23);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);

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

		tblClientes = new JTable();
		tblClientes.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblClientes);

		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("DNI");
		modelo.addColumn("CORREO ELECTRONICO");
		modelo.addColumn("ESTADO CIVIL");

		tblClientes.setModel( modelo);
	/*	tblClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
	*/	// new Object[][] {
		// },
		// new String[] {
		// }
		// );

//

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarClientes();
			}

		});
		btnBuscar.setIcon(new ImageIcon(GuiClientes.class.getResource("/imagenes/Img/loupe16.png")));
		btnBuscar.setBounds(240, 10, 101, 23);
		getContentPane().add(btnBuscar);

		btnAdicionar = new JButton("Ingreso");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarClientes();
			}
		});
		btnAdicionar.setIcon(new ImageIcon(GuiClientes.class.getResource("/imagenes/Img/add-event16.png")));
		// btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 540, 120, 23);
		getContentPane().add(btnAdicionar);

		btnConsultar = new JButton("Consultar x DNI");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarClientes();
			}
		});
		btnConsultar.setIcon(new ImageIcon(GuiClientes.class.getResource("/imagenes/Img/file16.png")));
		// btnConsultar.addActionListener(this);
		btnConsultar.setBounds(135, 540, 120, 23);
		getContentPane().add(btnConsultar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarClientes();

			}
		});
		btnModificar.setIcon(new ImageIcon(GuiClientes.class.getResource("/imagenes/Img/edit16.png")));
		// btnModificar.addActionListener(this);
		btnModificar.setBounds(260, 540, 120, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				eliminarClientes();

			}

		});
		btnEliminar.setIcon(new ImageIcon(GuiClientes.class.getResource("/imagenes/Img/multiply.png")));
		// btnEliminar.addActionListener(this);
		btnEliminar.setBounds(385, 540, 120, 23);
		getContentPane().add(btnEliminar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnAceptar.setIcon(new ImageIcon(GuiClientes.class.getResource("/imagenes/Img/save16.png")));
		btnAceptar.setBounds(510, 540, 120, 23);
		getContentPane().add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(GuiClientes.class.getResource("/imagenes/Img/delete16.png")));
		btnVolver.setBounds(664, 540, 120, 23);
		getContentPane().add(btnVolver);

		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(355, 35, 70, 23);
		getContentPane().add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(435, 35, 251, 23);
		getContentPane().add(txtApellidos);

		lblDirección = new JLabel("Dirección");
		lblDirección.setBounds(355, 69, 70, 23);
		getContentPane().add(lblDirección);

		txtDirección = new JTextField();
		txtDirección.setColumns(10);
		txtDirección.setBounds(435, 69, 251, 23);
		getContentPane().add(txtDirección);

		ajustarAnchoColumnas();
		listar();
	}

	// Declaración global
	ArregloClientes ap = new ArregloClientes("archivo");

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
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDirección.setText("");
		txtTeléfono.setText("");
		txtTeléfono.setText("");
		txtDni.setText("");
		txtCorreo.setText("");
		habilitarEntradas(true);
		habilitarBotones(false);
		txtNombres.requestFocus();
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
			adicionarClientes();
			break;
		case CONSULTAR:
			consultarClientes();
			break;
		case MODIFICAR:
			modificarClientes();
			break;
		case ELIMINAR:
			eliminarClientes();
		}
	}

	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		consultarClientes();
	}

	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		txtCodigo.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDirección.setText("");
		txtTeléfono.setText("");

		txtDni.setText("");
		txtCorreo.setText("");
		txtCodigo.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
	}

	// Métodos tipo void (sin parámetros)
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblClientes.getColumnModel();
		
		tcm.getColumn(0).setPreferredWidth(anchoColumna(20)); // código
	//	tcm.getColumn(1).setPreferredWidth(anchoColumna(20)); // nombres
	//	tcm.getColumn(2).setPreferredWidth(anchoColumna(20)); // apellidos
	//	tcm.getColumn(3).setPreferredWidth(anchoColumna(20)); // dirección
	//	tcm.getColumn(4).setPreferredWidth(anchoColumna(20)); // telefóno
	//	tcm.getColumn(5).setPreferredWidth(anchoColumna(20)); // dni

	}

	void listar() {
		Clientes x;
		modelo.setRowCount(0);
		for (int i = 0; i < ap.tamaño(); i++) {
			x = ap.obtener(i);
			Object[] fila = { x.getCodigoCliente(), x.getNombres(),

					x.getApellidos(), // + ";" +
					x.getDirección(), // + ";" +
					x.getTeléfono(), // + ";" +
					x.getDni()// + ";"

			};
			modelo.addRow(fila);
		}
	}

	void buscarClientes() {
		try {
			Clientes x = ap.buscar(leerCodigo());
			if (x != null) {
				txtNombres.setText(x.getNombres());
				txtApellidos.setText(x.getApellidos());
				txtDirección.setText(x.getDirección());
				txtTeléfono.setText(x.getTeléfono());
				txtDni.setText(x.getDni());

				txtCodigo.requestFocus();
			} else
				error("El código " + leerCodigo() + " no existe", txtCodigo);
		} catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}
	}

	void consultarClientes() {
		try {
			Clientes x = ap.buscar(leerDni());
			if (x != null) {
				txtCodigo.setText("" + x.getCodigoCliente());
				txtNombres.setText(x.getNombres());
				txtApellidos.setText(x.getApellidos());
				txtDirección.setText(x.getDirección());
				txtTeléfono.setText(x.getTeléfono());
				txtDni.setText(x.getDni());
				txtCodigo.requestFocus();
			} else
				error("El DNI " + leerDni() + " no existe", txtDni);
		} catch (Exception e) {
			error("Ingrese DNI correcto", txtDni);
		}
	}

	void adicionarClientes() {
		int codigo = leerCodigo();
		String nombres = leerNombres();
		if (nombres.length() > 0) {
			String apellidos = leerApellidos();

			String dni = leerDni();
			if (ap.buscar(dni) == null)
				try {
					String dirección = leerDirección();

					try {
						String teléfono = leerTelefono();

						Clientes nueva = new Clientes(codigo, nombres, apellidos, dirección, teléfono, dni);

						ap.adicionar(nueva);
						listar();
						txtCodigo.setText("" + ap.codigoCorrelativo());
						txtNombres.setText("");
						txtApellidos.setText("");
						txtDirección.setText("");

						txtTeléfono.setText("");
						txtDni.setText("");
						txtCorreo.setText("");
						txtNombres.requestFocus();
					} catch (Exception e) {
						error("Ingrese CORREO correctO", txtCorreo);
					}
				} catch (Exception e) {
					error("Ingrese DNI correcto", txtDni);
				}
			else
				error("Ingrese TELEFONO correcto", txtTeléfono);
		} else
			error("Ingrese todos los datos", txtNombres);
	}

	void eliminarClientes() {
		try {
			int codigo = leerCodigo();
			Clientes x = ap.buscar(codigo);
			if (x != null) {
				ap.eliminar(x);
				listar();
				txtCodigo.setText("");
				txtNombres.setText("");
				txtApellidos.setText("");
				txtDirección.setText("");
				txtTeléfono.setText("");
				txtDni.setText("");
				txtCorreo.setText("");
				txtCodigo.requestFocus();
			} else
				error("El código " + codigo + " no existe", txtCodigo);
		} catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}
	}

	void modificarClientes() {
		try {
			Clientes x = ap.buscar(leerCodigo());
			String nombres = leerNombres();
			if (nombres.length() > 0) {
				String dni = leerDni();
				Clientes y = ap.buscar(dni);
				if (y == null || x.equals(y))
					try {
						String Apellidos = leerApellidos();

						String Dirección = leerDirección();
						try {
							String Telefono = leerTelefono();

							x.setNombres(nombres);
							x.setApellidos(Apellidos);
							x.setDirección(Dirección);
							x.setTeléfono(Telefono);
							x.setDni(dni);

							listar();
							txtCodigo.requestFocus();
						} catch (Exception e) {
							error("Ingrese TELEFONO correcta", txtTeléfono);
						}
					} catch (Exception e) {
						error("Ingrese DIRECCION correcto", txtDirección);
					}
				else
					error("Ingrese APELLIDOS correcto", txtApellidos);
			} else
				error("Ingrese NOMBRE correcto", txtNombres);
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
		txtNombres.setEditable(sino);
		txtApellidos.setEditable(sino);
		txtDirección.setEditable(sino);

		txtTeléfono.setEditable(sino);
		txtDni.setEditable(sino);
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

	String leerNombres() {
		return txtNombres.getText().trim();
	}

	String leerApellidos() {
		return txtApellidos.getText().trim();
	}

	String leerDirección() {
		return txtDirección.getText().trim();
	}

	String leerTelefono() {
		return txtTeléfono.getText().trim();
	}

	String leerDni() {
		return txtDni.getText().trim();
	}

	// Métodos que retornan valor (con parámetros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	String enTextoEstadoCivil(int i) {
		return cboEstadoCivil.getItemAt(i);
	}

}
