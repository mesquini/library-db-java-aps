package View.Livro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Controllers.BooksController;
import Controllers.PublishersController;
import Model.Publishers;
import UTIL.Global;
import View.TelaInicial;
import View.Autor.AuthorsCheckBox;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
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
	private JFormattedTextField textPrice, textVolume;
	private static JButton btnVoltar, btnCadastrar, btnAuthors;
	private PublishersController publishersController = new PublishersController();
	private BooksController booksController = new BooksController();
	JComboBox<Publishers> comboBoxPublisher;
	private static int[] objAuthors = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, int[] obj) {
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
		objAuthors = obj;
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

		JLabel lblIdDoAutor = new JLabel("Autor(ers):");
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

		JLabel lblVolume = new JLabel("Volume:");
		lblVolume.setFont(new Font("Arial", Font.PLAIN, 12));
		lblVolume.setBounds(299, 60, 46, 14);
		panel.add(lblVolume);

		MaskFormatter number = new MaskFormatter("###");
		textVolume = new JFormattedTextField(number);
		textVolume.setFont(new Font("Arial", Font.PLAIN, 12));
		textVolume.setBounds(346, 58, 32, 20);
		panel.add(textVolume);

		comboBoxPublisher = new JComboBox<Publishers>();
		comboBoxPublisher.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxPublisher.setBounds(66, 141, 147, 20);
		comboBoxPublisher.setModel(new DefaultComboBoxModel(publishersController.createComboBoxPublishers()));
		panel.add(comboBoxPublisher);

		if (objAuthors != null) {
			if (objAuthors.length > 0)
				btnAuthors = new JButton(objAuthors.length + " Autores");
		} else
			btnAuthors = new JButton("0 Autores");

		btnAuthors.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAuthors.setBounds(288, 140, 89, 23);
		panel.add(btnAuthors);

		btnVoltar = new JButton("Voltar");

		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setHorizontalAlignment(SwingConstants.LEFT);
		btnVoltar.setIcon(new ImageIcon(AddLivro.class.getResource("/Img/left-arrow.png")));
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);

		actionsButtons();
		getValues();
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
				// String editora =
				// comboBoxPublisher.getItemAt(comboBoxPublisher.getSelectedIndex()).toString();
				booksController.createBook(textISBN.getText(), textTitle.getText(), textPrice.getText(),
						Integer.parseInt(textVolume.getText()), "", objAuthors);
			}
		});

		/* AÇÃO PARA ABRIR LISTA DE AUTORES */
		btnAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setValues();
				if (objAuthors != null) {
					if (objAuthors.length > 0)
						AuthorsCheckBox.main(null, objAuthors);
				} else
					AuthorsCheckBox.main(null, null);
				dispose();
			}
		});
	}
	
	public void limpaCampos() {
		
	}

	public void getValues() {

		textISBN.setText(Global.getIsbn());
		if (textPrice.getText().equals("___,__")) {
			if (Global.getPrice() != null)
				textPrice.setText(Global.getPrice().toString().replace(".", ","));
		}
		textTitle.setText(Global.getTitle());
		if (textVolume.getText().equals("   ")) {
			if (Global.getValume() != null)
				textVolume.setText(Global.getValume());
		}
		comboBoxPublisher.setSelectedIndex(Global.getEditora());
	}

	public void setValues() {
		Global.setIsbn(textISBN.getText());
		Global.setTitle(textTitle.getText());
		if (!textPrice.getText().equals("___,__"))
			Global.setPrice(Double.parseDouble(textPrice.getText().replace(",", ".")));		
		Global.setValume(textVolume.getText());
		Global.setEditora(comboBoxPublisher.getSelectedIndex());
	}
}
