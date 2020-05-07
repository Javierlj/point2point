package upm.etsit.isst.p2p.dao;

import java.util.List;
import upm.etsit.isst.p2p.model.Historial;

public interface HistorialDAO {
	public void create(Historial viaje);
	public Historial read(String id);
	public void update(Historial viaje);
	public void delete(Historial viaje);
	public List<Historial> readAll();

}
