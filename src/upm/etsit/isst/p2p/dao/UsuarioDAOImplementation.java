package upm.etsit.isst.p2p.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import upm.etsit.isst.p2p.model.Usuario;

public class UsuarioDAOImplementation implements UsuarioDAO{
	
	private static  UsuarioDAOImplementation sfs = null;
	
	private UsuarioDAOImplementation() {
		
	}
	
	public static UsuarioDAOImplementation getInstance() {
		   if( null == sfs ) 
		     sfs = new UsuarioDAOImplementation();
		   return sfs;
		  }
	
	@SuppressWarnings("unchecked")
	@Override
	public void create (Usuario usuario) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.save(usuario);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Usuario read (String email) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  Usuario usuario = session.get(Usuario.class, email);
	  session.getTransaction().commit();
	  session.close();
	  return usuario;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update (Usuario usuario) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.saveOrUpdate(usuario);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete (Usuario usuario) {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  session.delete(usuario);
	  session.getTransaction().commit();
	  session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> readAll () {
	  Session session = SessionFactoryService.get().openSession();
	  session.beginTransaction();
	  List<Usuario> p = session.createQuery("from Usuario").list();
	  session.getTransaction().commit();
	  session.close();
	  return p;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Usuario login (String email, String password) {
	  Session session = SessionFactoryService.get().openSession();
	  Usuario usuario = null;
	  session.beginTransaction();
	  Query q = session.createQuery("select p from Usuario p where p.email = :email and p.password = :password");
	  q.setParameter("email", email);
	  q.setParameter("password", password);
	  List<Usuario> tfgs = q.getResultList();
	  if (tfgs.size() > 0)
	  	usuario = (Usuario) (q.getResultList().get(0));
	  session.getTransaction().commit();
	  session.close();
	  return usuario;
	}

}
