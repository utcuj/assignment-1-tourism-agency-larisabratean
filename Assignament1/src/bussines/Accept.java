package bussines;

public class Accept {
	public static int AccPayment(int pret_init, int pret_nou) 
	{
	if (pret_init!= pret_nou)
	{
		pret_init-=pret_nou;
	}
	return pret_init;
	}
}


