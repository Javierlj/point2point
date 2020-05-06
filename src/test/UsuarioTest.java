package test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Favourite;
import model.Historial;
import model.Usuario;
import dao.UsuarioDAOImplementation;


class UsuarioTest {

	@BeforeEach
	void setup() {
		System.out.println("Providers created");
		List<Favourite> viajes_fav = new ArrayList<Favourite>();
		Usuario user = new Usuario();
		user.setName("Test");
		user.setLast_name("Test");
		user.setEmail("test@email.com");
		user.setPassword("1234");
		user.setViajes_fav( viajes_fav);
		user.setHistorial(new ArrayList<Historial>());
		UsuarioDAOImplementation.getInstance().create(user);


		
	}
	
	@AfterEach
	void finish() {
		List<Favourite> viajes_fav = new ArrayList<Favourite>();
		Usuario user = new Usuario();
		user.setName("Test");
		user.setLast_name("Test");
		user.setEmail("test@email.com");
		user.setPassword("1234");
		user.setViajes_fav( viajes_fav);
		user.setHistorial(new ArrayList<Historial>());
		UsuarioDAOImplementation.getInstance().delete(user);
	}
	
	
	@Test
	void readTest() {
		Usuario user2 = new Usuario();
		user2.setName("Test");
		user2.setEmail("test@email.com");
		user2.setPassword("1234");
		user2.setLast_name("Test");
		List<Favourite> viajes_fav = new ArrayList<Favourite>();
		user2.setViajes_fav( viajes_fav);
		user2.setHistorial(new ArrayList<Historial>());
		Usuario user = UsuarioDAOImplementation.getInstance().read("test@email.com");
		assertEquals(user.getName(),user2.getName());
		assertEquals(user.getLast_name(),user2.getLast_name());
		assertEquals(user.getPassword(),user2.getPassword());	
	}
	@Test
	void deleteTest() {
		Usuario user = new Usuario();
		user.setName("Test");
		user.setEmail("test@email.com");
		user.setLast_name("Test");
		user.setPassword("1234");
		List<Favourite> viajes_fav = new ArrayList<Favourite>();
		user.setViajes_fav( viajes_fav);
		user.setHistorial(new ArrayList<Historial>());
		UsuarioDAOImplementation.getInstance().delete(user);
		assertNull(UsuarioDAOImplementation.getInstance().read("test@email.com"));
	}
	@Test
	void readList() {
		List<Usuario> users = UsuarioDAOImplementation.getInstance().readAll();
		assertNotNull(users);
		
	}
	@Test
	void updateTest() {
		Usuario user2 = new Usuario();
		user2.setName("Tes");
		user2.setEmail("test@email.com");
		user2.setPassword("1234");
		user2.setLast_name("Test");
		List<Favourite> viajes_fav = new ArrayList<Favourite>();
		user2.setViajes_fav(viajes_fav);
		user2.setHistorial(new ArrayList<Historial>());
		UsuarioDAOImplementation.getInstance().update(user2);
		Usuario user = UsuarioDAOImplementation.getInstance().read("test@email.com");
		assertEquals(user2.getName(),user.getName());
	}
}
