package View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controllers.AuthorsController;
import DAO.*;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.*;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusca;
	private JTable table;
	private JButton btBusca;
	private JButton btnExcluir;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo = new DefaultTableModel();;
	private AuthorsController authorsController = new AuthorsController();

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
		
		btBusca = new JButton("");
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
		
		btnExcluir = new JButton("Excluir");
		
		btnExcluir.setIcon(new ImageIcon(TelaInicial.class.getResource("/Img/clear.png")));
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnExcluir.setBounds(667, 40, 103, 23);
		panel.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(TelaInicial.class.getResource("/Img/refresh.png")));
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAlterar.setBounds(568, 40, 89, 23);
		panel.add(btnAlterar);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox.setToolTipText("Selecione uma op\u00E7\u00E3o");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione uma op\u00E7\u00E3o...", "Autor", "Livro", "Editora"}));		
		comboBox.setBounds(10, 9, 201, 20);
		panel.add(comboBox);
		
		table = new JTable(modelo);
		table.setBounds(10, 94, 780, 353);
		contentPane.add(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 94, 780, 353);
		contentPane.add(scrollPane);
		
		ActionButton();
	}
	
	public void ActionButton() {
		
		/*AÇÃO PARA BUSCAR NO BANCO E MONTAR A TABELA*/		
		btBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedIndex() != 0) {
					String search = comboBox.getItemAt(comboBox.getSelectedIndex()).toString();	
					creatTable(search);
				}
				else 
					JOptionPane.showMessageDialog(null,
					        "Houve um problema ao procurar :\n\n '" + "Selecione alguma opção" + "'.", //mensagem
					        "Erro ao buscar", // titulo da janela 
					        JOptionPane.WARNING_MESSAGE);
			}
		});
		
		/*AÇÃO PARA DELETAR UM ELEMENTO SELECIONADO ESPECIFICO*/
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null,"Você tem certeza que deseja deletar?","Confirmação...",  JOptionPane.YES_NO_OPTION);
			    //verfica se a resposta é verdadeira
			    if (resposta == JOptionPane.YES_OPTION) {
			        JOptionPane.showMessageDialog(null, "Olá");
			      }
			}
		});
	}
	
	public void creatTable(String search) {
		
		if(search == "Autor") {
			modelo.addColumn("Nome");
	        modelo.addColumn("Sobrenome");
	        
	        table.getColumnModel().getColumn(0)
	        .setPreferredWidth(110);
	        table.getColumnModel().getColumn(1)
	        .setPreferredWidth(120);
	        
	        authorsController.createTableAuthor(modelo);
		}
		else if(search == "Livro") {
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
			
		}
		else {
			modelo.addColumn("Nome");
	        modelo.addColumn("URL");
	        
	        table.getColumnModel().getColumn(0)
	        .setPreferredWidth(110);
	        table.getColumnModel().getColumn(1)
	        .setPreferredWidth(120);
		}
		
	}
}
