package View.Editora;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.PublishersController;
import Model.Publishers;
import UTIL.Global;
import View.TelaInicial;
import javafx.scene.text.TextBoundsType;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlteraEditora extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static PublishersController publishersController = new PublishersController();
	private static Publishers publishers = new Publishers();
	
	private JPanel contentPane;
	private static JTextField textName, textURL;
	private JButton btnVoltar, btnAlterar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlteraEditora frame = new AlteraEditora();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		publishers = Global.getPublisher();
	}

	/**
	 * Create the frame.
	 */
	public AlteraEditora() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlteraEditora.class.getResource("/Img/books.png")));
		setFont(new Font("Arial", Font.PLAIN, 13));
		setTitle("Alterar Editora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 41, 318, 193);
		contentPane.add(panel);
		panel.setLayout(null);

		btnAlterar = new JButton("Alterar");
		
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAlterar.setIcon(new ImageIcon(AlteraEditora.class.getResource("/Img/clipboard.png")));
		btnAlterar.setBounds(118, 164, 89, 23);
		panel.add(btnAlterar);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(10, 67, 46, 14);
		panel.add(lblNome);

		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUrl.setBounds(10, 92, 46, 14);
		panel.add(lblUrl);

		textName = new JTextField();
		textName.setFont(new Font("Arial", Font.PLAIN, 12));
		textName.setBounds(79, 64, 192, 20);
		panel.add(textName);
		textName.setColumns(10);
		textName.setText(publishers.getName().trim());

		textURL = new JTextField();
		textURL.setFont(new Font("Arial", Font.PLAIN, 12));
		textURL.setBounds(79, 89, 192, 20);
		panel.add(textURL);
		textURL.setColumns(10);
		textURL.setText(publishers.getUrl().trim());
		
		JLabel lblAlterarEditora = new JLabel("Alterar Editora");
		lblAlterarEditora.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblAlterarEditora.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterarEditora.setBounds(10, 11, 294, 32);
		panel.add(lblAlterarEditora);

		btnVoltar = new JButton("Voltar");
		
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setHorizontalAlignment(SwingConstants.LEFT);
		btnVoltar.setIcon(new ImageIcon(AlteraEditora.class.getResource("/Img/left-arrow.png")));
		btnVoltar.setBounds(10, 7, 89, 23);
		contentPane.add(btnVoltar);

		actionsButtons();
	}

	public void actionsButtons() {

		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				publishersController.updatePublisher(publishers.getPublisher_id(), textName.getText(), textURL.getText());
				TelaInicial.main(null);
				dispose();
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial.main(null);
				dispose();
			}
		});
	}

}
