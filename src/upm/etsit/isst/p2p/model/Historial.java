package upm.etsit.isst.p2p.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Historial implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	private float origin_lat;
	private float origin_long;
	private float destiny_lat;
	private float destiny_long;
	private Date date;
	private double cost;
	private String origin;
	private String destiny;
	
	@ManyToOne
	private Usuario advisor;
	
	
	public Historial() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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

	public float getDestiny_long() {
		return destiny_long;
	}

	public void setDestiny_long(float destiny_long) {
		this.destiny_long = destiny_long;
	}

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public Usuario getAdvisor() {
		return advisor;
	}


	public void setAdvisor(Usuario advisor) {
		this.advisor = advisor;
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

	@Override
	public String toString() {
		return "Historial{" +
				"id=" + id +
				", origin_lat=" + origin_lat +
				", origin_long=" + origin_long +
				", destiny_lat=" + destiny_lat +
				", destiny_long=" + destiny_long +
				", date=" + date +
				", cost=" + cost +
				", advisor=" + advisor +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Historial historial = (Historial) o;
		return id == historial.id &&
				Float.compare(historial.origin_lat, origin_lat) == 0 &&
				Float.compare(historial.origin_long, origin_long) == 0 &&
				Float.compare(historial.destiny_lat, destiny_lat) == 0 &&
				Float.compare(historial.destiny_long, destiny_long) == 0 &&
				Double.compare(historial.cost, cost) == 0 &&
				Objects.equals(date, historial.date) &&
				Objects.equals(advisor, historial.advisor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, origin_lat, origin_long, destiny_lat, destiny_long, date, cost, advisor);
	}
}
