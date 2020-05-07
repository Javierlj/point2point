package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import model.Historial;

public class HistorialDAOImplementation implements HistorialDAO {
private static  HistorialDAOImplementation sfs = null;
	
	private HistorialDAOImplementation() {
		
	}
	
	public static HistorialDAOImplementation getInstance() {
		   if( null == sfs ) 
		     sfs = new HistorialDAOImplementation();
		   return sfs;
		  }
	
	@SuppressWarnings("unchecked")
	@Override
	public void create (Historial viaje) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.save(viaje);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Historial read (String email) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  Historial usuario = session.get(Historial.class, email);
	  session.getTransaction().commit();
	  session.close();
	  return usuario;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update (Historial usuario) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.saveOrUpdate(usuario);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete (Historial viaje) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.delete(viaje);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Historial> readAll () {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  List<Historial> p = session.createQuery("from Historial").list();
	  session.getTransaction().commit();
	  session.close();
	  return p;
	}

}
