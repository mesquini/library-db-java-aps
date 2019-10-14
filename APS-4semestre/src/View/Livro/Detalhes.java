package View.Livro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import UTIL.Global;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.Toolkit;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Detalhes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel() {
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int linha, int coluna) {
			return false;
		}
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Detalhes frame = new Detalhes();
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
	public Detalhes() {
		setResizable(false);
		setTitle("Detalhes");
		setFont(new Font("Arial", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Detalhes.class.getResource("/Img/books.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 45, 414, 205);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 12));
		lblTitulo.setBounds(10, 39, 46, 14);
		panel.add(lblTitulo);

		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setFont(new Font("Arial", Font.BOLD, 12));
		lblIsbn.setBounds(10, 11, 46, 14);
		panel.add(lblIsbn);

		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setFont(new Font("Arial", Font.BOLD, 12));
		lblPreo.setBounds(165, 11, 46, 14);
		panel.add(lblPreo);

		JLabel lblEditora = new JLabel("Editora:");
		lblEditora.setFont(new Font("Arial", Font.BOLD, 12));
		lblEditora.setBounds(10, 74, 46, 14);
		panel.add(lblEditora);

		table = new JTable(modelo);
		table.setRowSelectionAllowed(false);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(10, 100, 394, 94);
		panel.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 100, 394, 94);
		panel.add(scrollPane);

		JLabel lbISBN = new JLabel(Global.getIsbn());
		lbISBN.setFont(new Font("Arial", Font.PLAIN, 12));
		lbISBN.setBounds(66, 11, 89, 14);
		panel.add(lbISBN);

		JLabel lbTitle = new JLabel(Global.getTitle());
		lbTitle.setFont(new Font("Arial", Font.PLAIN, 12));
		lbTitle.setBounds(66, 39, 338, 14);
		panel.add(lbTitle);

		JLabel lbPrice = new JLabel(Global.getPrice());
		lbPrice.setFont(new Font("Arial", Font.PLAIN, 12));
		lbPrice.setBounds(210, 11, 89, 14);
		panel.add(lbPrice);

		JLabel lbPublisher = new JLabel(Global.getPublisher().getName());
		lbPublisher.setFont(new Font("Arial", Font.PLAIN, 12));
		lbPublisher.setBounds(66, 74, 284, 14);
		panel.add(lbPublisher);

		JButton btnVoltar = new JButton("Voltar");

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Global.limpaCampos();
				dispose();
			}
		});

		btnVoltar.setHorizontalAlignment(SwingConstants.LEFT);
		btnVoltar.setIcon(new ImageIcon(Detalhes.class.getResource("/Img/left-arrow.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);

		modelo.addColumn("Author(es)");
		table.getColumnModel().getColumn(0).setPreferredWidth(100);


		for (int i = 0; i < Global.getObjNameAuthors().length; i++) {

			modelo.addRow(new Object[] { Global.getObjNameAuthors()[i] });
		}
		table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			public void setValue(Object value) {
				setHorizontalAlignment(JLabel.CENTER);
				super.setValue(value);
			}
			
		});
	}

}