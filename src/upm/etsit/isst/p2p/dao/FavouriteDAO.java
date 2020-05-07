package upm.etsit.isst.p2p.dao;

import java.util.List;
import upm.etsit.isst.p2p.model.Favourite;

public interface FavouriteDAO {
	public void create(Favourite viaje);
	public Favourite read(String id);
	public void update(Favourite viaje);
	public void delete(Favourite viaje);
	public List<Favourite> readAll();
	public Favourite readById(String id);

}