package upm.etsit.isst.p2p.dao;

import java.util.List;
import upm.etsit.isst.p2p.model.Usuario;

public interface UsuarioDAO {
	public void create(Usuario usuario);
	public Usuario read(String email);
	public void update(Usuario usuario);
	public void delete(Usuario usuario);
	public List<Usuario> readAll();
	public Usuario login(String email, String password);

}
