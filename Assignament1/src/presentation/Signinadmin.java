package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bussines.GenerateReports;
import domain.Client;
import domain.HolidaySchedule;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import domain.Agent;
import javax.swing.JTextField;
public class Signinadmin {
	private static int id;
	private static String nume_ad;
	private JFrame frame;
	private JTable table,table1;
	private static DefaultTableModel table_2,table_3;
	private JTextField textField;
	private static JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signinadmin window = new Signinadmin(id,nume_ad);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Signinadmin(int ii,String n) {
		initialize(ii,n);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize(int a,String n) {
		frame = new JFrame();
		this.id=a;
		this.nume_ad=n;
		table = new JTable();
		table1 = new JTable();
		table_2 = new DefaultTableModel();
		table_3 = new DefaultTableModel();
		frame.setBounds(100, 100, 739, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    
		table_2.addColumn("Id Holiday");
	    table_2.addColumn("Id Client");
	    table_2.addColumn("Price");
	    table_2.addColumn("Paid");
	    JScrollPane clientsp = new JScrollPane();
	    clientsp.setBounds(20, 373, 379, 69);
	    clientsp.setViewportView(table);
	    frame.getContentPane().add(clientsp);
	    table.setModel(table_2);
	    
		table_3.addColumn("Id agent");
	    table_3.addColumn("Nume");
	    table_3.addColumn("Adresa");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(313, 57, 379, 97);
		 scrollPane.setViewportView(table1);
		frame.getContentPane().add(scrollPane);
		  table1.setModel(table_3);
	    
	    
		JLabel lblChooseTheOperation = new JLabel("Choose the operation you want to make:");
		lblChooseTheOperation.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblChooseTheOperation.setBounds(20, 37, 226, 37);
		frame.getContentPane().add(lblChooseTheOperation);
		
		JComboBox comboBox = new JComboBox();
		
		
		comboBox.setMaximumRowCount(12);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setSelectedIndex(0);
		comboBox.setToolTipText("");
		comboBox.setBounds(252, 288, 99, 17);
		JLabel lblHello = new JLabel("Hello,");
		lblHello.setBounds(52, 12, 46, 14);
		frame.getContentPane().add(lblHello);
		
		JButton btnAddAgent = new JButton("Add agent");
		btnAddAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddAgent.setBounds(20, 128, 148, 23);
		frame.getContentPane().add(btnAddAgent);
		
		JButton btnGenerateReports = new JButton("Generate reports");
	
				
					comboBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btnGenerateReports.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
							  String s= (String)comboBox.getSelectedItem();
							  GenerateReports gen= new GenerateReports(s);
							 int k= gen.getMonth(s);
;								try {
									
									afisareAgenti(k);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						}
					});
				
			
			}
		});
		btnGenerateReports.setBounds(21, 339, 169, 23);
		frame.getContentPane().add(btnGenerateReports);
		
		JLabel lblGenerateReportsFor = new JLabel("Generate reports for month:");
		lblGenerateReportsFor.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblGenerateReportsFor.setBounds(20, 289, 211, 14);
		frame.getContentPane().add(lblGenerateReportsFor);
	
		frame.getContentPane().add(comboBox);

		JLabel lblDeleteTheAgent = new JLabel("Delete the agent with id: ");
		lblDeleteTheAgent.setBounds(38, 177, 208, 14);
		frame.getContentPane().add(lblDeleteTheAgent);
		
		textField = new JTextField();
		textField.setBounds(48, 202, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	
		JButton btnDeleteAgent = new JButton("Delete Agent");
		btnDeleteAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao.AdminDataMapper.deleteAgent(Integer.parseInt(textField.getText()));
			}
		});
		btnDeleteAgent.setBounds(20, 85, 148, 23);
		frame.getContentPane().add(btnDeleteAgent);
		
		JButton btnUpdateClient = new JButton("Update Agent");
		btnUpdateClient.setBounds(178, 85, 121, 23);
		frame.getContentPane().add(btnUpdateClient);
		
		JButton btnDeleteClient = new JButton("View Agents");
		btnDeleteClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					afisareComandaTabel();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDeleteClient.setBounds(188, 128, 121, 23);
		frame.getContentPane().add(btnDeleteClient);
		
		JLabel lblAndForThe = new JLabel("and for the agent with id:");
		lblAndForThe.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAndForThe.setBounds(30, 314, 138, 14);
		frame.getContentPane().add(lblAndForThe);
		
		textField_1 = new JTextField();
		textField_1.setBounds(252, 316, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(nume_ad);
		lblNewLabel.setBounds(85, 12, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
	}
	  public static void afisareAgenti(int s) throws SQLException {
		   table_2.setRowCount(0);
		  
		    for (Object comanda : dao.AdminDataMapper.generateReports(Integer.parseInt(textField_1.getText()),s)) {
		      String[] ob = { String.valueOf(((HolidaySchedule) comanda).getIdHoliday()),String.valueOf(((HolidaySchedule) comanda).getIdClient()),
		    		  String.valueOf(((HolidaySchedule) comanda).getTotal()),
		    		  String.valueOf(((HolidaySchedule) comanda).getPaid())
		    		 
		          };
		      table_2.addRow(ob);
		    }
		  }	
	  public static void afisareComandaTabel() throws SQLException {
		   table_3.setRowCount(0);
		  
		    for (Object comanda : dao.AdminDataMapper.toate(id)) {
		      String[] ob = { String.valueOf(((Agent) comanda).getId()),String.valueOf(((Agent) comanda).getNume()),
		    		  String.valueOf(((Agent) comanda).getAdresa())
		    		 
		          };
		      table_3.addRow(ob);
		    }
		  }	
	public JFrame getFrame()
	{
		return this.frame;
	}
}
