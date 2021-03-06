package upm.etsit.isst.p2p.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import upm.etsit.isst.p2p.model.Favourite;

public class FavouriteDAOImplementation implements FavouriteDAO {
    private static FavouriteDAOImplementation sfs = null;
	
	private FavouriteDAOImplementation() {
		
	}
	
	public static FavouriteDAOImplementation getInstance() {
		   if( null == sfs ) 
		     sfs = new FavouriteDAOImplementation();
		   return sfs;
		  }
	
	@SuppressWarnings("unchecked")
	@Override
	public void create (Favourite viaje) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.save(viaje);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Favourite read (String email) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  Favourite usuario = session.get(Favourite.class, email);
	  session.getTransaction().commit();
	  session.close();
	  return usuario;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update (Favourite usuario) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.saveOrUpdate(usuario);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete (Favourite viaje) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.delete(viaje);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Favourite> readAll () {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  List<Favourite> favourites = session.createQuery("from Favourite").list();
	  session.getTransaction().commit();
	  session.close();
	  return favourites;
	}

	@Override
	public Favourite readById(String id) {
		Session session = SessionFactoryService.get().openSession();
		Favourite viaje = null;
		session.beginTransaction();
		Query q = session.createQuery("select p from Favourite p where p.id = :id");
		q.setParameter("id", id);
		List<Favourite> p = q.getResultList();
		if(p.size()>0)
			viaje = (Favourite) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return viaje;
	}

}