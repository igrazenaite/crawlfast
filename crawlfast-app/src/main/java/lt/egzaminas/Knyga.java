package lt.egzaminas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Knyga {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(unique = true)
	private String pavadinimas;
	private String autorius;
	private int puslapiuSkaicius;
	private String paveiksliukas;
	private double kaina;
	private String bukle;
	private int kiekis;

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

	public String getAutorius() {
		return autorius;
	}

	public void setAutorius(String autorius) {
		this.autorius = autorius;
	}

	public int getPuslapiuSkaicius() {
		return puslapiuSkaicius;
	}

	public void setPuslapiuSkaicius(int puslapiuSkaicius) {
		this.puslapiuSkaicius = puslapiuSkaicius;
	}

	public String getPaveiksliukas() {
		return paveiksliukas;
	}

	public void setPaveiksliukas(String paveiksliukas) {
		this.paveiksliukas = paveiksliukas;
	}

	public double getKaina() {
		return kaina;
	}

	public void setKaina(double kaina) {
		this.kaina = kaina;
	}

	public String getBukle() {
		return bukle;
	}

	public void setBukle(String bukle) {
		this.bukle = bukle;
	}

	public int getKiekis() {
		return kiekis;
	}

	public void setKiekis(int kiekis) {
		this.kiekis = kiekis;
	}

}
