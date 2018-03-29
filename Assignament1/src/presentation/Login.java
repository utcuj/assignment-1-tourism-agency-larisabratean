package presentation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import domain.Admin;
import domain.Agent;
import javax.swing.JPasswordField;
public class Login {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				//	window.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 534, 321);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 10);
		frame.getContentPane().add(panel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUsername.setBounds(134, 77, 78, 31);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPasswrod = new JLabel("Password:");
		lblPasswrod.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPasswrod.setBounds(134, 137, 78, 18);
		frame.getContentPane().add(lblPasswrod);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(257, 83, 86, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnSignIn = new JButton("Sign in Agent");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agent an= new Agent();
				String pass;
				try{
					String us=txtUsername.getText();
					pass=new String(passwordField.getPassword());
					an= dao.AgentDataMapper.findByGuId(us);
					
					if (an.getPassword().equals(pass))
					{
				
				
				Signinuser sn= new Signinuser(an.getId());
				sn.getFrame().setVisible(true);
				JOptionPane.showMessageDialog( null,"Logare reusita!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Nu s-a gasit agentul");
					}
			}catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null,"Nu s-a gasit agentul");
			}
			
			}
			});
		btnSignIn.setBounds(52, 197, 159, 41);
		frame.getContentPane().add(btnSignIn);
		
		JButton btnNewButton = new JButton("Sign in Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin a=new Admin();
				String pass;
				try{
					String user=txtUsername.getText();
					pass= new String(passwordField.getPassword());
				 a= dao.AdminDataMapper.findByGuId(user);
				if (a.getPassword().equals(pass)) {
					
	
				Signinadmin sn= new Signinadmin(a.getId(),a.getNume());
				sn.getFrame().setVisible(true);
				JOptionPane.showMessageDialog( null,"Logare reusita!");
				}
				else {
					JOptionPane.showMessageDialog( null,"Nu s-a gasit admin-ul");
				}
			}catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Nu s-a gasit admin-ul");
			}
			}
		

		});
		btnNewButton.setBounds(285, 197, 149, 41);
		frame.getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 155, 1, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Login System");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(142, 21, 108, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 155, 1, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(34, 155, 1, 2);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(34, 180, 434, 2);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(52, 58, 416, 2);
		frame.getContentPane().add(separator_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(257, 137, 86, 20);
		passwordField.setEchoChar('*');
		frame.getContentPane().add(passwordField);
	}
}
