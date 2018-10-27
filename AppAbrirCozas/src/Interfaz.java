import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Interfaz extends JFrame {
	
	public Controlador c;
	protected JPanel contentPane;
	protected JTextField textField;
	protected JButton btnExcel;
	protected JButton btnWord;
	protected JButton btnPW;
	protected JButton btnBuscar;
	protected JList list;
	protected JScrollPane scrollPane;
	protected DefaultListModel modelo = new DefaultListModel();
	public Object textFieldDireccion;

	public void setControlador(Controlador c) {
		this.c=c;
	}
	
	


	/**
	 * Create the frame.
	 */
	public Interfaz() {
		setBackground(new Color(102, 205, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 105, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnExcel = new JButton("EXCEL\r\n");
		btnExcel.setBackground(new Color(255, 165, 0));
		btnExcel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				c.abrirPrograma("EXCEL");
			}
		});
		btnExcel.setBounds(48, 28, 89, 23);
		contentPane.add(btnExcel);
		
		btnWord = new JButton("WORD\r\n");
		btnWord.setBackground(new Color(0, 0, 205));
		btnWord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.abrirPrograma("WINWORD");
			}
		});
		btnWord.setBounds(164, 28, 89, 23);
		contentPane.add(btnWord);
		
		btnPW = new JButton("P. POINT");
		btnPW.setBackground(new Color(220, 220, 220));
		btnPW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.abrirPrograma("POWERPNT");
			}
		});
		btnPW.setBounds(300, 28, 89, 23);
		contentPane.add(btnPW);
		
		textField = new JTextField();
		textField.setBackground(new Color(224, 255, 255));
		textField.setBounds(51, 94, 202, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(0, 255, 255));
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.navegar(textField.getText());
			}
		});
		btnBuscar.setBounds(300, 93, 89, 23);
		contentPane.add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 125, 208, 111);
		contentPane.add(scrollPane);
		
		list = new JList();
		list.setBackground(new Color(250, 235, 215));
		scrollPane.setViewportView(list);
	}

	
}
