package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pregledi
{

	@Id
	@GeneratedValue
	private int pregledID;

	private Date datumPregleda;

	@JoinColumn(nullable = false)
	@ManyToOne
	public Doktori doktori;

	@JoinColumn(nullable = false)
	@ManyToOne
	public Pacijent pacijent;

	@JoinColumn(nullable = false)
	@ManyToOne
	public Racuni racuni;

	public Date getDatumPregleda()
	{
		return datumPregleda;
	}

	public Doktori getDoktori()
	{
		return doktori;
	}

	public Pacijent getPacijent()
	{
		return pacijent;
	}

	public int getPregledID()
	{
		return pregledID;
	}

	public Racuni getRacuni()
	{
		return racuni;
	}

	public void setDatumPregleda(Date datumPregleda)
	{
		this.datumPregleda = datumPregleda;
	}

	public void setDoktori(Doktori doktori)
	{
		this.doktori = doktori;
	}

	public void setPacijent(Pacijent pacijent)
	{
		this.pacijent = pacijent;
	}

	public void setPregledID(int pregledID)
	{
		this.pregledID = pregledID;
	}

	public void setRacuni(Racuni racuni)
	{
		this.racuni = racuni;
	}

}