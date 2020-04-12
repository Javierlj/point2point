package dao;

import java.util.List;
import model.ViajeFav;

public interface ViajeFavDAO {
	public void create(ViajeFav viaje);
	public ViajeFav read(String id);
	public void update(ViajeFav viaje);
	public void delete(ViajeFav viaje);
	public List<ViajeFav> readAll();
	public ViajeFav login(String id, String origen, String destino);

}