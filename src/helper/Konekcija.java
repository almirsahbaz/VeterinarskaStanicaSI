package helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Konekcija
{
	private static EntityManagerFactory emf = null;

	public static EntityManagerFactory getEmf()
	{
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("MojaOznaka1");
		return emf;
	}
}
