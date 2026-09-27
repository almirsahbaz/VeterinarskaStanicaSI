package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usluge
{

	@Id
	@GeneratedValue
	private int uslugaID;

	private String naziv;

	private Date datumUsluge;

	public Date getDatumUsluge()
	{
		return datumUsluge;
	}

	public String getNaziv()
	{
		return naziv;
	}

	public int getUslugaID()
	{
		return uslugaID;
	}

	public void setDatumUsluge(Date datumUsluge)
	{
		this.datumUsluge = datumUsluge;
	}

	public void setNaziv(String naziv)
	{
		this.naziv = naziv;
	}

	public void setUslugaID(int uslugaID)
	{
		this.uslugaID = uslugaID;
	}

}