package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
//	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
				//	frame.setExtendedState(MAXIMIZED_BOTH);
					//frame.setVisible(true);
				//	;
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
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Menu.class.getResource("/imagenes/Img/icons8-contabilidad-de-fondos-48.png")));
		getContentPane().setBackground(new Color(0, 255, 255));
		getContentPane().setLayout(new CardLayout(0, 0));

		JDesktopPane Escritorio = new JDesktopPane();
		getContentPane().add(Escritorio, "name_4356364595000");
		Escritorio.setLayout(new CardLayout(0, 0));
		setBackground(Color.GREEN);
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setTitle("Software de Ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.setBackground(Color.CYAN);
		menuBar.setBorder(new LineBorder(Color.BLACK));
		setJMenuBar(menuBar);

		JMenu mnNewMenu_7_1 = new JMenu("Sistema");
		mnNewMenu_7_1.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/surveillance32.png")));
		mnNewMenu_7_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_7_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
		menuBar.add(mnNewMenu_7_1);

		JMenuItem mntmNewMenuItem_4_1_1 = new JMenuItem("Cerrar");
		mntmNewMenuItem_4_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/room32.png")));
		mntmNewMenuItem_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.dispose();
			}
		});
		mnNewMenu_7_1.add(mntmNewMenuItem_4_1_1);

		JMenu mnNewMenu_2 = new JMenu("Mantenimiento");
		mnNewMenu_2.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/maintenance32.png")));
		mnNewMenu_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GREEN));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Clientes");
		mntmNewMenuItem_3.setBorder(null);
		mntmNewMenuItem_3.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/icons8-clientes-50.png")));
		mnNewMenu_2.add(mntmNewMenuItem_3);

		// JMenuItem mntmNewMenuItem_5 = new JMenuItem("Ingreso");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiClientes clie = new GuiClientes();
				Dimension desktopSize = Escritorio.getSize();
				Dimension FrameSize = clie.getSize();
				clie.setLocation((desktopSize.width - FrameSize.width) / 2,
						(desktopSize.height - FrameSize.height) / 2);
				Escritorio.add(clie);
				clie.setVisible(true);
				// clie.show();
				
			}
		});
		
		JMenuItem mntmNewMenuItem_3_3 = new JMenuItem("Clientes");
		mntmNewMenuItem_3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiClientes clie2 = new GuiClientes();
				Dimension desktopSize = Escritorio.getSize();
				Dimension FrameSize = clie2.getSize();
				clie2.setLocation((desktopSize.width - FrameSize.width) / 2,
						(desktopSize.height - FrameSize.height) / 2);
				Escritorio.add(clie2);
				clie2.setVisible(true);
				// clie.show();
				
				
			}
		});
		mntmNewMenuItem_3_3.setBorder(null);
		mnNewMenu_2.add(mntmNewMenuItem_3_3);

		JMenu mnNewMenu = new JMenu("Clientes");
		mnNewMenu.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/icons8-clientes-50.png")));
		mnNewMenu_2.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Ingreso");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaCliente clie = new AltaCliente();
				Dimension desktopSize = Escritorio.getSize();
				Dimension FrameSize = clie.getSize();
				clie.setLocation((desktopSize.width - FrameSize.width) / 2,
						(desktopSize.height - FrameSize.height) / 2);
				Escritorio.add(clie);
				clie.setVisible(true);
				// clie.show();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Modificación");
		mnNewMenu.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Consulta");
		mnNewMenu.add(mntmNewMenuItem_8);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Eliminación");
		mnNewMenu.add(mntmNewMenuItem_9);

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Listado");
		mnNewMenu.add(mntmNewMenuItem_10);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Productos");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GuiProductos prod = new GuiProductos();
				Dimension desktopSize = Escritorio.getSize();
				Dimension FrameSize = prod.getSize();
				prod.setLocation((desktopSize.width - FrameSize.width) / 2,
						(desktopSize.height - FrameSize.height) / 2);
				Escritorio.add(prod);
				prod.setVisible(true);
				// prod.show();

			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/icons8-sensor-48.png")));
		mnNewMenu_2.add(mntmNewMenuItem_4);

		JMenu mnProductos = new JMenu("Productos");
		mnProductos.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/icons8-sensor-48.png")));
		mnNewMenu_2.add(mnProductos);

		JMenuItem mntmNewMenuItem_5_2 = new JMenuItem("Ingreso");
		mnProductos.add(mntmNewMenuItem_5_2);

		JMenuItem mntmNewMenuItem_6_2 = new JMenuItem("Modificación");
		mnProductos.add(mntmNewMenuItem_6_2);

		JMenuItem mntmNewMenuItem_8_2 = new JMenuItem("Consulta");
		mnProductos.add(mntmNewMenuItem_8_2);

		JMenuItem mntmNewMenuItem_9_2 = new JMenuItem("Eliminación");
		mnProductos.add(mntmNewMenuItem_9_2);

		JMenuItem mntmNewMenuItem_10_2 = new JMenuItem("Listado");
		mnProductos.add(mntmNewMenuItem_10_2);

		JMenu mnNewMenu_1 = new JMenu("Ventas");
		mnNewMenu_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
		mnNewMenu_1.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/icons8-ventas-48.png")));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_7_1 = new JMenuItem("Boleta de Pago");
		mntmNewMenuItem_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// mntmNewMenuItem_3.addActionListener(new ActionListener() {
				// public void actionPerformed(ActionEvent e) {
				Ventas vent = new Ventas();
				Dimension desktopSize = Escritorio.getSize();
				Dimension FrameSize = vent.getSize();
				vent.setLocation((desktopSize.width - FrameSize.width) / 2,
						(desktopSize.height - FrameSize.height) / 2);
				Escritorio.add(vent);
				vent.setVisible(true);
				// vent.show();

			}
		});
		mntmNewMenuItem_7_1.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/payment32.png")));
		mnNewMenu_1.add(mntmNewMenuItem_7_1);

		JMenuItem mntmNewMenuItem_6_3_1 = new JMenuItem("Modificación");
		mnNewMenu_1.add(mntmNewMenuItem_6_3_1);

		JMenuItem mntmNewMenuItem_8_3_1 = new JMenuItem("Consulta");
		mnNewMenu_1.add(mntmNewMenuItem_8_3_1);

		JMenuItem mntmNewMenuItem_9_3_1 = new JMenuItem("Eliminación");
		mnNewMenu_1.add(mntmNewMenuItem_9_3_1);

		JMenuItem mntmNewMenuItem_10_3_1 = new JMenuItem("Listado");
		mnNewMenu_1.add(mntmNewMenuItem_10_3_1);

		JMenu mnNewMenu_4 = new JMenu("Almacén");
		mnNewMenu_4.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/forklift32.png")));
		mnNewMenu_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GREEN));
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Stock");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GuiStock sto = new GuiStock();
				Dimension desktopSize = Escritorio.getSize();
				Dimension FrameSize = sto.getSize();
				sto.setLocation((desktopSize.width - FrameSize.width) / 2,
						(desktopSize.height - FrameSize.height) / 2);
				Escritorio.add(sto);
				sto.setVisible(true);
				// prod.show();
			}
		});
		mntmNewMenuItem_7.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/stock32.png")));
		mnNewMenu_4.add(mntmNewMenuItem_7);
	//	Dimension desktopSize = Escritorio.getSize();
		// sto.show();
						

		JMenuItem mntmNewMenuItem_6_3 = new JMenuItem("Modificación");
		mnNewMenu_4.add(mntmNewMenuItem_6_3);

		JMenuItem mntmNewMenuItem_8_3 = new JMenuItem("Consulta");
		mnNewMenu_4.add(mntmNewMenuItem_8_3);

		JMenuItem mntmNewMenuItem_9_3 = new JMenuItem("Eliminación");
		mnNewMenu_4.add(mntmNewMenuItem_9_3);

		JMenuItem mntmNewMenuItem_10_3 = new JMenuItem("Listado");
		mnNewMenu_4.add(mntmNewMenuItem_10_3);

		JMenu mnNewMenu_2_1 = new JMenu("Reportes");
		mnNewMenu_2_1.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/report32____.png")));
		mnNewMenu_2_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
		mnNewMenu_2_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_2_1);

		JMenuItem mntmNewMenuItem_3_2 = new JMenuItem("Listado general de ventas mostrando en cada caso");
		mntmNewMenuItem_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GuiReportes report = new GuiReportes();
				Dimension desktopSize = Escritorio.getSize();
				Dimension FrameSize = report.getSize();
				report.setLocation((desktopSize.width - FrameSize.width) / 2,
						(desktopSize.height - FrameSize.height) / 2);
				Escritorio.add(report);
				report.setVisible(true);
				// report.show();
				
						
				
			}
		});
		
		mntmNewMenuItem_3_2.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/report32.png")));
		mnNewMenu_2_1.add(mntmNewMenuItem_3_2);

		JMenu mnListadoDeProductos = new JMenu("Listado de productos por stock");
		mnListadoDeProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			}
		});
		mnListadoDeProductos.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/stock_32.png")));
		mnNewMenu_2_1.add(mnListadoDeProductos);

		JMenuItem mntmNewMenuItem_5_1 = new JMenuItem("Ingreso");
		mnListadoDeProductos.add(mntmNewMenuItem_5_1);
		
		
		
		

		JMenuItem mntmNewMenuItem_6_1 = new JMenuItem("Modificación");
		mnListadoDeProductos.add(mntmNewMenuItem_6_1);

		JMenuItem mntmNewMenuItem_8_1 = new JMenuItem("Consulta");
		mnListadoDeProductos.add(mntmNewMenuItem_8_1);

		JMenuItem mntmNewMenuItem_9_1 = new JMenuItem("Eliminación");
		mnListadoDeProductos.add(mntmNewMenuItem_9_1);

		JMenuItem mntmNewMenuItem_10_1 = new JMenuItem("Listado");
		mnListadoDeProductos.add(mntmNewMenuItem_10_1);

		JMenuItem mntmNewMenuItem_4_2 = new JMenuItem("Listado de productos por unidades vendidas acumuladas");
		mntmNewMenuItem_4_2.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/report32__.png")));
		mnNewMenu_2_1.add(mntmNewMenuItem_4_2);

		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Listado de productos por importe total acumulado");
		mntmNewMenuItem_12.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/report32_.png")));
		mnNewMenu_2_1.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_12_1 = new JMenuItem("Listado de productos por importe total acumulado");
		mntmNewMenuItem_12_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GuiAlumnos alu = new GuiAlumnos();
				Dimension desktopSize = Escritorio.getSize();
				Dimension FrameSize = alu.getSize();
				alu.setLocation((desktopSize.width - FrameSize.width) / 2,
						(desktopSize.height - FrameSize.height) / 2);
				Escritorio.add(alu);
				alu.setVisible(true);
				// report.show();
				
				
			}
		});
		mnNewMenu_2_1.add(mntmNewMenuItem_12_1);

		JMenu mnNewMenu_7 = new JMenu("Soporte Técnico");
		mnNewMenu_7.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/technical-support32.png")));
		mnNewMenu_7.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GREEN));
		mnNewMenu_7.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_7);

		JMenuItem mntmNewMenuItem_4_1 = new JMenuItem("Facebook");
		mntmNewMenuItem_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop1 = Desktop.getDesktop();
					if (desktop1.isSupported(Desktop.Action.BROWSE)) {
						try {
							desktop1.browse(new URI("https://www.facebook.com"));

						} catch (IOException e) {
							e.printStackTrace();
						} catch (URISyntaxException e) {

						}
					}
				}
			}
		});
		mntmNewMenuItem_4_1.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/facebook32.png")));
		mnNewMenu_7.add(mntmNewMenuItem_4_1);

		JMenuItem mntmNewMenuItem_3_1 = new JMenuItem("Instagram");
		mntmNewMenuItem_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop1 = Desktop.getDesktop();
					if (desktop1.isSupported(Desktop.Action.BROWSE)) {
						try {
							desktop1.browse(new URI("https://www.instagram.com"));

						} catch (IOException e) {
							e.printStackTrace();
						} catch (URISyntaxException e) {

						}
					}
				}

			}
		});
		mntmNewMenuItem_3_1.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/instagram32.png")));
		mnNewMenu_7.add(mntmNewMenuItem_3_1);

		JMenuItem mntmLinkedin = new JMenuItem("Linkedin");
		mntmLinkedin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop1 = Desktop.getDesktop();
					if (desktop1.isSupported(Desktop.Action.BROWSE)) {
						try {
							desktop1.browse(new URI("https://www.linkedin.com/"));

						} catch (IOException e) {
							e.printStackTrace();
						} catch (URISyntaxException e) {

						}
					}
				}

			}
		});
		mntmLinkedin.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/linkedin32.png")));
		mnNewMenu_7.add(mntmLinkedin);

		JMenuItem mntmPreguntasTcnicas = new JMenuItem("Preguntas Técnicas");
		mntmPreguntasTcnicas.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/question32.png")));
		mnNewMenu_7.add(mntmPreguntasTcnicas);

		JMenuItem mntmManualDeUsuario = new JMenuItem("Manual de Usuario");
		mntmManualDeUsuario.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/instruction32.png")));
		mnNewMenu_7.add(mntmManualDeUsuario);

		JMenuItem mntmLicencia = new JMenuItem("Licencia");
		mntmLicencia.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/license32.png")));
		mnNewMenu_7.add(mntmLicencia);

		JMenuItem mntmSugiereTusIdeas = new JMenuItem("Sugiere tus ideas");
		mntmSugiereTusIdeas.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/idea32.png")));
		mnNewMenu_7.add(mntmSugiereTusIdeas);

		JMenu mnNewMenu_7_2 = new JMenu("Nosotros");
		mnNewMenu_7_2.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/developers32.png")));
		mnNewMenu_7_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_7_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
		menuBar.add(mnNewMenu_7_2);

		JMenuItem mntmNewMenuItem_4_1_2 = new JMenuItem("Creadores");
		mntmNewMenuItem_4_1_2.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/star32.png")));
		mnNewMenu_7_2.add(mntmNewMenuItem_4_1_2);

		JMenuItem mntmNewMenuItem_3_1_1 = new JMenuItem("Sponsor");
		mntmNewMenuItem_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop1 = Desktop.getDesktop();
					if (desktop1.isSupported(Desktop.Action.BROWSE)) {
						try {
							desktop1.browse(new URI("https://www.eclipse.org/setups/sponsor/"));

						} catch (IOException e) {
							e.printStackTrace();
						} catch (URISyntaxException e) {

						}
					}
				}

			}
		});
		mntmNewMenuItem_3_1_1.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/love3232.png")));
		mnNewMenu_7_2.add(mntmNewMenuItem_3_1_1);

		JMenuItem mntmLinkedin_1 = new JMenuItem("Agradecimiento");
		mntmLinkedin_1.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Img/compassion32.png")));
		mnNewMenu_7_2.add(mntmLinkedin_1);
	}

//	private class SwingAction extends AbstractAction {
//		public SwingAction() {		
//			putValue(NAME, "SwingAction");
//		putValue(SHORT_DESCRIPTION, "Some short description");
//	}
//	public void actionPerformed(ActionEvent e) {
//	}
//	}
}
		
	
	
