package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Odjeli
{
	@GeneratedValue
	@Id
	private int OdjelID;

	@Column(nullable = false)
	private String Naziv;

	public String getNaziv()
	{
		return Naziv;
	}

	public int getZvanjeID()
	{
		return OdjelID;
	}

	public void setNaziv(String naziv)
	{
		Naziv = naziv;
	}

	public void setZvanjeID(int odjelID)
	{
		OdjelID = odjelID;
	}

}
