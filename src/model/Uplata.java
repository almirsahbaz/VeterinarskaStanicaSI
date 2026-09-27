package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Uplata
{

	@Id
	@GeneratedValue
	private int uplataID;

	private String iznos;

	private Date datum;

	@JoinColumn(nullable = false)
	@ManyToOne
	public Racuni racuni;

	public Date getDatum()
	{
		return datum;
	}

	public String getIznos()
	{
		return iznos;
	}

	public Racuni getRacuni()
	{
		return racuni;
	}

	public int getUplataID()
	{
		return uplataID;
	}

	public void setDatum(Date datum)
	{
		this.datum = datum;
	}

	public void setIznos(String iznos)
	{
		this.iznos = iznos;
	}

	public void setRacuni(Racuni racuni)
	{
		this.racuni = racuni;
	}

	public void setUplataID(int uplataID)
	{
		this.uplataID = uplataID;
	}

}