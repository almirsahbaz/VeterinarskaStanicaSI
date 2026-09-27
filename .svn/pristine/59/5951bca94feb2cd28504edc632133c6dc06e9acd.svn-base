package servis;

import helper.Konekcija;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Administrator;
import model.Dijagnoze;
import model.Doktori;
import model.KupljeniLijekovi;
import model.Lijekovi;
import model.Pacijent;
import model.Racuni;
import model.Tehnicko_osoblje;
import model.Terapija;
import model.Usluge;
import model.Vlasnik;

public class Pretraga
{
	private static Racuni racun;

	public static List<KupljeniLijekovi> getEvidentiraneRacun()
	{
		EntityManager em = Konekcija.getEmf().createEntityManager();
		Query query = em.createQuery("select k from KupljeniLijekovi k where k.racuni like :r");
		query.setParameter("r", racun);
		List<KupljeniLijekovi> resultList = query.getResultList();
		em.close();
		return resultList;
	}

	public static List<Administrator> PretragaAdministratoraP(String text)
	{
		EntityManager em = Konekcija.getEmf().createEntityManager();

		Query query = em.createQuery("select a from Administrator a "
				+ "where concat(a.Ime, ' ', a.Prezime) like :p OR  concat(a.Prezime, ' ', a.Ime) like :p ");

		query.setParameter("p", text + "%");
		List<Administrator> x = query.getResultList();

		em.close();

		return x;
	}

	public static List<Dijagnoze> PretragaDijagnoza(String text)
	{
		EntityManager em = Konekcija.getEmf().createEntityManager();

		Query query = em.createQuery("select d from Dijagnoze d where d.Naziv_dijagnoze like :p");

		query.setParameter("p", text + "%");
		List<Dijagnoze> x = query.getResultList();

		em.close();

		return x;
	}

	public static List<Doktori> PretragaDoktoraD(String text)
	{
		EntityManager em = Konekcija.getEmf().createEntityManager();
		Query query = em.createQuery("select d from Doktori d "
				+ "where concat(d.ime, ' ', d.prezime) like :p OR concat(d.prezime, ' ', d.ime) like :p ");
		query.setParameter("p", text + "%");
		List<Doktori> x = query.getResultList();
		em.close();
		return x;
	}

	public static List<Lijekovi> PretragaLijekova(String text)
	{
		EntityManager em = Konekcija.getEmf().createEntityManager();

		Query query = em.createQuery("select l from Lijekovi l where l.Naziv like :p");

		query.setParameter("p", text + "%");
		List<Lijekovi> x = query.getResultList();

		em.close();

		return x;
	}

	public static List<Pacijent> PretragaPacijenata(String text)
	{
		EntityManager em = Konekcija.getEmf().createEntityManager();

		Query query = em.createQuery("select p from Pacijent p where p.ime like :p");

		query.setParameter("p", text + "%");
		List<Pacijent> x = query.getResultList();

		em.close();

		return x;
	}

	public static List<Racuni> PretragaRacuna(String text)
	{
		EntityManager em = Konekcija.getEmf().createEntityManager();

		Query query = em.createQuery("select r from Racuni r where r.naziv like :p");

		query.setParameter("p", text + "%");
		List<Racuni> x = query.getResultList();

		em.close();

		return x;
	}

	public static List<Tehnicko_osoblje> PretragaTehnickoT(String text)
	{
		EntityManager em = Konekcija.getEmf().createEntityManager();

		Query query = em.createQuery("select a from Tehnicko_osoblje a "
				+ "where concat(a.ime, ' ', a.prezime) like :p OR  concat(a.prezime, ' ', a.ime) like :p ");

		query.setParameter("p", text + "%");
		List<Tehnicko_osoblje> x = query.getResultList();

		em.close();

		return x;
	}

	public static List<Terapija> Pretragaterapija(String text)
	{
		EntityManager em = Konekcija.getEmf().createEntityManager();

		Query query = em.createQuery("select t from Terapija t where t.vrsta like :p");

		query.setParameter("p", text + "%");
		List<Terapija> x = query.getResultList();

		em.close();

		return x;
	}

	public static List<Usluge> Pretragausluga(String text)
	{
		EntityManager em = Konekcija.getEmf().createEntityManager();

		Query query = em.createQuery("select u from Usluge u where u.naziv like :p");

		query.setParameter("p", text + "%");
		List<Usluge> x = query.getResultList();

		em.close();

		return x;
	}

	public static List<Vlasnik> Pretragavlasnika(String text)
	{
		EntityManager em = Konekcija.getEmf().createEntityManager();

		Query query = em.createQuery("select v from Vlasnik v where v.ime like :p");

		query.setParameter("p", text + "%");
		List<Vlasnik> x = query.getResultList();

		em.close();

		return x;
	}

	public void EvidencijaRacunaServis(Racuni r)
	{
		this.racun = r;
	}
}
