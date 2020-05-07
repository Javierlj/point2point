package upm.etsit.isst.p2p.dao;

import java.util.List;

import upm.etsit.isst.p2p.model.ServiceProvider;

public interface ServiceProviderDAO {
	public void create(ServiceProvider provider);
	public ServiceProvider read(String name);
	public void update(ServiceProvider provider);
	public void delete(ServiceProvider provider);
	public List<ServiceProvider> readAll();
}
