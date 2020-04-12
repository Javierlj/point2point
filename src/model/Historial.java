package model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Historial implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advisor == null) ? 0 : advisor.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		Historial other = (Historial) obj;
		if (advisor == null) {
			if (other.advisor != null)
				return false;
		} else if (!advisor.equals(other.advisor))
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
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
	
	
}
