package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UspostavljenaDijagnoza
{

	@Id
	@GeneratedValue
	private int UspostavljenaDijagnozaID;

	private int intezitet;

	private String komentar;

	@JoinColumn(nullable = false)
	@ManyToOne
	public Pregledi pregledi;

	@JoinColumn(nullable = false)
	@ManyToOne
	public Dijagnoze dijagnoze;

	public Dijagnoze getDijagnoze()
	{
		return dijagnoze;
	}

	public int getIntezitet()
	{
		return intezitet;
	}

	public String getKomentar()
	{
		return komentar;
	}

	public Pregledi getPregledi()
	{
		return pregledi;
	}

	public int getUspostavljenaDijagnozaID()
	{
		return UspostavljenaDijagnozaID;
	}

	public void setDijagnoze(Dijagnoze dijagnoze)
	{
		this.dijagnoze = dijagnoze;
	}

	public void setIntezitet(int intezitet)
	{
		this.intezitet = intezitet;
	}

	public void setKomentar(String komentar)
	{
		this.komentar = komentar;
	}

	public void setPregledi(Pregledi pregledi)
	{
		this.pregledi = pregledi;
	}

	public void setUspostavljenaDijagnozaID(int uspostavljenaDijagnozaID)
	{
		this.UspostavljenaDijagnozaID = uspostavljenaDijagnozaID;
	}

}