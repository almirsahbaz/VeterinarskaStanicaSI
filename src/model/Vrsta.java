package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vrsta
{

	@Id
	@GeneratedValue
	private int vrstaID;

	private String Naziv;

	public String getImeVrste()
	{
		return Naziv;
	}

	public int getVrstaID()
	{
		return vrstaID;
	}

	public void setNazivVrste(String ime)
	{
		this.Naziv = ime;
	}

	public void setVrstaID(int vrstaID)
	{
		this.vrstaID = vrstaID;
	}

}