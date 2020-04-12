package dao;

import java.util.List;
import model.Favourites;

public interface FavouritesDAO {
	public void create(Favourites viaje);
	public Favourites read(String id);
	public void update(Favourites viaje);
	public void delete(Favourites viaje);
	public List<Favourites> readAll();
	public Favourites login(String id, String origen, String destino);

}