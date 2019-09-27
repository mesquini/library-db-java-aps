package View.Livro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import View.TelaInicial;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;

public class AddLivro extends JFrame {

	private JPanel contentPane;
	private JTextField textISBN;
	private JTextField textTitle;
	private JTextField textPrice;
	private JTextField textIdPublisher;
	private JTextField textIdAuthor;
	private JButton btnVoltar, btnCadastrar;
	
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
	 */
	public AddLivro() {
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
		lblTitulo.setBounds(10, 85, 46, 14);
		panel.add(lblTitulo);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPreo.setBounds(235, 57, 46, 14);
		panel.add(lblPreo);
		
		JLabel lblIdDaEditora = new JLabel("ID da Editora:");
		lblIdDaEditora.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIdDaEditora.setBounds(10, 110, 76, 14);
		panel.add(lblIdDaEditora);
		
		JLabel lblIdDoAutor = new JLabel("ID do Autor:");
		lblIdDoAutor.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIdDoAutor.setBounds(216, 110, 76, 14);
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
		textTitle.setBounds(66, 82, 312, 20);
		panel.add(textTitle);
		
		textPrice = new JTextField();
		textPrice.setFont(new Font("Arial", Font.PLAIN, 12));
		textPrice.setColumns(10);
		textPrice.setBounds(292, 57, 86, 20);
		panel.add(textPrice);
		
		textIdPublisher = new JTextField();
		textIdPublisher.setFont(new Font("Arial", Font.PLAIN, 12));
		textIdPublisher.setColumns(10);
		textIdPublisher.setBounds(96, 107, 86, 20);
		panel.add(textIdPublisher);
		
		textIdAuthor = new JTextField();
		textIdAuthor.setFont(new Font("Arial", Font.PLAIN, 12));
		textIdAuthor.setColumns(10);
		textIdAuthor.setBounds(292, 107, 86, 20);
		panel.add(textIdAuthor);
		
		btnVoltar = new JButton("Voltar");
		
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setHorizontalAlignment(SwingConstants.LEFT);
		btnVoltar.setIcon(new ImageIcon(AddLivro.class.getResource("/Img/left-arrow.png")));
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);
		
		actionsButtons();
	}
	
	public void actionsButtons() {
		
		/*AÇÃO PARA VOLTAR PARA TELA INICIAL*/
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial.main(null);
				dispose();
			}
		});
		
		/*AÇÃO PARA CADASTRAR UM LIVRO*/
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	

}
