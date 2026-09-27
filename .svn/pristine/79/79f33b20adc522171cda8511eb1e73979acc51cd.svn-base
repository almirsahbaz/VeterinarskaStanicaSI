package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Gradovi
{
	@Id
	@GeneratedValue
	private int GradID;
	@Column(nullable = false)
	private String Naziv;

	public int getGradID()
	{
		return GradID;
	}

	public String getNaziv()
	{
		return Naziv;
	}

	public void setGradID(int gradID)
	{
		GradID = gradID;
	}

	public void setNaziv(String naziv)
	{
		Naziv = naziv;
	}
}
