package domain;

import java.sql.Date;
import java.time.LocalDate;

public class HolidaySchedule {

private int id_client;
private int id_holiday;
private int total_price;
private String final_payment;
private String time_tranzaction;
private int paid;
private int idagent;
private int partial;
public HolidaySchedule()
{
	
}
public HolidaySchedule(int ic, int ih, int total, String f, int p, int ia, int part, String time)
{
	this.id_client=ic;
	this.id_holiday=ih;
	this.total_price=total;
	this.final_payment=f;
	this.paid=p;
	this.idagent=ia;
	this.partial=part;
	this.time_tranzaction=time;
	

}
public int getIdClient()
{
	return this.id_client;
}

public int getIdHoliday()
{
	return this.id_holiday;
}

public int getPartialPayment()
{
	return this.partial;
}

public int getIdAgent()
{
	return this.idagent;
}

public int getTotal()
{
	return this.total_price;
}

public int getPaid()
{
	return this.paid;
}
public String getPayment()
{
	return this.final_payment;
}
public String getTimeTr()
{
	return this.time_tranzaction;
}


public void setPartial(int i )
{
	this.partial=i;
}
public void setIDClient(int i )
{
	this.id_client=i;
}

public void setIdHoliday(int i )
{
	this.id_holiday=i;
}

public void setIdAgent(int i )
{
	this.idagent=i;
}

public void setTotal(int i )
{
	this.total_price=i;
}
public void setPayment(String d)
{
	this.final_payment=d;
}
public void setTimeTr(String d)
{
	this.time_tranzaction=d;
}
public void setPaid(int d)
{
	this.paid=d;
}
}
