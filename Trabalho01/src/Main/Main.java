package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConnectionDB.Commands;
import DTO.BooksAuthors;
import jdk.nashorn.internal.runtime.regexp.joni.Warnings;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Main extends JFrame {

	private JPanel contentPane;
	private static JTextField txtTitle;
	private JTable table;
	static Commands c = new Commands();
	static ArrayList<BooksAuthors> booksAuthors;
	private DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
		setTitle("Biblioteca Amazonas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Entre com o nome do livro: ");
		lblTitle.setBounds(10, 11, 158, 14);
		contentPane.add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(178, 8, 271, 20);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pesquisar(modelo);
				txtTitle.setText(null);
				
					
			}
		});
		btnNewButton.setMnemonic('s');
		btnNewButton.setToolTipText("Pesquisar livro");
		btnNewButton.setBounds(459, 5, 31, 23);
		contentPane.add(btnNewButton);
		
		
		table = new JTable(modelo);
		
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
        .setPreferredWidth(30);
        
		table.setBounds(10, 36, 480, 246);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 36, 592, 243);
		contentPane.add(scrollPane);
	}

	public static void pesquisar(DefaultTableModel modelo) {
        modelo.setNumRows(0);
        
        booksAuthors = new ArrayList<BooksAuthors>();
		booksAuthors = c.searchBooksAuthors(txtTitle.getText());
		
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
