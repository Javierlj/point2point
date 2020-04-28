package dao;

import java.util.List;

import model.ServiceProvider;

public interface ServiceProviderDAO {
	public void create(ServiceProvider provider);
	public ServiceProvider read(String name);
	public void update(ServiceProvider provider);
	public void delete(ServiceProvider provider);
	public List<ServiceProvider> readAll();
}
