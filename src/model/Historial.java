package model;

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
	private String origen;
	private String destino;
	private Date date;
	private double cost;
	
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


	@Override
	public String toString() {
		return "Historial [id=" + id + ", origen=" + origen + ", destino=" + destino + ", date=" + date + ", cost="
				+ cost + ", advisor=" + advisor + "]";
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Historial historial = (Historial) o;
		return id == historial.id &&
				Double.compare(historial.cost, cost) == 0 &&
				origen.equals(historial.origen) &&
				destino.equals(historial.destino) &&
				date.equals(historial.date) &&
				advisor.equals(historial.advisor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, origen, destino, date, cost, advisor);
	}
}
