package domain;

public class Client {
private int identity_number;
private String name;
private int passport;
private String adresa;
public Client()
{
	
}
public Client( int id, String nume, int pass, String adresa)
{
	this.identity_number=id;
	this.name=nume;
	this.passport=pass;
	this.adresa=adresa;
}
public String getNume()
{
	return this.name ;
}
public String getAdresa()
{
	return this.adresa;
}
public int getPassport()
{
	return this.passport ;
}
public int getId()
{
	return this.identity_number;
}

public void setNume(String nume)
{
	this.name=nume;
}
public void setPassport(int passport)
{
	this.passport=passport;
}
public void setAdresa(String adresa)
{
	this.adresa=adresa;
}
public void setId(int id)
{
	this.identity_number=id;
}
public String retClient(int id)
{
	return "Clientul "+ this.getNume()+" cu id-ul: "+this.getId();
}
}
