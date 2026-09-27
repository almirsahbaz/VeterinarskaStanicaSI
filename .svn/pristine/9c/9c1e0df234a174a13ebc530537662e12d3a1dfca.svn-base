package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class KupljeniLijekovi
{

	@Id
	@GeneratedValue
	private int kupljeniLijekID;

	private int kolicina;

	@JoinColumn(nullable = false)
	@ManyToOne
	public Racuni racuni;

	@JoinColumn(nullable = false)
	@ManyToOne
	public Lijekovi lijekovi;

	public int getKolicina()
	{
		return kolicina;
	}

	public int getKupljeniLijekID()
	{
		return kupljeniLijekID;
	}

	public Lijekovi getLijekovi()
	{
		return lijekovi;
	}

	public Racuni getRacuni()
	{
		return racuni;
	}

	public void setKolicina(int kolicina)
	{
		this.kolicina = kolicina;
	}

	public void setKupljeniLijekID(int kupljeniLijekID)
	{
		this.kupljeniLijekID = kupljeniLijekID;
	}

	public void setLijekovi(Lijekovi lijekovi)
	{
		this.lijekovi = lijekovi;
	}

	public void setRacuni(Racuni racuni)
	{
		this.racuni = racuni;
	}

}