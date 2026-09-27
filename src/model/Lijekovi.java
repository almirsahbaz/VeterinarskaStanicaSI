package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lijekovi
{
	@Id
	@GeneratedValue
	private int lijekID;

	private String Naziv;

	private String Vrsta;

	private Date Rok_trajanja;

	public int getLijekID()
	{
		return lijekID;
	}

	public String getNaziv()
	{
		return Naziv;
	}

	public Date getRok_trajanja()
	{
		return Rok_trajanja;
	}

	public String getVrsta()
	{
		return Vrsta;
	}

	public void setLijekID(int lijekID)
	{
		this.lijekID = lijekID;
	}

	public void setNaziv(String naziv)
	{
		Naziv = naziv;
	}

	public void setRok_trajanja(Date rok_trajanja)
	{
		Rok_trajanja = rok_trajanja;
	}

	public void setVrsta(String vrsta)
	{
		Vrsta = vrsta;
	}

}