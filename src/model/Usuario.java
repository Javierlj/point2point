package model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


@Entity
public class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
	private String email;
	private String name;
	private String last_name;
	private String password;

	@OneToMany(mappedBy = "advisor", fetch = FetchType.EAGER)
	private List<ViajeFav> viajes_fav;
	
	@OneToMany(mappedBy = "advisor", fetch = FetchType.EAGER)
	private List<Historial> historial;
	
	public Usuario() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String nombre) {
		this.name = nombre;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String apellidos) {
		this.last_name = apellidos;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ViajeFav> getViajes_fav() {
		return viajes_fav;
	}

	public void setViajes_fav(List<ViajeFav> viajes_fav) {
		this.viajes_fav = viajes_fav;
	}
	
	public List<Historial> getHistorial() {
		return historial;
	}

	public void setHistorial(List<Historial> viajes_fav) {
		this.historial = viajes_fav;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((viajes_fav == null) ? 0 : viajes_fav.hashCode());
        result = prime * result + ((historial == null) ? 0 : historial.hashCode());
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
        if (last_name == null) {
            if (other.last_name != null)
                return false;
        } else if (!last_name.equals(other.last_name))
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
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (viajes_fav == null) {
            if (other.viajes_fav != null)
                return false;
        } else if (!viajes_fav.equals(other.viajes_fav))
            return false;
        if (historial == null) {
            if (other.historial != null)
                return false;
        } else if (!historial.equals(other.historial))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Usuario [email=" + email + ", nombre=" + name + ", apellidos=" + last_name + ", contrase�a="
                + password + ", viajes_fav=" + viajes_fav + ", historial=" + historial + "]";
    }

}
