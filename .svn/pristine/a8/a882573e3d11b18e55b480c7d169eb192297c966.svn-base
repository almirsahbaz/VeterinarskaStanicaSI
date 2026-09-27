package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pacijent
{

	@Id
	@GeneratedValue
	private int pacijentID;

	private String ime;

	private Date godiste;

	private Date datumPrijema;

	@JoinColumn(nullable = false)
	@ManyToOne
	public Vlasnik vlasnik;

	@JoinColumn(nullable = false)
	@ManyToOne
	public Vrsta vrsta;

	public Date getDatumPrijema()
	{
		return datumPrijema;
	}

	public Date getGodiste()
	{
		return godiste;
	}

	public String getIme()
	{
		return ime;
	}

	public int getPacijentID()
	{
		return pacijentID;
	}

	public Vlasnik getVlasnik()
	{
		return vlasnik;
	}

	public Vrsta getVrsta()
	{
		return vrsta;
	}

	public void setDatumPrijema(Date datumPrijema)
	{
		this.datumPrijema = datumPrijema;
	}

	public void setGodiste(Date godiste)
	{
		this.godiste = godiste;
	}

	public void setIme(String ime)
	{
		this.ime = ime;
	}

	public void setPacijentID(int pacijentID)
	{
		this.pacijentID = pacijentID;
	}

	public void setVlasnik(Vlasnik vlasnik)
	{
		this.vlasnik = vlasnik;
	}

	public void setVrsta(Vrsta vrsta)
	{
		this.vrsta = vrsta;
	}

}