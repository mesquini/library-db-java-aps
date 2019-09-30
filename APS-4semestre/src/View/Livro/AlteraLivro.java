package View.Livro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import View.TelaInicial;

public class AlteraLivro extends JFrame {

	private JPanel contentPane;
	private JTextField textTitle;
	private JTextField textIdAuthor;
	private JFormattedTextField textPrice;
	private JButton btnVoltar, btnAlterar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlteraLivro frame = new AlteraLivro();
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
	 * @throws ParseException 
	 */
	public AlteraLivro() throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddLivro.class.getResource("/Img/books.png")));
		setTitle("Adicionar um novo Livro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 37, 400, 208);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCadastrarLivro = new JLabel("Alterar livro");
		lblCadastrarLivro.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblCadastrarLivro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarLivro.setBounds(145, 11, 130, 35);
		panel.add(lblCadastrarLivro);

		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTitulo.setBounds(10, 60, 46, 14);
		panel.add(lblTitulo);

		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPreo.setBounds(10, 85, 46, 14);
		panel.add(lblPreo);

		JLabel lblIdDoAutor = new JLabel("ID do Autor:");
		lblIdDoAutor.setToolTipText("Separar por virgula se quiser mais autor");
		lblIdDoAutor.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIdDoAutor.setBounds(216, 85, 76, 14);
		panel.add(lblIdDoAutor);

		btnAlterar = new JButton("Alterar");

		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAlterar.setIcon(new ImageIcon(AddLivro.class.getResource("/Img/clipboard.png")));
		btnAlterar.setBounds(145, 150, 115, 23);
		panel.add(btnAlterar);

		textTitle = new JTextField();
		textTitle.setFont(new Font("Arial", Font.PLAIN, 12));
		textTitle.setColumns(10);
		textTitle.setBounds(66, 57, 312, 20);
		panel.add(textTitle);
		
		MaskFormatter price = new MaskFormatter("###,##");
		price.setPlaceholderCharacter('_');
		textPrice = new JFormattedTextField(price);
		textPrice.setFont(new Font("Arial", Font.PLAIN, 12));
		textPrice.setColumns(10);
		textPrice.setBounds(66, 82, 86, 20);
		panel.add(textPrice);

		textIdAuthor = new JTextField();
		textIdAuthor.setFont(new Font("Arial", Font.PLAIN, 12));
		textIdAuthor.setColumns(10);
		textIdAuthor.setBounds(292, 82, 86, 20);
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

		/* A��O PARA VOLTAR PARA TELA INICIAL */
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial.main(null);
				dispose();
			}
		});

		/* A��O PARA CADASTRAR UM LIVRO */
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

}
