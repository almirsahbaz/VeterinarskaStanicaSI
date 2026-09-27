package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DefinsanaTerapija
{
	@Id
	@GeneratedValue
	private int definisanaTerapijaID;

	private int doziranje;

	@JoinColumn(nullable = false)
	@ManyToOne
	public Terapija terapija;
	@JoinColumn(nullable = false)
	@ManyToOne
	public Pregledi pregledi;

	public int getDefinisanaTerapijaID()
	{
		return definisanaTerapijaID;
	}

	public int getDoziranje()
	{
		return doziranje;
	}

	public Pregledi getPregledi()
	{
		return pregledi;
	}

	public Terapija getTerapija()
	{
		return terapija;
	}

	public void setDefinisanaTerapijaID(int definisanaTerapijaID)
	{
		this.definisanaTerapijaID = definisanaTerapijaID;
	}

	public void setDoziranje(int doziranje)
	{
		this.doziranje = doziranje;
	}

	public void setPregledi(Pregledi pregledi)
	{
		this.pregledi = pregledi;
	}

	public void setTerapija(Terapija terapija)
	{
		this.terapija = terapija;
	}

}