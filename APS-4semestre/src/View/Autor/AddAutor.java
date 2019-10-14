package View.Autor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.AuthorsController;
import View.TelaInicial;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAutor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textLastName;
	private JButton btnVoltar, btnCadastrar;
	private AuthorsController controller = new AuthorsController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAutor frame = new AddAutor();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddAutor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddAutor.class.getResource("/Img/books.png")));
		setTitle("Adicionar um novo Autor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 43, 285, 220);
		contentPane.add(panel);
		panel.setLayout(null);

		btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setIcon(new ImageIcon(AddAutor.class.getResource("/Img/clipboard.png")));
		btnCadastrar.setBounds(105, 169, 113, 23);
		panel.add(btnCadastrar);

		JLabel lblCadastrarAutor = new JLabel("Cadastrar Autor");
		lblCadastrarAutor.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblCadastrarAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarAutor.setBounds(10, 11, 265, 30);
		panel.add(lblCadastrarAutor);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(24, 76, 46, 14);
		panel.add(lblNome);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSobrenome.setBounds(24, 101, 71, 14);
		panel.add(lblSobrenome);

		textName = new JTextField();
		textName.setFont(new Font("Arial", Font.PLAIN, 12));
		textName.setBounds(105, 73, 170, 20);
		panel.add(textName);
		textName.setColumns(10);

		textLastName = new JTextField();
		textLastName.setFont(new Font("Arial", Font.PLAIN, 12));
		textLastName.setBounds(105, 98, 170, 20);
		panel.add(textLastName);
		textLastName.setColumns(10);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setIcon(new ImageIcon(AddAutor.class.getResource("/Img/left-arrow.png")));
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);

		actionsButttons();
	}

	public void actionsButttons() {

		/* AÇÃO PARA VOLTAR NA TELA INICIAL */
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial.main(null);
				dispose();
			}
		});

		/* AÇÃO PARA CADASTRAR UM NOVO AUTOR */
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (controller.createAuthor(textName.getText(), textLastName.getText())) {

					JOptionPane.showMessageDialog(null, "Autor " + textName.getText()+ " "+ textLastName.getText() + " criado com sucesso!",
							"Nova editora", JOptionPane.INFORMATION_MESSAGE);

					textName.setText("");
					textLastName.setText("");
				}
			}
		});
	}
}
