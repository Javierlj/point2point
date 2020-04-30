package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class ServiceProvider implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@Id
	private String name; //Nombre del servicios
	private String url; //Url del recurso
 	private String token; //Token para la autenticacion, puede ser nulo
 	private Boolean active; //Servicio activo en nuestra aplicacion
 	private Boolean scopeNeeded; //Es necesarioa adjuntar parametro scope a la peticion
 	
 	
 	public String getName() {
 		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Boolean getScopeNeeded() {
		return scopeNeeded;
	}
	public void setScopeNeeded(Boolean scopeNeeded) {
		this.scopeNeeded = scopeNeeded;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((scopeNeeded == null) ? 0 : scopeNeeded.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		ServiceProvider other = (ServiceProvider) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (scopeNeeded == null) {
			if (other.scopeNeeded != null)
				return false;
		} else if (!scopeNeeded.equals(other.scopeNeeded))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	} 	
	 	
	
}
