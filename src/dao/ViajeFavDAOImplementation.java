package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import model.ViajeFav;

public class ViajeFavDAOImplementation implements ViajeFavDAO{
    private static  ViajeFavDAOImplementation sfs = null;
	
	private ViajeFavDAOImplementation() {
		
	}
	
	public static ViajeFavDAOImplementation getInstance() {
		   if( null == sfs ) 
		     sfs = new ViajeFavDAOImplementation();
		   return sfs;
		  }
	
	@SuppressWarnings("unchecked")
	@Override
	public void create (ViajeFav viaje) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.save(viaje);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ViajeFav read (String email) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  ViajeFav usuario = session.get(ViajeFav.class, email);
	  session.getTransaction().commit();
	  session.close();
	  return usuario;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update (ViajeFav usuario) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.saveOrUpdate(usuario);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete (ViajeFav viaje) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.delete(viaje);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ViajeFav> readAll () {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  List<ViajeFav> p = session.createQuery("from ViajeFav").list();
	  session.getTransaction().commit();
	  session.close();
	  return p;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ViajeFav login (String id, String origen, String destino) {
	  Session session = SessionFactoryService.get().openSession();
	  ViajeFav viaje = null;
	  session.beginTransaction();
	  Query q = session.createQuery("select p from ViajeFav p where p.id = :id and p.origen = :origen and p.destino = :destino");
	  q.setParameter("id", id);
	  q.setParameter("origen", origen);
	  q.setParameter("destino", destino);
	  List<ViajeFav> tfgs = q.getResultList();
	  if (tfgs.size() > 0)
	  	viaje = (ViajeFav) (q.getResultList().get(0));
	  session.getTransaction().commit();
	  session.close();
	  return viaje;
	}

}