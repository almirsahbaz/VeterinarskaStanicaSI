package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IzvrseneUsluge
{

	@Id
	@GeneratedValue
	private int izvrsenaUslugaID;

	@JoinColumn(nullable = false)
	@ManyToOne
	public Racuni racuni;

	@JoinColumn(nullable = false)
	@ManyToOne
	public Usluge usluge;

	public int getIzvrsenaUslugaID()
	{
		return izvrsenaUslugaID;
	}

	public Racuni getRacuni()
	{
		return racuni;
	}

	public Usluge getUsluge()
	{
		return usluge;
	}

	public void setIzvrsenaUslugaID(int izvrsenaUslugaID)
	{
		this.izvrsenaUslugaID = izvrsenaUslugaID;
	}

	public void setRacuni(Racuni racuni)
	{
		this.racuni = racuni;
	}

	public void setUsluge(Usluge usluge)
	{
		this.usluge = usluge;
	}

}