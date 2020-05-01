package test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.ServiceProviderDAOImplementaion;
import model.ServiceProvider;


class serviceProviderTest {

	@BeforeEach
	void setup() {
		System.out.println("Providers created");
		ServiceProvider provider = new ServiceProvider();
		provider.setName("Mobike2");
		provider.setUrl("http://global-n-mobike-g.mobike.com/api/nearby/v4/nearbyBikeInf");
		provider.setActive(true);
		provider.setScopeNeeded(true);
		provider.setToken("");
		ServiceProviderDAOImplementaion.getInstance().create(provider);

		
	}
	
	@AfterEach
	void finish() {
		ServiceProvider provider = new ServiceProvider();
		provider.setName("Mobike2");
		provider.setUrl("http://global-n-mobike-g.mobike.com/api/nearby/v4/nearbyBikeInf");
		provider.setActive(true);
		provider.setScopeNeeded(true);
		provider.setToken("");
		ServiceProviderDAOImplementaion.getInstance().delete(provider);
	}
	
	
	@Test
	void readTest() {
		ServiceProvider provider2 = new ServiceProvider();
		provider2.setName("Mobike2");
		provider2.setUrl("http://global-n-mobike-g.mobike.com/api/nearby/v4/nearbyBikeInf");
		provider2.setActive(true);
		provider2.setScopeNeeded(true);
		provider2.setToken("");
		ServiceProvider provider = ServiceProviderDAOImplementaion.getInstance().read("Mobike2");
		assertEquals(provider,provider2);
	}
	@Test
	void deleteTest() {
		ServiceProvider provider = new ServiceProvider();
		provider.setName("Mobike2");
		provider.setUrl("http://global-n-mobike-g.mobike.com/api/nearby/v4/nearbyBikeInf");
		provider.setActive(true);
		provider.setScopeNeeded(true);
		provider.setToken("");
		ServiceProviderDAOImplementaion.getInstance().delete(provider);
		assertNull(ServiceProviderDAOImplementaion.getInstance().read("Mobike2"));
	}
	@Test
	void readList() {
		List<ServiceProvider> providers = ServiceProviderDAOImplementaion.getInstance().readAll();
		assertNotNull(providers);
		
	}
	@Test
	void updateTest() {
		ServiceProvider provider2 = new ServiceProvider();
		provider2.setName("Mobike2");
		provider2.setUrl("http://global-n-mobike-g.mobike.com/api/nearby/v4/nearbyBikeInf");
		provider2.setActive(false);
		provider2.setScopeNeeded(true);
		provider2.setToken("");
		ServiceProviderDAOImplementaion.getInstance().update(provider2);
		ServiceProvider provider = ServiceProviderDAOImplementaion.getInstance().read("Mobike2");
		assertEquals(provider,provider2);
	}
}
