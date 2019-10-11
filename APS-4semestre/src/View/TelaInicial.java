package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controllers.AuthorsController;
import Controllers.BooksAuthorsController;
import Controllers.BooksController;
import Controllers.PublishersController;
import UTIL.Global;
import View.Editora.*;
import View.Livro.*;
import View.Autor.*;

import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBusca;
	private JTable table;
	private JButton btBusca, btnExcluir, btnAdicionarAutor, btnAdicionarLivro, btnAdicionarEditora, btnAlterar;
	private JComboBox<?> comboBox;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo = new DefaultTableModel() {
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int linha, int coluna) {
			return false;
		}
	};
	private AuthorsController authorsController = new AuthorsController();
	private static BooksController booksController = new BooksController();
	private PublishersController publishersController = new PublishersController();
	private BooksAuthorsController booksAuthorsController = new BooksAuthorsController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TelaInicial() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/Img/books.png")));
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Livraria Amaz\u00F4nia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 780, 72);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);

		btBusca = new JButton("");
		btBusca.setIcon(new ImageIcon(TelaInicial.class.getResource("/Img/search.png")));
		btBusca.setBounds(743, 6, 27, 23);
		panel.add(btBusca);

		txtBusca = new JTextField();
		txtBusca.setFont(new Font("Arial", Font.PLAIN, 12));
		txtBusca.setBounds(362, 6, 366, 23);
		panel.add(txtBusca);
		txtBusca.setColumns(10);

		JLabel lblInsiraUmNome = new JLabel("Insira um nome:");
		lblInsiraUmNome.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblInsiraUmNome.setBounds(221, 6, 179, 23);
		panel.add(lblInsiraUmNome);

		btnAdicionarLivro = new JButton("Livro");

		btnAdicionarLivro.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAdicionarLivro.setIcon(new ImageIcon(TelaInicial.class.getResource("/Img/add.png")));
		btnAdicionarLivro.setToolTipText("Adicionar Livro");
		btnAdicionarLivro.setBounds(10, 37, 94, 23);
		panel.add(btnAdicionarLivro);

		btnAdicionarEditora = new JButton("Editora");

		btnAdicionarEditora.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAdicionarEditora.setToolTipText("Adicionar Editora");
		btnAdicionarEditora.setIcon(new ImageIcon(TelaInicial.class.getResource("/Img/add.png")));
		btnAdicionarEditora.setBounds(114, 37, 103, 23);
		panel.add(btnAdicionarEditora);

		btnAdicionarAutor = new JButton("Autor");

		btnAdicionarAutor.setToolTipText("Adicionar Autor");
		btnAdicionarAutor.setIcon(new ImageIcon(TelaInicial.class.getResource("/Img/add.png")));
		btnAdicionarAutor.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAdicionarAutor.setBounds(231, 37, 94, 23);
		panel.add(btnAdicionarAutor);

		btnExcluir = new JButton("Excluir");

		btnExcluir.setIcon(new ImageIcon(TelaInicial.class.getResource("/Img/clear.png")));
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnExcluir.setBounds(667, 40, 103, 23);
		panel.add(btnExcluir);

		btnAlterar = new JButton("Alterar");

		btnAlterar.setIcon(new ImageIcon(TelaInicial.class.getResource("/Img/refresh.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAlterar.setBounds(568, 40, 89, 23);
		panel.add(btnAlterar);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox.setToolTipText("Selecione uma op\u00E7\u00E3o");
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Selecione uma opção...", "Autor", "Livro", "Editora" }));

		comboBox.setBounds(10, 9, 201, 20);
		panel.add(comboBox);

		btnDetalhes = new JButton("Detalhe");
		btnDetalhes.setVisible(false);

		btnDetalhes.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDetalhes.setBounds(469, 40, 89, 23);
		panel.add(btnDetalhes);

		table = new JTable(modelo);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(10, 94, 780, 353);
		contentPane.add(table);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 94, 780, 353);
		contentPane.add(scrollPane);

		if (Global.getSearchTelaInicial() > 0) {

			comboBox.setSelectedIndex(Global.getSearchTelaInicial());
			search = comboBox.getItemAt(Global.getSearchTelaInicial()).toString();
			creatTable();
		}

		ActionButton();
	}

	private static String search = null;
	private JButton btnDetalhes;

	// FUNÇÃO COM AS AÇÕES DOS BOTÕES
	public void ActionButton() {

		/* AÇÃO PARA BUSCAR NO BANCO E MONTAR A TABELA */
		btBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedIndex() != 0) {
					Global.setSearchTelaInicial(comboBox.getSelectedIndex());
					search = comboBox.getItemAt(Global.getSearchTelaInicial()).toString();
					creatTable();

					txtBusca.setText("");
				} else
					JOptionPane.showMessageDialog(null,
							"Houve um problema ao procurar :\n\n '" + "Selecione alguma opção" + "'.", // mensagem
							"Erro ao buscar", // titulo da janela
							JOptionPane.WARNING_MESSAGE);
			}
		});

		/* AÇÃO PARA DELETAR UM ELEMENTO SELECIONADO */
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int linhaSelecionada = table.getSelectedRow();

				if (table.getSelectedColumn() >= 0) {

					int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar?",
							"Confirmação...", JOptionPane.YES_NO_OPTION);
					// verfica se a resposta é verdadeira
					if (resposta == JOptionPane.YES_OPTION) {

						if (search.equals("Autor")) {
							authorsController.deleteAuthor(linhaSelecionada);
						} else if (search.equals("Livro")) {
							booksController.deleteBook(linhaSelecionada);
						} else {
							publishersController.deletePublisher(linhaSelecionada);
						}

						modelo.removeRow(table.getSelectedRow());
						JOptionPane.showMessageDialog(null, "Excluido com sucesso.");
					}
				} else
					JOptionPane.showMessageDialog(null, "Selecione uma linha para deletar.", "Aviso",
							JOptionPane.OK_OPTION);
			}
		});

		/* AÇÃO PARA ABRIR JANELA DE EDIÇÃO */
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int linhaSelecionada = table.getSelectedRow();

				if (table.getSelectedColumn() >= 0) {

					if (search.equals("Autor")) {

						AlteraAutor.main(null, authorsController.searchIdAuthor(linhaSelecionada));
						dispose();
					} else if (search.equals("Livro")) {
						booksController.searchIdBook(linhaSelecionada);
						AlteraLivro.main(null);
						dispose();
					} else {
						publishersController.searchID(linhaSelecionada);
						AlteraEditora.main(null);
						dispose();
					}

				} else
					JOptionPane.showMessageDialog(null, "Selecione uma linha para editar.", "Aviso",
							JOptionPane.WARNING_MESSAGE);

			}
		});

		/* AÇÃO PARA ADICIONAR UM NOVO AUTOR */
		btnAdicionarAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAutor.main(null);
				dispose();
			}
		});

		/* AÇÃO PARA ADICIONAR UMA NOVA EDITORA */
		btnAdicionarEditora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEditora.main(null);
				dispose();
			}
		});

		/* AÇÃO PARA ADICIONAR UM NOVO LIVRO */
		btnAdicionarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLivro.main(null, null);
				dispose();

			}
		});

		/* AÇÃO PARA VER DETALHES DO LIVRO */
		btnDetalhes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = table.getSelectedRow();
				
				if (table.getSelectedColumn() >= 0) {
					booksController.searchIdBook(linhaSelecionada);
					Detalhes.main(null);
				} else
					JOptionPane.showMessageDialog(null, "Selecione um livro para ver os detalhes", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	// FUNÇÃO PARA CRIAR AS TABELAS, DEPENDENDO DO TIPO QUE O USUARIO ESCOLHER NO
	// COMBOBOX
	public void creatTable() {
		btnDetalhes.setVisible(false);
		if (search == "Autor") {

			cleanTable();

			if (modelo.getColumnCount() == 0) {

				modelo.addColumn("Nome");
				modelo.addColumn("Sobrenome");

				table.getColumnModel().getColumn(0).setPreferredWidth(100);
				table.getColumnModel().getColumn(1).setPreferredWidth(100);
			}

			authorsController.createTableAuthor(modelo, txtBusca.getText());

		} else if (search == "Livro") {
			cleanTable();
			btnDetalhes.setVisible(true);

			if (modelo.getColumnCount() == 0) {

				modelo.addColumn("Titulo");
				modelo.addColumn("Autor(es)");
				modelo.addColumn("Editora(s)");
				modelo.addColumn("Preço");

				table.getColumnModel().getColumn(0).setPreferredWidth(120);
				table.getColumnModel().getColumn(1).setPreferredWidth(50);
				table.getColumnModel().getColumn(2).setPreferredWidth(50);
				table.getColumnModel().getColumn(3).setPreferredWidth(10);
			}

			booksAuthorsController.createTableBooks(modelo, txtBusca.getText());

		} else {
			cleanTable();

			if (modelo.getColumnCount() == 0) {

				modelo.addColumn("Nome");
				modelo.addColumn("URL");

				table.getColumnModel().getColumn(0).setPreferredWidth(120);
				table.getColumnModel().getColumn(1).setPreferredWidth(100);
			}

			publishersController.createTablePublisher(modelo, txtBusca.getText());
		}

	}

	// FUNÇÃO PARA LIMPAR AS LINHAS DA TABELA
	public void cleanTable() {
		while (modelo.getRowCount() > 0 && modelo.getColumnCount() > 0) {

			table.setModel(modelo = new DefaultTableModel());
		}
	}

}
