package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Zvanje
{
	@GeneratedValue
	@Id
	private int ZvanjeID;

	@Column(nullable = false)
	private String Naziv;

	public String getNaziv()
	{
		return Naziv;
	}

	public int getZvanjeID()
	{
		return ZvanjeID;
	}

	public void setNaziv(String naziv)
	{
		Naziv = naziv;
	}

	public void setZvanjeID(int zvanjeID)
	{
		ZvanjeID = zvanjeID;
	}

}
