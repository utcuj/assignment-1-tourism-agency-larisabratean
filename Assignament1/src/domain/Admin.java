package domain;

import java.util.UUID;

public class Admin {
	private int id;
	private String nume;
	private String password;
	private int idagent;
public Admin()
{
	
}
public Admin(int id)
{
	this.id=id;
}
public Admin( int id, String nume, String password)
{
	this.id=id;
	this.nume=nume;
	this.password= password;
}
public Admin( String nume, String pass)
{
	this.nume=nume;
	this.password=pass;
}
public String getNume()
{
	return this.nume ;
}
public int getId()
{
	return this.id;
}
public int getIdAgent()
{
	return this.idagent;
}
public String getPassword()
{
	return this.password ;
}
public void setId(int id)
{
	this.id=id;
}
public void setIdAgent(int id)
{
	this.idagent=id;
}
public void setNume(String nume)
{
	this.nume=nume;
}
public void setPassword(String password)
{
	this.password=password;
}
}
