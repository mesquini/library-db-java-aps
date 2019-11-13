package View.Autor;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.AuthorsController;
import Model.Authors;
import View.TelaInicial;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AlteraAutor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Authors authors = new Authors();
	private JTextField textName,textLastName;
	private JButton btnVoltar, btnAlterar ;
	private AuthorsController authorsController = new AuthorsController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Authors author) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlteraAutor frame = new AlteraAutor();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		authors = author;
	}

	/**
	 * Create the frame.
	 */
	public AlteraAutor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlteraAutor.class.getResource("/Img/books.png")));
		setTitle("Alterar Autor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 37, 340, 183);
		contentPane.add(panel);
		panel.setLayout(null);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(AlteraAutor.class.getResource("/Img/clipboard.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAlterar.setBounds(126, 149, 89, 23);
		panel.add(btnAlterar);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(41, 59, 46, 14);
		panel.add(lblNome);

		textName = new JTextField();
		textName.setFont(new Font("Arial", Font.PLAIN, 12));
		textName.setBounds(120, 56, 167, 20);
		panel.add(textName);
		textName.setColumns(10);
		textName.setText(authors.getName());

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSobrenome.setBounds(41, 100, 75, 14);
		panel.add(lblSobrenome);

		textLastName = new JTextField();
		textLastName.setFont(new Font("Arial", Font.PLAIN, 12));
		textLastName.setBounds(120, 97, 167, 20);
		panel.add(textLastName);
		textLastName.setColumns(10);
		textLastName.setText(authors.getFname());

		JLabel lblAlterarAutor = new JLabel("Alterar Autor");
		lblAlterarAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterarAutor.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblAlterarAutor.setBounds(54, 11, 233, 37);
		panel.add(lblAlterarAutor);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(AlteraAutor.class.getResource("/Img/left-arrow.png")));
		btnVoltar.setHorizontalAlignment(SwingConstants.LEFT);
		
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);
		
		actionsButtons();
	}

	public void actionsButtons() {

		/*AÇÃO PARA FAZER ALTERAÇÃO NO AUTOR*/
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				authorsController.updateAuthor(authors.getAuthor_id() ,textName.getText(), textLastName.getText());
				TelaInicial.main(null);
				dispose();
			}
		});
		
		/*AÇÃO PARA VOLTAR A TELA INICIAL*/
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial.main(null);
				dispose();
			}
		});
	}
}
