package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dijagnoze
{

	@Id
	@GeneratedValue
	private int dijagnozaID;

	private String Naziv_dijagnoze;
	private String Sifra_dijagnoze;

	public int getDijagnozaID()
	{
		return dijagnozaID;
	}

	public String getNaziv_bolesti()
	{
		return Naziv_dijagnoze;
	}

	public String getSifra_dijagnoze()
	{
		return Sifra_dijagnoze;
	}

	public void setDijagnozaID(int dijagnozaID)
	{
		this.dijagnozaID = dijagnozaID;
	}

	public void setNaziv_bolesti(String naziv_dijagnoze)
	{
		Naziv_dijagnoze = naziv_dijagnoze;
	}

	public void setSifra_dijagnoze(String sifra_dijagnoze)
	{
		Sifra_dijagnoze = sifra_dijagnoze;
	}

}