package lt.egzaminas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Institucija {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String pavadinimas;
	private String miestas;
	private String nuotrauka;
	private String kategorija;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public String getMiestas() {
		return miestas;
	}

	public void setMiestas(String miestas) {
		this.miestas = miestas;
	}

	public String getNuotrauka() {
		return nuotrauka;
	}

	public void setNuotrauka(String nuotrauka) {
		this.nuotrauka = nuotrauka;
	}

	public String getKategorija() {
		return kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}
}
