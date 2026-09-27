package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Racuni
{

	@Id
	@GeneratedValue
	private int racunID;

	private String naziv;
	private Date datum;

	private String iznosZaPlatiti;

	public Date getDatum()
	{
		return datum;
	}

	public String getIznosZaPlatiti()
	{
		return iznosZaPlatiti;
	}

	public String getNaziv()
	{
		return naziv;
	}

	public int getRacunID()
	{
		return racunID;
	}

	public void setDatum(Date datum)
	{
		this.datum = datum;
	}

	public void setIznosZaPlatiti(String iznosZaPlatiti)
	{
		this.iznosZaPlatiti = iznosZaPlatiti;
	}

	public void setNaziv(String naziv)
	{
		this.naziv = naziv;
	}

	public void setRacunID(int racunID)
	{
		this.racunID = racunID;
	}

}