package View.Editora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.PublishersController;
import View.TelaInicial;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEditora extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField textURL;
	private JButton btnVoltar, btnCadastrar;
	private PublishersController controller = new PublishersController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEditora frame = new AddEditora();
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
	public AddEditora() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddEditora.class.getResource("/Img/books.png")));
		setTitle("Adicionar uma nova Editora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(30, 97, 46, 14);
		contentPane.add(lblNome);

		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUrl.setBounds(30, 133, 46, 14);
		contentPane.add(lblUrl);

		txtName = new JTextField();
		txtName.setFont(new Font("Arial", Font.PLAIN, 12));
		txtName.setBounds(86, 94, 168, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		textURL = new JTextField();
		textURL.setFont(new Font("Arial", Font.PLAIN, 12));
		textURL.setColumns(10);
		textURL.setBounds(86, 130, 168, 20);
		contentPane.add(textURL);

		btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.setIcon(new ImageIcon(AddEditora.class.getResource("/Img/clipboard.png")));
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCadastrar.setBounds(115, 191, 107, 23);
		contentPane.add(btnCadastrar);

		JLabel lblCadastrarEditora = new JLabel("Cadastrar Editora");
		lblCadastrarEditora.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblCadastrarEditora.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarEditora.setBounds(86, 45, 168, 29);
		contentPane.add(lblCadastrarEditora);

		btnVoltar = new JButton("Voltar");

		btnVoltar.setIcon(new ImageIcon(AddEditora.class.getResource("/Img/left-arrow.png")));
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 40, 286, 216);
		contentPane.add(panel);

		actionButtons();
	}

	public void actionButtons() {

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial.main(null);
				dispose();
			}
		});

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(controller.createPublisher(txtName.getText(), textURL.getText())) {
					
					JOptionPane.showMessageDialog(null, "Editora " + txtName.getText() + " criada com sucesso!",
							"Nova editora", JOptionPane.INFORMATION_MESSAGE);
					
					txtName.setText("");
					textURL.setText("");
				}


			}
		});
	}

}
