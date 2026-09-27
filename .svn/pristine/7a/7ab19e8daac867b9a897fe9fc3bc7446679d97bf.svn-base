package helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DAO
{
	public static void brisi(Object a)
	{
		EntityManager em = Konekcija.getEmf().createEntityManager();
		Object attached = em.merge(a);
		em.getTransaction().begin();
		em.remove(attached);
		em.getTransaction().commit();
		em.close();
	}

	public static <T> List<T> getAll(Class<T> type)
	{
		EntityManager em = Konekcija.getEmf().createEntityManager();

		TypedQuery<T> query = em.createQuery("select x from " + type.getName() + "  x", type);

		List<T> resultList = query.getResultList();

		em.close();

		return resultList;
	}

	public static <T> T getByID(Class<T> type, Integer id)
	{
		EntityManager em = Konekcija.getEmf().createEntityManager();
		T o = em.find(type, id);
		em.close();
		return o;
	}

	public static void snimi(Object a)
	{
		EntityManager em = Konekcija.getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}

	public static void update(Object a)
	{
		EntityManager em = Konekcija.getEmf().createEntityManager();
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
		em.close();
	}
}
