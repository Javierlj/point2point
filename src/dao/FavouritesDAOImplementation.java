package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import model.Favourites;

public class FavouritesDAOImplementation implements FavouritesDAO{
    private static  FavouritesDAOImplementation sfs = null;
	
	private FavouritesDAOImplementation() {
		
	}
	
	public static FavouritesDAOImplementation getInstance() {
		   if( null == sfs ) 
		     sfs = new FavouritesDAOImplementation();
		   return sfs;
		  }
	
	@SuppressWarnings("unchecked")
	@Override
	public void create (Favourites viaje) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.save(viaje);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Favourites read (String email) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  Favourites usuario = session.get(Favourites.class, email);
	  session.getTransaction().commit();
	  session.close();
	  return usuario;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update (Favourites usuario) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.saveOrUpdate(usuario);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete (Favourites viaje) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.delete(viaje);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Favourites> readAll () {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  List<Favourites> p = session.createQuery("from Favourites").list();
	  session.getTransaction().commit();
	  session.close();
	  return p;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Favourites login (String id, String origen, String destino) {
	  Session session = SessionFactoryService.get().openSession();
	  Favourites viaje = null;
	  session.beginTransaction();
	  Query q = session.createQuery("select p from Favourites p where p.id = :id and p.origen = :origen and p.destino = :destino");
	  q.setParameter("id", id);
	  q.setParameter("origen", origen);
	  q.setParameter("destino", destino);
	  List<Favourites> tfgs = q.getResultList();
	  if (tfgs.size() > 0)
	  	viaje = (Favourites) (q.getResultList().get(0));
	  session.getTransaction().commit();
	  session.close();
	  return viaje;
	}

}