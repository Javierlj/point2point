package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import model.Viaje;

public class ViajeDAOImplementation implements ViajeDAO{
private static  ViajeDAOImplementation sfs = null;
	
	private ViajeDAOImplementation() {
		
	}
	
	public static ViajeDAOImplementation getInstance() {
		   if( null == sfs ) 
		     sfs = new ViajeDAOImplementation();
		   return sfs;
		  }
	
	@SuppressWarnings("unchecked")
	@Override
	public void create (Viaje viaje) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.save(viaje);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Viaje read (String email) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  Viaje usuario = session.get(Viaje.class, email);
	  session.getTransaction().commit();
	  session.close();
	  return usuario;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update (Viaje usuario) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.saveOrUpdate(usuario);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete (Viaje usuario) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.delete(usuario);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Viaje> readAll () {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  List<Viaje> p = session.createQuery("from Viaje").list();
	  session.getTransaction().commit();
	  session.close();
	  return p;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Viaje login (String id, String origen, String destino) {
	  Session session = SessionFactoryService.get().openSession();
	  Viaje viaje = null;
	  session.beginTransaction();
	  Query q = session.createQuery("select p from Usuario p where p.id = :id and p.origen = :origen and p.destino = :destino");
	  q.setParameter("id", id);
	  q.setParameter("origen", origen);
	  q.setParameter("destino", destino);
	  List<Viaje> tfgs = q.getResultList();
	  if (tfgs.size() > 0)
	  	viaje = (Viaje) (q.getResultList().get(0));
	  session.getTransaction().commit();
	  session.close();
	  return viaje;
	}

}
