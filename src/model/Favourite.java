package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Favourite implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	private String name;
	private String origen;
	private String destino;

	@ManyToOne
	private Usuario advisor;

	public Favourite() {
		super();
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Favourite favourite = (Favourite) o;
		return Objects.equals(id, favourite.id) &&
				Objects.equals(name, favourite.name) &&
				Objects.equals(origen, favourite.origen) &&
				Objects.equals(destino, favourite.destino) &&
				Objects.equals(advisor, favourite.advisor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, origen, destino, advisor);
	}

	@Override
	public String toString() {
		return "Favourite{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", origen='" + origen + '\'' +
				", destino='" + destino + '\'' +
				", advisor=" + advisor +
				'}';
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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