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
import domain.Admin;
import domain.Agent;
import domain.Client;
import domain.Holiday;
import domain.HolidaySchedule;
public class AdminDataMapper {
	public static List<Agent> toate(int a) throws SQLException {
		Connection dbConnection = ConnectionDatabase.getConnection();
	    String tot = "SELECT agent.idagent, agent.nume, agent.adresa FROM agent  JOIN admin ON agent.idagent = admin.idagent where admin.id=?";
		PreparedStatement dbStatement = dbConnection.prepareStatement(tot);
		dbStatement.setInt(1,a);
		ResultSet rs = dbStatement.executeQuery();
	    Agent comanda;
	    List<Agent> orders = new ArrayList<Agent>();
	
	    while(rs.next()){
	         comanda=new Agent();
	      
	         comanda.setId(rs.getInt("agent.idagent"));
	         comanda.setNume(rs.getString("agent.nume"));
	         comanda.setAdresa(rs.getString("agent.adresa"));
	         orders.add(comanda);
	    }
	    dbConnection.close();
	    return orders;
	}
	public static List<HolidaySchedule> generateReports(int idag, int s) throws SQLException
	{
		Connection dbConnection = ConnectionDatabase.getConnection();
		 String gen="select holiday_schedule.id_holiday, holiday_schedule.id_client, holiday_schedule.total_price, holiday_schedule.paid  from holiday_schedule join agent on holiday_schedule.idagent=agent.idagent where  agent.idagent=? and month(holiday_schedule.time_tranzaction)=?";
		 PreparedStatement dbStatement = dbConnection.prepareStatement(gen);
			dbStatement.setInt(1,idag);
			dbStatement.setInt(2, s);
			ResultSet rs = dbStatement.executeQuery();
		    HolidaySchedule comanda;
		    List<HolidaySchedule> orders = new ArrayList<HolidaySchedule>();
		    while(rs.next()){
		         comanda=new HolidaySchedule();
		      
		         comanda.setIdHoliday((rs.getInt("holiday_schedule.id_holiday")));
		         comanda.setIDClient(rs.getInt("holiday_schedule.id_client"));
		         comanda.setTotal(rs.getInt("holiday_schedule.total_price"));
		         comanda.setPaid(rs.getInt("holiday_schedule.paid"));
		        
		         orders.add(comanda);
		    }
		    dbConnection.close();
		    return orders;
	}
	
	public static  void deleteAgent(int id)
	{
	     String deleteAdmin="DELETE FROM admin where idagent ="+String.valueOf(id);
	     String deleteAgent= "Delete from agent where idagent= "+String.valueOf(id);
		Connection dbConnection = ConnectionDatabase.getConnection();
		try{
			Statement stat=dbConnection.createStatement();
			Statement stat1=dbConnection.createStatement();
			stat.executeUpdate(deleteAdmin);
			stat1.executeUpdate(deleteAgent);
			JOptionPane.showMessageDialog(null, "stergere reusita!");
			
		}catch (SQLException e) {
			 e.printStackTrace();
		} finally {
			ConnectionDatabase.close(dbConnection);
		}
	}
	public static synchronized Admin findByGuId(String nume) throws SQLException {
		Admin adm=new Admin();
		try {
			Connection db = ConnectionDatabase.getConnection();
	
			String statement = "SELECT id, nume, password  FROM admin where nume= ?";
			PreparedStatement dbStatement = db.prepareStatement(statement);
			dbStatement.setString(1, nume);
			ResultSet rs = dbStatement.executeQuery();
			
			while(rs.next()) {
				int id= rs.getInt("id");
				String name = rs.getString("nume");
				String pass = rs.getString("password");
				
				adm = new Admin(id,name,pass);
				// careful with these setters once you've written code for state!
		
				
				return adm;
				
				
			}
			return adm;
		} catch (SQLException e) {
			// We don't want any types which use the Data Mapper
			// to be coupled to java.sql.SQLException
			// So instead, we throw a custom DataMapperException 
			throw new SQLException("Error occured reading admin from the data source.", e);
		}
	}
	
}
