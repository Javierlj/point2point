package model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


@Entity
public class Usuario {
	private static final long serialVersionUID = 1L;
	@Id
	private String email;
	private String nombre;
	private String apellidos;
	private String password;
	@OneToMany(mappedBy = "advisor", fetch = FetchType.EAGER)
	private List<Viaje> viajes_fav = new ArrayList<Viaje>();
	
	public Usuario() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((viajes_fav == null) ? 0 : viajes_fav.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (viajes_fav == null) {
			if (other.viajes_fav != null)
				return false;
		} else if (!viajes_fav.equals(other.viajes_fav))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", apellidos=" + apellidos + ", contraseña="
				+ password + ", viajes_fav=" + viajes_fav + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Viaje> getViajes_fav() {
		return viajes_fav;
	}

	public void setViajes_fav(List<Viaje> viajes_fav) {
		this.viajes_fav = viajes_fav;
	}
	


}
