package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionDatabase;
import domain.Agent;
import domain.Client;
import domain.Holiday;
import domain.HolidaySchedule;
public class AgentDataMapper {
	public static synchronized Agent findByGuId(String nume) throws SQLException {
		Agent adm=new Agent();
		try {
			Connection db = ConnectionDatabase.getConnection();
	
			String statement = "SELECT nume, password,idagent  FROM agent where nume= ?";
			PreparedStatement dbStatement = db.prepareStatement(statement);
			dbStatement.setString(1, nume);
			ResultSet rs = dbStatement.executeQuery();
			
			while(rs.next()) {
				
				String name = rs.getString("nume");
				String pass = rs.getString("password");
				int id = rs.getInt("idagent");
				adm = new Agent(id,name,pass);
				return adm;
			}
			return adm;
		} catch (SQLException e) {
		
			throw new SQLException("Error occured reading agent from the data source.", e);
		}
	}
	
	public static void updatePret(int id,int ih, int cant, int p, int part)
	{
		Connection dbConnection = ConnectionDatabase.getConnection();
		PreparedStatement updateStatement = null;
		
	    String sql = "UPDATE holiday_schedule SET total_price=" +cant+ ", paid="+p+",partial="+part+"  where id_client=" + id+" and id_holiday="+ih;
		try
		{
			updateStatement=dbConnection.prepareStatement(sql);
	        updateStatement.executeUpdate();
	    	JOptionPane.showMessageDialog(null, "Update reusit!");

	     
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "eroare update client "+e);
		} finally {
			ConnectionDatabase.close(updateStatement);
			ConnectionDatabase.close(dbConnection);
		}
	}

	public static synchronized HolidaySchedule findByClient(int id_client) throws SQLException {
		HolidaySchedule adm=new HolidaySchedule();
		try {
			Connection db = ConnectionDatabase.getConnection();


			String statement = "SELECT id_client, id_holiday, total_price, final_payment, paid,idagent,partial,time_tranzaction  FROM holiday_schedule where id_client= ?";
			PreparedStatement dbStatement = db.prepareStatement(statement);
			dbStatement.setInt(1, id_client);
			ResultSet rs = dbStatement.executeQuery();
			
			while(rs.next()) {
				int ic = rs.getInt("id_client");
				int ih = rs.getInt("id_holiday");
				int total = rs.getInt("total_price");
				String final_p = rs.getString("final_payment");
				String time_tr= rs.getString("time_tranzaction");
				int paid = rs.getInt("paid");
				
				int ia = rs.getInt("idagent");
				int part = rs.getInt("partial");
				adm =new HolidaySchedule(ic,ih,total,final_p,paid,ia,part,time_tr);
				return adm;
			}
			return adm;
		} catch (SQLException e) {
		
			throw new SQLException("Error occured reading agent from the data source.", e);
		}
	}
	public static List<Holiday> toateRez(String nume, int ag) throws SQLException {
		Connection dbConnection = ConnectionDatabase.getConnection();

		String statement = "select distinct(holiday.destination), holiday.hotel, holiday.number_persons,holiday.idholiday from holiday join holiday_schedule on holiday.idholiday=holiday_schedule.id_holiday join client on holiday_schedule.id_client=client.identity_number join agent on holiday_schedule.idagent=? where client.name=?";
		PreparedStatement dbStatement = dbConnection.prepareStatement(statement);
		dbStatement.setInt(1,ag);
		dbStatement.setString(2, nume);
		ResultSet rs = dbStatement.executeQuery();
	    Holiday comanda;
	    List<Holiday> orders = new ArrayList<Holiday>();
	
	    while(rs.next()){
	         comanda=new Holiday();
	         comanda.setDest(rs.getString("holiday.destination"));
	        comanda.setHotel(rs.getString("holiday.hotel"));
	        comanda.setNumber(rs.getInt("holiday.number_persons"));
	        comanda.setId(rs.getInt("holiday.idholiday"));
	      
	       
	         orders.add(comanda);
	    }
	    dbConnection.close();
	    return orders;
	}
	public static List<Client> toate(int a) throws SQLException {
		Connection dbConnection = ConnectionDatabase.getConnection();
	    String tot = "SELECT distinct(client.name), client.identity_number FROM client  JOIN holiday_schedule ON holiday_schedule.id_client = client.identity_number join agent on holiday_schedule.idagent=? where holiday_schedule.paid=0  and holiday_schedule.final_payment < current_date()" ;
		PreparedStatement dbStatement = dbConnection.prepareStatement(tot);
		dbStatement.setInt(1,a);
		ResultSet rs = dbStatement.executeQuery();
	    Client comanda;
	    List<Client> orders = new ArrayList<Client>();
	
	    while(rs.next()){
	         comanda=new Client();
	         comanda.setNume(rs.getString("client.name"));
	         comanda.setId(rs.getInt("client.identity_number"));
	      
	       
	         orders.add(comanda);
	    }
	    dbConnection.close();
	    return orders;
	}


	public static int creazaComanda(int idholiday, int idclient,int idagent, String dest, String hot,int nopers,int pretTot,String date,String time_tr) throws SQLException
	{
		Connection dbConnection = ConnectionDatabase.getConnection();
		 String insertStatementString = "INSERT INTO holiday (idholiday,destination,hotel,number_persons)"
				+ " VALUES (?,?,?,?)";
		 String insertRes ="insert into holiday_schedule(id_client, id_holiday,total_price,final_payment,paid,idagent,partial,time_tranzaction)"
				 
				+ "values (?,?,?,?,?,?,?,?)";
		 PreparedStatement insertStatement = null;
		 PreparedStatement insertStatement2 = null;
		int insertedId = -1;
		int insertedId2 = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, idholiday);
			insertStatement.setString(2, dest);
			insertStatement.setString(3, hot);
			insertStatement.setInt(4, nopers);
			insertStatement.executeUpdate();
		    insertStatement2=dbConnection.prepareStatement(insertRes, Statement.RETURN_GENERATED_KEYS);
			insertStatement2.setInt(1, idclient);
			insertStatement2.setInt(2, idholiday);
			insertStatement2.setInt(3, pretTot);
			insertStatement2.setString(4, date);
			insertStatement2.setInt(5, 0);
			insertStatement2.setInt(6, idagent);
			insertStatement2.setInt(7,0);
			insertStatement2.setString(8, time_tr);
			insertStatement2.executeUpdate();
			ResultSet rs = insertStatement.getGeneratedKeys();
			ResultSet rs1 = insertStatement2.getGeneratedKeys();
				if (rs.next()) {
					insertedId = rs.getInt(1);
				
				}
				if (rs1.next()) {
					insertedId2 = rs.getInt(1);
				
				}
				
				JOptionPane.showMessageDialog(null, "Adaugare holiday reusita!");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Eroare adaugare!");
			} finally {
				ConnectionDatabase.close(insertStatement);
				ConnectionDatabase.close(dbConnection);
			}
		
			return insertedId;
			}
public static int insert(Client user) {
Connection dbConnection = ConnectionDatabase.getConnection();
 String insertStatementString = "INSERT INTO client (identity_number,name,passport,adresa)"
		+ " VALUES (?,?,?,?)";
 PreparedStatement insertStatement = null;
int insertedId = -1;
try {
	insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
	insertStatement.setInt(1, user.getId());
	insertStatement.setString(2, user.getNume());
	insertStatement.setInt(3, user.getPassport());
	insertStatement.setString(4, user.getAdresa());
	insertStatement.executeUpdate();
   
	ResultSet rs = insertStatement.getGeneratedKeys();
	if (rs.next()) {
		insertedId = rs.getInt(1);
	
	}
	JOptionPane.showMessageDialog(null, "Adaugare reusita!");
} catch (SQLException e) {
	JOptionPane.showMessageDialog(null, "eroare insert client");
} finally {
	ConnectionDatabase.close(insertStatement);
	ConnectionDatabase.close(dbConnection);
}
return insertedId;
}
	public static List<Client> totiClienti(int a) throws SQLException {
		Connection dbConnection = ConnectionDatabase.getConnection();
	    String tot = "select distinct(client.name), client.identity_number, client.passport, client.adresa from client join holiday_schedule on client.identity_number=holiday_schedule.id_client join agent on holiday_schedule.idagent=?" ;
		PreparedStatement dbStatement = dbConnection.prepareStatement(tot);
		dbStatement.setInt(1,a);
		ResultSet rs = dbStatement.executeQuery();
	    Client comanda;
	    List<Client> orders = new ArrayList<Client>();
	
	    while(rs.next()){
	         comanda=new Client();
	         comanda.setNume(rs.getString("client.name"));
	         comanda.setId(rs.getInt("client.identity_number"));
	        comanda.setPassport(rs.getInt("client.passport"));
	        comanda.setAdresa(rs.getString("client.adresa"));
	       
	         orders.add(comanda);
	    }
	    dbConnection.close();
	    return orders;
	}
}
