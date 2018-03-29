package domain;

public class Agent {
	private int idagent;
	private String nume;
	private String password;
	private String adresa;
public Agent()
{
	
}
public Agent( int id,String nume, String password)
{
	this.idagent=id;
	this.nume=nume;
	this.password= password;
}
public int getId()
{
	return this.idagent;
}
public void setId(int id)
{
this.idagent=id;	
}
public String getNume()
{
	return this.nume ;
}
public String getAdresa()
{
	return this.adresa;
}
public String getPassword()
{
	return this.password ;
}
public void setNume(String nume)
{
	this.nume=nume;
}
public void setPassword(String password)
{
	this.password=password;
}
public void setAdresa(String adresa)
{
	this.adresa=adresa;
}
}
