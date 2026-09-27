package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Terapija
{

	@Id
	@GeneratedValue
	private int terapijaID;

	private String vrsta;

	private Date datumTerapije;

	public Date getDatumTerapije()
	{
		return datumTerapije;
	}

	public int getTerapijaID()
	{
		return terapijaID;
	}

	public String getVrsta()
	{
		return vrsta;
	}

	public void setDatumTerapije(Date datumTerapije)
	{
		this.datumTerapije = datumTerapije;
	}

	public void setTerapijaID(int terapijaID)
	{
		this.terapijaID = terapijaID;
	}

	public void setVrsta(String vrsta)
	{
		this.vrsta = vrsta;
	}

}