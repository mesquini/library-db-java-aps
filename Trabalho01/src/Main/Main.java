package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConnectionDB.Commands;
import Model.BooksAuthors;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private static JTextField txtTitle;
	private JTable table;
	static Commands c = new Commands();
	static ArrayList<BooksAuthors> booksAuthors;
	JButton btnSearch;
	private DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setLocationRelativeTo(null);
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
	public Main() {
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Biblioteca Amazonas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Img/books.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Entre com o nome do livro: ");
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTitle.setBounds(20, 11, 158, 14);
		contentPane.add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(178, 8, 271, 20);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		btnSearch = new JButton("");
		
		btnSearch.setMnemonic('s');
		btnSearch.setToolTipText("Pesquisar livro");
		btnSearch.setBounds(459, 5, 31, 23);
		contentPane.add(btnSearch);
		
		
		table = new JTable(modelo);
		table.setBounds(10, 36, 480, 246);
		contentPane.add(table);
		
		modelo.addColumn("Titulo");
        modelo.addColumn("Autor(es)");
        modelo.addColumn("Editora(s)");
        modelo.addColumn("Preço");
        
        table.getColumnModel().getColumn(0)
        .setPreferredWidth(110);
        table.getColumnModel().getColumn(1)
        .setPreferredWidth(120);
        table.getColumnModel().getColumn(2)
        .setPreferredWidth(50);
        table.getColumnModel().getColumn(3)
        .setPreferredWidth(10);
        
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 36, 602, 256);
		contentPane.add(scrollPane);
		
		actionButtons();
	}
	
	public void actionButtons() {
		
		/*AÇAÕ PARA BUSCAR OS LIVROS*/
		btnSearch.setIcon(new ImageIcon(Main.class.getResource("/Img/search.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pesquisar(modelo);
				txtTitle.setText(null);
				
					
			}
		});
	}

	public static void pesquisar(DefaultTableModel modelo) {
        modelo.setNumRows(0);
        
        booksAuthors = new ArrayList<BooksAuthors>();
		booksAuthors = c.searchBooksAuthors(txtTitle.getText().trim());
		
		for(BooksAuthors ba : booksAuthors) {
			modelo.addRow(new Object[] {
					ba.getTitle(),
					ba.getFname(),
					ba.getPublicherName(),
					ba.getPrice()
			});
		}
        
    }
}
