package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Doktori
{

	@Id
	@GeneratedValue
	private int doktorID;

	@JoinColumn(nullable = false)
	@ManyToOne
	private Zvanje zvanje;

	private String Pozicija;

	private String ime;

	private String prezime;

	@JoinColumn(nullable = false)
	@ManyToOne
	private KorisnickiNalog _nalog;

	@ManyToOne
	private Gradovi Grad;

	public int getDoktorID()
	{
		return doktorID;
	}

	public Gradovi getGrad()
	{
		return Grad;
	}

	public String getIme()
	{
		return ime;
	}

	public KorisnickiNalog getNalog()
	{
		return _nalog;
	}

	public String getPozicija()
	{
		return Pozicija;
	}

	public String getPrezime()
	{
		return prezime;
	}

	public Zvanje getZvanje()
	{
		return zvanje;
	}

	public void setDoktorID(int doktorID)
	{
		this.doktorID = doktorID;
	}

	public void setGrad(Gradovi grad)
	{
		Grad = grad;
	}

	public void setIme(String ime)
	{
		this.ime = ime;
	}

	public void setNalog(KorisnickiNalog Nalog)
	{
		_nalog = Nalog;
	}

	public void setPozicija(String pozicija)
	{
		Pozicija = pozicija;
	}

	public void setPrezime(String prezime)
	{
		this.prezime = prezime;
	}

	public void setZvanje(Zvanje Zvanje)
	{
		zvanje = Zvanje;
	}

}
