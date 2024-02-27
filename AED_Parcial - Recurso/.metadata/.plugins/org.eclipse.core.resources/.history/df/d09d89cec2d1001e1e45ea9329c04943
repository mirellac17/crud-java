package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setExtendedState(MAXIMIZED_BOTH);
			//		frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setBackground(Color.CYAN);
		setFont(new Font("Dialog", Font.PLAIN, 20));
		setTitle("Software de Ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.YELLOW);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Mantenimiento");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Clientes");
		mntmNewMenuItem.setIcon(new ImageIcon("F:\\2024 Cibertec ciclo 2 Arq_Emp\\EA 4683 Algoritmios y Estructura de Datos\\iconos\\icons8-clientes-50.png"));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Productos");
		mntmNewMenuItem_1.setIcon(new ImageIcon("F:\\2024 Cibertec ciclo 2 Arq_Emp\\EA 4683 Algoritmios y Estructura de Datos\\iconos\\icons8-productos-50.png"));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Ventas");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Almacén");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Reportes");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Listado General de Ventas");
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Listado de Productos x Stock");
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Listado de Productos por Unidades Vendidas Acumuladas");
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Listado de Productos por Importe Total Acumulado");
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_4 = new JMenu("Redes Sociales");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Facebook");
		mntmNewMenuItem_2.setIcon(new ImageIcon("F:\\2024 Cibertec ciclo 2 Arq_Emp\\EA 4683 Algoritmios y Estructura de Datos\\iconos\\icons8-facebook-nuevo-48.png"));
		mnNewMenu_4.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Instagram");
		mntmNewMenuItem_3.setIcon(new ImageIcon("F:\\2024 Cibertec ciclo 2 Arq_Emp\\EA 4683 Algoritmios y Estructura de Datos\\iconos\\icons8-instagram-50.png"));
		mnNewMenu_4.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("WhatsApp");
		mntmNewMenuItem_4.setIcon(new ImageIcon("F:\\2024 Cibertec ciclo 2 Arq_Emp\\EA 4683 Algoritmios y Estructura de Datos\\iconos\\icons8-whatsapp-48.png"));
		mnNewMenu_4.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_5 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
