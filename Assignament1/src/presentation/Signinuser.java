package presentation;
import bussines.Accept;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.awt.event.ActionEvent;
import domain.Client;
import domain.Holiday;
import domain.HolidaySchedule;

import javax.swing.JTable;
public class Signinuser {

	private JFrame frame;
	private static JTextField textField;
	private JTable table,table2, table3;
	private static DefaultTableModel table_2,table_3, table_4;

	public static int idage;
	private JTextField client_id;
	private JTextField client_nume;
	private JTextField client_passport;
	private JTextField client_adresa;
	private JTextField destination;
	private JTextField hotel;
	private JTextField numar_persoane;
	private JTextField price;
	private JTextField data;
	private JTextField idclient;
	private JTextField idholiday;
	private JTextField value;
	private JTextField id_pay;
	private JTextField id_hol;

	/**
	 * Launch the application.
	 */

	
	JFrame getFrame()
	{
		return this.frame;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signinuser window = new Signinuser(idage);
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
	public Signinuser(int i) {
		this.idage=i;
		initialize(i);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int i) {
	int a= i;
		table = new JTable();
		table2 = new JTable();
		table3 = new JTable();
		frame = new JFrame();
		table_2 = new DefaultTableModel();
		table_3 = new DefaultTableModel();
		table_4 = new DefaultTableModel();
		frame.setBounds(100, 100, 888, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		  
		    table_2.addColumn("Nume");
		    table_2.addColumn("identity_number");

		    table_3.addColumn("Nume");
		    table_3.addColumn("identity_number");
		    table_3.addColumn("Passport");
		    table_3.addColumn("Adresa");
		    
		    table_4.addColumn("Destination");
		    table_4.addColumn("Hotel");
		    table_4.addColumn("Numar persoane");
		    table_4.addColumn("Id holiday");
		    JScrollPane clientsp = new JScrollPane();
		    clientsp.setBounds(10, 373, 379, 69);
		    clientsp.setViewportView(table);
		   frame.getContentPane().add(clientsp);
		    table.setModel(table_2);
		    table2.setModel(table_3);
		    table3.setModel(table_4);
		JLabel lblNewLabel = new JLabel("Choose operation for a client: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 218, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAddClient = new JButton("Add client");
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a=Integer.parseInt(client_id.getText());
					int b=Integer.parseInt(client_passport.getText());
					dao.AgentDataMapper.insert(new Client(a,client_nume.getText(),b,client_adresa.getText()));
					afisareClient(a);
				}catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
				
			}
		});
		btnAddClient.setBounds(20, 47, 108, 23);
		frame.getContentPane().add(btnAddClient);
		
		JButton btnUpdateClient = new JButton("Update client");
		btnUpdateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnUpdateClient.setBounds(20, 93, 108, 23);
		frame.getContentPane().add(btnUpdateClient);
		
		JButton btnDeleteClient = new JButton("View Clients");
		btnDeleteClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					afisareClient(a);
			}catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
				
			}
		});
		btnDeleteClient.setBounds(20, 139, 108, 23);
		frame.getContentPane().add(btnDeleteClient);
		
		JLabel modifyTrip = new JLabel("See trip for the client with the name: ");
		modifyTrip.setFont(new Font("Times New Roman", Font.BOLD, 15));
		modifyTrip.setBounds(467, 205, 304, 20);
		frame.getContentPane().add(modifyTrip);
		
		textField = new JTextField();
		textField.setBounds(757, 206, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblViewClientsWho = new JLabel("View clients who missed the final payment: ");
		lblViewClientsWho.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblViewClientsWho.setBounds(20, 329, 270, 25);
		frame.getContentPane().add(lblViewClientsWho);
		
		JButton btnNewButton = new JButton("Add Holiday");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idcl=Integer.parseInt(idclient.getText());
					int nr= Integer.parseInt(numar_persoane.getText());
					int pret_t= Integer.parseInt(price.getText());
					int idh= Integer.parseInt(idholiday.getText());
					LocalDate s= java.time.LocalDate.now();
					
			dao.AgentDataMapper.creazaComanda(idh,idcl ,a,  destination.getText(), hotel.getText(),nr,pret_t,data.getText(),s.toString());
			}catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
				
			}
		});
		btnNewButton.setBounds(422, 47, 114, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUpdateHoliday = new JButton("Update Holiday");
		btnUpdateHoliday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdateHoliday.setBounds(422, 93, 114, 23);
		frame.getContentPane().add(btnUpdateHoliday);
		
		JButton btnDeleteHoliday = new JButton("View Holiday");
		btnDeleteHoliday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					afisareHoliday(textField.getText(),a);
			}catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
				
			}
		});
		btnDeleteHoliday.setBounds(565, 386, 114, 23);
		frame.getContentPane().add(btnDeleteHoliday);
		JButton btnView = new JButton("View");
		frame.getContentPane().add(btnView);

		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					afisareComandaTabel(a);
			}catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
				
			}
		});

		
	
		btnView.setBounds(313, 331, 89, 23);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 173, 379, 54);
		scrollPane.setViewportView(table2);
		frame.getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(465, 257, 379, 97);
		scrollPane_1.setViewportView(table3);
		frame.getContentPane().add(scrollPane_1);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(145, 47, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setBounds(145, 72, 46, 14);
		frame.getContentPane().add(lblNume);
		
		JLabel lblPassport = new JLabel("Passport");
		lblPassport.setBounds(138, 97, 53, 14);
		frame.getContentPane().add(lblPassport);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setBounds(145, 122, 46, 14);
		frame.getContentPane().add(lblAdresa);
		
		client_id = new JTextField();
		client_id.setBounds(204, 47, 86, 20);
		frame.getContentPane().add(client_id);
		client_id.setColumns(10);
		
		client_nume = new JTextField();
		client_nume.setBounds(204, 69, 86, 20);
		frame.getContentPane().add(client_nume);
		client_nume.setColumns(10);
		
		client_passport = new JTextField();
		client_passport.setBounds(204, 94, 86, 20);
		frame.getContentPane().add(client_passport);
		client_passport.setColumns(10);
		
		client_adresa = new JTextField();
		client_adresa.setBounds(204, 119, 86, 20);
		frame.getContentPane().add(client_adresa);
		client_adresa.setColumns(10);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(546, 51, 68, 19);
		frame.getContentPane().add(lblDestination);
		
		JLabel lblHotel = new JLabel("Hotel");
		lblHotel.setBounds(546, 78, 60, 14);
		frame.getContentPane().add(lblHotel);
		
		destination = new JTextField();
		destination.setBounds(624, 48, 86, 20);
		frame.getContentPane().add(destination);
		destination.setColumns(10);
		
		JLabel lblNoPersons = new JLabel("No persons");
		lblNoPersons.setBounds(546, 102, 68, 14);
		frame.getContentPane().add(lblNoPersons);
		
		hotel = new JTextField();
		hotel.setBounds(624, 72, 86, 20);
		frame.getContentPane().add(hotel);
		hotel.setColumns(10);
		
		numar_persoane = new JTextField();
		numar_persoane.setBounds(624, 94, 86, 20);
		frame.getContentPane().add(numar_persoane);
		numar_persoane.setColumns(10);
		
		JLabel lblTotalPrice = new JLabel("Total price");
		lblTotalPrice.setBounds(546, 122, 60, 14);
		frame.getContentPane().add(lblTotalPrice);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(546, 143, 60, 19);
		frame.getContentPane().add(lblDate);
		
		price = new JTextField();
		price.setBounds(624, 119, 86, 20);
		frame.getContentPane().add(price);
		price.setColumns(10);
		
		data = new JTextField();
		data.setBounds(624, 140, 86, 20);
		frame.getContentPane().add(data);
		data.setColumns(10);
		
		JLabel lblNumeClient = new JLabel("Id Client");
		lblNumeClient.setBounds(546, 162, 68, 17);
		frame.getContentPane().add(lblNumeClient);
		
		idclient = new JTextField();
		idclient.setBounds(624, 159, 86, 20);
		frame.getContentPane().add(idclient);
		idclient.setColumns(10);
		
		JLabel lblIdHoliday = new JLabel("Id Holiday");
		lblIdHoliday.setBounds(546, 26, 68, 14);
		frame.getContentPane().add(lblIdHoliday);
		
		idholiday = new JTextField();
		idholiday.setBounds(624, 23, 86, 20);
		frame.getContentPane().add(idholiday);
		idholiday.setColumns(10);
		
		JLabel lblAcceptPaymentWith = new JLabel("Accept payment with value: ");
		lblAcceptPaymentWith.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAcceptPaymentWith.setBounds(10, 238, 186, 14);
		frame.getContentPane().add(lblAcceptPaymentWith);
		
		value = new JTextField();
		value.setBounds(204, 238, 86, 20);
		frame.getContentPane().add(value);
		value.setColumns(10);
		
		JLabel lblFromClientWith = new JLabel("From client with id: ");
		lblFromClientWith.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFromClientWith.setBounds(10, 272, 159, 14);
		frame.getContentPane().add(lblFromClientWith);
		
		id_pay = new JTextField();
		id_pay.setBounds(204, 270, 86, 20);
		frame.getContentPane().add(id_pay);
		id_pay.setColumns(10);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int v=Integer.parseInt(value.getText());
				int id_cl= Integer.parseInt(id_pay.getText());
				int idhold= Integer.parseInt(id_hol.getText());
				try {
					HolidaySchedule c = dao.AgentDataMapper.findByClient(id_cl);
					int p=0;
					int a= bussines.Accept.AccPayment(c.getTotal(),id_cl);
				
					if (a!=0)
					{
						p=0;
					}
					else p=1;
				dao.AgentDataMapper.updatePret(id_cl,idhold, a,p,v);
		
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnAccept.setBounds(313, 269, 89, 23);
		frame.getContentPane().add(btnAccept);
		
		JLabel lblNewLabel_1 = new JLabel("On Holiday with id: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 299, 159, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		id_hol = new JTextField();
		id_hol.setBounds(204, 301, 86, 20);
		frame.getContentPane().add(id_hol);
		id_hol.setColumns(10);
		
		
		
		
	}
		
		  public static void afisareComandaTabel(int ag) throws SQLException {
			   table_2.setRowCount(0);
			  
			    for (Object comanda : dao.AgentDataMapper.toate(ag)) {
			      String[] ob = { String.valueOf(((Client) comanda).getNume()),String.valueOf(((Client) comanda).getId())
			    		 
			          };
			      table_2.addRow(ob);
			    }
			  }	

		  public static void afisareClient(int ag) throws SQLException {
			   table_3.setRowCount(0);
			  
			    for (Object comanda : dao.AgentDataMapper.totiClienti(ag)) {
			      String[] ob = { String.valueOf(((Client) comanda).getNume()),String.valueOf(((Client) comanda).getId()),
			    		  String.valueOf(((Client) comanda).getPassport()),String.valueOf(((Client) comanda).getAdresa())
			          };
			      table_3.addRow(ob);
			    }
			  }	
		  public static void afisareHoliday(String n, int idag) throws SQLException {
			   table_4.setRowCount(0);
			
			    for (Object comanda : dao.AgentDataMapper.toateRez(textField.getText(), idag)) {
			      String[] ob = { String.valueOf(((Holiday) comanda).getDest()),String.valueOf(((Holiday) comanda).getHotel()),
			    		  String.valueOf(((Holiday) comanda).getNumber()),
			    				  String.valueOf(((Holiday) comanda).getId() )
			          };
			      table_4.addRow(ob);
			    }
			  }	
}
