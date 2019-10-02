package View.Autor;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controllers.AuthorsController;
import UTIL.Global;
import View.Livro.AddLivro;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class AuthorsCheckBox extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable tableAuthors;
	private JLabel lblCount;
	private JScrollPane scrollPane;
	private AuthorsController authorsController = new AuthorsController();
	private JLabel lblAutoresSelecionados;
	private JButton btnSalvar;
	private static int[] objAuthors = null;
	private DefaultTableModel modelo = new DefaultTableModel() {
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int linha, int coluna) {
			return false;
		}
	};
	private JLabel lblSelecioneOsAutores;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, int[] objAuthorsIDs) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthorsCheckBox frame = new AuthorsCheckBox();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		objAuthors = objAuthorsIDs;
	}

	/**
	 * Create the frame.
	 */
	public AuthorsCheckBox() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AuthorsCheckBox.class.getResource("/Img/books.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Autores disponíveis");
		setBounds(100, 100, 184, 145);

		Container c = getContentPane();
		getContentPane().setLayout(null);

		tableAuthors = new JTable(modelo);
		tableAuthors.setBounds(10, 94, 780, 353);
		c.add(tableAuthors);

		scrollPane = new JScrollPane(tableAuthors);

		scrollPane.setBounds(10, 91, 264, 190);
		c.add(scrollPane);
		tableAuthors.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		if(objAuthors != null) {
			lblCount = new JLabel(objAuthors.length+"");			
		}
		else
			lblCount = new JLabel("0");
		lblCount.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCount.setBounds(216, 66, 46, 14);
		getContentPane().add(lblCount);

		lblAutoresSelecionados = new JLabel("Autores selecionados:");
		lblAutoresSelecionados.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAutoresSelecionados.setBounds(74, 66, 142, 14);
		getContentPane().add(lblAutoresSelecionados);

		btnSalvar = new JButton("Salvar");

		btnSalvar.setBounds(96, 292, 89, 23);
		getContentPane().add(btnSalvar);

		lblSelecioneOsAutores = new JLabel("Selecione os autores segurando CTRL");
		lblSelecioneOsAutores.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSelecioneOsAutores.setBounds(36, 41, 226, 14);
		getContentPane().add(lblSelecioneOsAutores);

		btnVoltar = new JButton("Voltar");

		btnVoltar.setHorizontalAlignment(SwingConstants.LEFT);
		btnVoltar.setIcon(new ImageIcon(AuthorsCheckBox.class.getResource("/Img/left-arrow.png")));
		btnVoltar.setBounds(10, 11, 89, 23);
		getContentPane().add(btnVoltar);
		setSize(300, 365);
		setVisible(true);

		createTable();

		actionButtons();
		System.out.println(Global.getValume());
		if(objAuthors != null) {
			if(objAuthors.length > 0)
				selectRows(objAuthors);
		}
	}

	public void actionButtons() {

		/* AÇAÕ PARA ENVIAR OS ATORES SELECIONADOS */
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int obj[] = tableAuthors.getSelectedRows();

				if (obj.length > 0) {
					AddLivro.main(null, obj);
					dispose();
				}else
					JOptionPane.showMessageDialog(null, "Selecione pelo menos um autor", "Falha ao salvar",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		/* AÇÃO PARA ATUALIZAR OS NUMEROS NA TELA EM REAL-TIME */
		tableAuthors.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int obj[] = tableAuthors.getSelectedRows();

				lblCount.setText(String.valueOf(obj.length));
			}
		});

		/* AÇÃO PARA VOLTAR PARA TELA DE CADASTRO DE LIVRO */
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(objAuthors != null) {
					if(objAuthors.length > 0)
						AddLivro.main(null, objAuthors);
				}else
					AddLivro.main(null, null);
				dispose();
			}
		});
	}

	public void createTable() {

		modelo.addColumn("ID");
		modelo.addColumn("Nome");
		modelo.addColumn("Sobrenome");

		tableAuthors.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableAuthors.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableAuthors.getColumnModel().getColumn(2).setPreferredWidth(50);

		authorsController.createTableAuthor(modelo, " ");
	}
	
	public void selectRows(int[] obj) {
		
		for(int i=0; i < obj.length; i++) {
			tableAuthors.addRowSelectionInterval(obj[i], obj[i]);			
		}
	}
}
