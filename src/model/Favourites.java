package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Favourites implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String origen;
	private String destino;

	@ManyToOne
	private Usuario advisor;

	public Favourites() {
		super();
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advisor == null) ? 0 : advisor.hashCode());
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((origen == null) ? 0 : origen.hashCode());
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
		Favourites other = (Favourites) obj;
		if (advisor == null) {
			if (other.advisor != null)
				return false;
		} else if (!advisor.equals(other.advisor))
			return false;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (origen == null) {
			if (other.origen != null)
				return false;
		} else if (!origen.equals(other.origen))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "ViajeFav [id=" + id + ", origen=" + origen + ", destino=" + destino + ", advisor=" + advisor + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Usuario getAdvisor() {
		return advisor;
	}

	public void setUsuario(Usuario usuario) {
		this.advisor = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}