package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusca;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
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
		
		JButton btBusca = new JButton("");
		btBusca.setIcon(new ImageIcon(TelaInicial.class.getResource("/Img/search.png")));
		btBusca.setBounds(743, 6, 27, 23);
		panel.add(btBusca);
		
		txtBusca = new JTextField();
		txtBusca.setBounds(362, 6, 366, 23);
		panel.add(txtBusca);
		txtBusca.setColumns(10);
		
		JLabel lblInsiraUmNome = new JLabel("Insira um nome:");
		lblInsiraUmNome.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblInsiraUmNome.setBounds(221, 6, 179, 23);
		panel.add(lblInsiraUmNome);
		
		JRadioButton rdbtnAutor = new JRadioButton("Autor");
		rdbtnAutor.setSelected(true);
		rdbtnAutor.setBackground(Color.LIGHT_GRAY);
		rdbtnAutor.setBounds(10, 7, 60, 23);
		panel.add(rdbtnAutor);
		
		JRadioButton rdbtnLivro = new JRadioButton("Livro");
		rdbtnLivro.setBackground(Color.LIGHT_GRAY);
		rdbtnLivro.setBounds(72, 7, 60, 23);
		panel.add(rdbtnLivro);
		
		JRadioButton rdbtnEditora = new JRadioButton("Editora");
		rdbtnEditora.setBackground(Color.LIGHT_GRAY);
		rdbtnEditora.setBounds(134, 7, 81, 23);
		panel.add(rdbtnEditora);
		
		JButton btnAdicionarLivro = new JButton("Livro");
		btnAdicionarLivro.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAdicionarLivro.setIcon(new ImageIcon(TelaInicial.class.getResource("/Img/add.png")));
		btnAdicionarLivro.setToolTipText("Adicionar Livro");
		btnAdicionarLivro.setBounds(10, 37, 94, 23);
		panel.add(btnAdicionarLivro);
		
		JButton btnAdicionarEditora = new JButton("Editora");
		btnAdicionarEditora.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAdicionarEditora.setToolTipText("Adicionar Editora");
		btnAdicionarEditora.setIcon(new ImageIcon(TelaInicial.class.getResource("/Img/add.png")));
		btnAdicionarEditora.setBounds(114, 37, 103, 23);
		panel.add(btnAdicionarEditora);
		
		JButton btnAdicionarAutor = new JButton("Autor");
		btnAdicionarAutor.setToolTipText("Adicionar Autor");
		btnAdicionarAutor.setIcon(new ImageIcon(TelaInicial.class.getResource("/Img/add.png")));
		btnAdicionarAutor.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAdicionarAutor.setBounds(231, 37, 94, 23);
		panel.add(btnAdicionarAutor);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(TelaInicial.class.getResource("/Img/clear.png")));
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnExcluir.setBounds(667, 40, 103, 23);
		panel.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(TelaInicial.class.getResource("/Img/refresh.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAlterar.setBounds(568, 40, 89, 23);
		panel.add(btnAlterar);
		
		table = new JTable();
		table.setBounds(10, 94, 780, 353);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 94, 780, 353);
		contentPane.add(scrollPane);
	}
}
