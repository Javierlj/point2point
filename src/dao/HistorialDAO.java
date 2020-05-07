package dao;

import java.util.List;
import model.Historial;

public interface HistorialDAO {
	public void create(Historial viaje);
	public Historial read(String id);
	public void update(Historial viaje);
	public void delete(Historial viaje);
	public List<Historial> readAll();

}
