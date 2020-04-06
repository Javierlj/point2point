package dao;

import java.util.List;
import model.Viaje;

public interface ViajeDAO {
	public void create(Viaje viaje);
	public Viaje read(String id);
	public void update(Viaje viaje);
	public void delete(Viaje viaje);
	public List<Viaje> readAll();
	public Viaje login(String id, String origen, String destino);

}
