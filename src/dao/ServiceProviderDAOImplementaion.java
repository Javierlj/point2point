package dao;

import java.util.List;

import org.hibernate.Session;

import model.ServiceProvider;

public class ServiceProviderDAOImplementaion implements ServiceProviderDAO {
	public static ServiceProviderDAOImplementaion instance;
	private ServiceProviderDAOImplementaion() {}
	public static ServiceProviderDAOImplementaion getInstance() {
		if (instance == null) {
			instance = new ServiceProviderDAOImplementaion();
		}
		return instance;
	}
	
	@Override
	public void create(ServiceProvider provider) {
		  Session session = SessionFactoryService.get().openSession();
		  session.beginTransaction();
		  session.save(provider);
		  session.getTransaction().commit();
		  session.close();
	
	}
	@Override
	public ServiceProvider read(String name) {
		  Session session = SessionFactoryService.get().openSession();
		  session.beginTransaction();
		  ServiceProvider provider = session.get(ServiceProvider.class, name);
		  session.getTransaction().commit();
		  session.close();
		  return provider;
	}
	@Override
	public void update(ServiceProvider provider) {
		  Session session = SessionFactoryService.get().openSession();
		  session.beginTransaction();
		  session.saveOrUpdate(provider);
		  session.getTransaction().commit();
		  session.close();
	}
	@Override
	public void delete(ServiceProvider provider) {
		 Session session = SessionFactoryService.get().openSession();
		  session.beginTransaction();
		  session.delete(provider);
		  session.getTransaction().commit();
		  session.close();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceProvider> readAll() {
		  Session session = SessionFactoryService.get().openSession();
		  session.beginTransaction();
		  List<ServiceProvider> p = session.createQuery("from ServiceProvider").list();
		  session.getTransaction().commit();
		  session.close();
		  return p;
	}
	
}
