package desin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class VentanaRepaso {

	private JFrame frame;
	private JTextField tf_texto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRepaso window = new VentanaRepaso();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaRepaso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Desin");
		
		tf_texto = new JTextField();
		tf_texto.setText("Elige un color");
		tf_texto.setBounds(46, 28, 343, 20);
		frame.getContentPane().add(tf_texto);
		tf_texto.setColumns(10);
		
		JComboBox cb_colores = new JComboBox();
		cb_colores.setModel(new DefaultComboBoxModel(new String[] {"Azul", "Verde", "Rojo"}));
		cb_colores.setBounds(46, 105, 107, 22);
		frame.getContentPane().add(cb_colores);
		
		JCheckBox checkBoxNegrita = new JCheckBox("Negrita");
		checkBoxNegrita.setBounds(46, 165, 97, 23);
		frame.getContentPane().add(checkBoxNegrita);
		
		JButton btnCambiarColor = new JButton("Cambiar color");
		btnCambiarColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Color colorTexto = new Color(0);
				String colorSelec = (String) cb_colores.getSelectedItem();
				
				switch (colorSelec) {
				case "Azul":
					colorTexto = Color.blue;
					break;
					
				case "Verde":
					colorTexto = Color.green;
					break;
					
				case "Rojo":
					colorTexto = Color.red;
					break;

				}
				
				
				if (checkBoxNegrita.isSelected()) {
					
					//Font font = new Font(tf_texto.getText(), Font.BOLD, 0);
					tf_texto.setFont(new Font("Arial", Font.BOLD, 14));
					tf_texto.setText("Ahora soy de color " + colorSelec);
				}
				else {
					
					tf_texto.setFont(new Font("Arial", Font.PLAIN, 14));
					tf_texto.setText("Ahora soy de color " + colorSelec);
				}
				
				tf_texto.setForeground(colorTexto);
				tf_texto.setText("Ahora soy de color " + colorSelec);
			}
			
		});
		
		
		btnCambiarColor.setBounds(238, 105, 151, 23);
		frame.getContentPane().add(btnCambiarColor);
		

	}
}
