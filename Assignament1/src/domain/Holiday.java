package domain;

public class Holiday {
private int idholiday;
private String destination;
private String hotel;
private int number_persons;
public Holiday()
{
	
}
public Holiday( int id, String dest, String hotel, int nr)
{
	this.idholiday=id;
	this.destination=dest;
	this.hotel=hotel;
	this.number_persons=nr;
}

public int getId()
{
	return this.idholiday ;
}
public String getDest()
{
	return this.destination;
}
public String getHotel()
{
	return this.hotel;
}
public int getNumber()
{
	return this.number_persons;
}
public void setId(int id)
{
	this.idholiday=id;
}
public void setDest(String dest)
{
	this.destination=dest;
}
public void setHotel(String h)
{
	this.hotel=h;
}
public void setNumber(int n)
{
	this.number_persons=n;
}
}
