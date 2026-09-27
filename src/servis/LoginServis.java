package servis;

import helper.Konekcija;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.KorisnickiNalog;

public class LoginServis
{
	public static KorisnickiNalog loginKorisnik(String username, String password)
	{

		EntityManager em = Konekcija.getEmf().createEntityManager();
		TypedQuery<KorisnickiNalog> q = em.createQuery("select k from KorisnickiNalog k  where k.username = ? and k.password = ?",
				KorisnickiNalog.class);
		q.setParameter(1, username);
		q.setParameter(2, password);
		List<KorisnickiNalog> k = q.getResultList();
		em.close();
		if (k.size() == 0)
			return null;
		else
			return k.get(0);
	}

}
