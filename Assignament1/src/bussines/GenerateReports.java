package bussines;

public class GenerateReports {
	private String s;
	public GenerateReports(String s)
	{
	this.s=s;	
	}
	public void setS(String s)
	{
		this.s=s;
	}
	
	public int getMonth(String a)
	{
		int b;
		 switch (a)
		  {
	            case "January":  b = 1;
	                     break;
	            case "February": b=2;
	                     break;
	            case "March":  b = 3;
	                     break;
	            case "April":  b = 4;
	                     break;
	            case "May":  b = 5;
	                     break;
	            case "June":  b = 6;
	                     break;
	            case "July":  b = 7;
	                     break;
	            case "August":  b = 8;
	                     break;
	            case "September":  b = 9;
	                     break;
	            case "October": b = 10;
	                     break;
	            case "November": b = 11;
	                     break;
	            case "December": b = 12;
	                     break;
	            default: b = 0;
	                     break;
	        
		  }
		 return b;
	}

}
