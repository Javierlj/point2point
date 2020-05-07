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
	private String origin;
	private String destiny;
	private float origin_lat;
	private float origin_long;
	private float destiny_lat;
	private float destiny_long;

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
		return Float.compare(favourite.origin_lat, origin_lat) == 0 &&
				Float.compare(favourite.origin_long, origin_long) == 0 &&
				Float.compare(favourite.destiny_lat, destiny_lat) == 0 &&
				Float.compare(favourite.destiny_long, destiny_long) == 0 &&
				Objects.equals(id, favourite.id) &&
				name.equals(favourite.name) &&
				advisor.equals(favourite.advisor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, origin_lat, origin_long, destiny_lat, destiny_long, advisor);
	}

	@Override
	public String toString() {
		return "Favourite{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", origin_lat=" + origin_lat +
				", origin_long=" + origin_long +
				", destiny_lat=" + destiny_lat +
				", getDestiny_long=" + destiny_long +
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

	public float getOrigin_lat() {
		return origin_lat;
	}

	public void setOrigin_lat(float origin_lat) {
		this.origin_lat = origin_lat;
	}

	public float getOrigin_long() {
		return origin_long;
	}

	public void setOrigin_long(float origin_long) {
		this.origin_long = origin_long;
	}

	public float getDestiny_lat() {
		return destiny_lat;
	}

	public void setDestiny_lat(float destiny_lat) {
		this.destiny_lat = destiny_lat;
	}

	public float getGetDestiny_long() {
		return destiny_long;
	}

	public void setDestiny_long(float destiny_long) {
		this.destiny_long = destiny_long;
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

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

}