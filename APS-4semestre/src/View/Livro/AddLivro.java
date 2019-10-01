package View.Livro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Controllers.PublishersController;
import View.TelaInicial;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class AddLivro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textISBN;
	private JTextField textTitle;
	private JFormattedTextField textPrice;
	private JTextField textIdAuthor;
	private JButton btnVoltar, btnCadastrar;
	private PublishersController publishersController = new PublishersController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLivro frame = new AddLivro();
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
	 * 
	 * @throws ParseException
	 */
	public AddLivro() throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddLivro.class.getResource("/Img/books.png")));
		setTitle("Adicionar um novo Livro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 37, 400, 237);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCadastrarLivro = new JLabel("Cadastrar livro");
		lblCadastrarLivro.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblCadastrarLivro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarLivro.setBounds(145, 11, 130, 35);
		panel.add(lblCadastrarLivro);

		JLabel lblIsbn = new JLabel("isbn:");
		lblIsbn.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIsbn.setBounds(10, 60, 46, 14);
		panel.add(lblIsbn);

		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTitulo.setBounds(10, 103, 46, 14);
		panel.add(lblTitulo);

		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPreo.setBounds(162, 60, 46, 14);
		panel.add(lblPreo);

		JLabel lblIdDaEditora = new JLabel("Editora:");
		lblIdDaEditora.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIdDaEditora.setBounds(10, 143, 76, 14);
		panel.add(lblIdDaEditora);

		JLabel lblIdDoAutor = new JLabel("ID do Autor:");
		lblIdDoAutor.setToolTipText("Separar por virgula se quiser mais autor");
		lblIdDoAutor.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIdDoAutor.setBounds(223, 143, 76, 14);
		panel.add(lblIdDoAutor);

		btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setIcon(new ImageIcon(AddLivro.class.getResource("/Img/clipboard.png")));
		btnCadastrar.setBounds(145, 203, 115, 23);
		panel.add(btnCadastrar);

		textISBN = new JTextField();
		textISBN.setFont(new Font("Arial", Font.PLAIN, 12));
		textISBN.setBounds(66, 57, 86, 20);
		panel.add(textISBN);
		textISBN.setColumns(10);

		textTitle = new JTextField();
		textTitle.setFont(new Font("Arial", Font.PLAIN, 12));
		textTitle.setColumns(10);
		textTitle.setBounds(66, 97, 312, 20);
		panel.add(textTitle);

		MaskFormatter price = new MaskFormatter("###,##");
		price.setPlaceholderCharacter('_');
		textPrice = new JFormattedTextField(price);
		textPrice.setText("");
		textPrice.setFont(new Font("Arial", Font.PLAIN, 12));
		textPrice.setColumns(10);
		textPrice.setBounds(203, 57, 86, 20);
		panel.add(textPrice);

		textIdAuthor = new JTextField();
		textIdAuthor.setFont(new Font("Arial", Font.PLAIN, 12));
		textIdAuthor.setColumns(10);
		textIdAuthor.setBounds(292, 140, 86, 20);
		panel.add(textIdAuthor);

		JLabel lblVolume = new JLabel("Volume:");
		lblVolume.setFont(new Font("Arial", Font.PLAIN, 12));
		lblVolume.setBounds(299, 60, 46, 14);
		panel.add(lblVolume);

		MaskFormatter number = new MaskFormatter("###");
		number.setPlaceholderCharacter('_');
		JFormattedTextField formattedTextField = new JFormattedTextField(number);
		formattedTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		formattedTextField.setBounds(346, 58, 32, 20);
		panel.add(formattedTextField);
		
		JComboBox comboBoxPublisher = new JComboBox();
		comboBoxPublisher.setBounds(66, 141, 147, 20);
		comboBoxPublisher.setModel(new DefaultComboBoxModel(publishersController.createComboBoxPublishers()));
		panel.add(comboBoxPublisher);

		btnVoltar = new JButton("Voltar");

		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setHorizontalAlignment(SwingConstants.LEFT);
		btnVoltar.setIcon(new ImageIcon(AddLivro.class.getResource("/Img/left-arrow.png")));
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);

		actionsButtons();
	}

	public void actionsButtons() {

		/* AÇÃO PARA VOLTAR PARA TELA INICIAL */
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial.main(null);
				dispose();
			}
		});

		/* AÇÃO PARA CADASTRAR UM LIVRO */
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
