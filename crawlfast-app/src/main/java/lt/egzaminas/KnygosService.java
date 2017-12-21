package lt.egzaminas;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class KnygosService {

	@Autowired
	private KnyguRepository knyguRepository;

	public List<KnygaKlientui> gautiVisasKnygas() {
		List<Knyga> knygosIsDuombazes = getKnyguRepository().findAll();
		List<KnygaKlientui> knygosKlientui = knygosIsDuombazes.stream().map((knyga) -> {
			KnygaKlientui kn = new KnygaKlientui();
			kn.setPavadinimas(knyga.getPavadinimas());
			kn.setAutorius(knyga.getAutorius());
			kn.setPuslapiuSkaicius(knyga.getPuslapiuSkaicius());
			kn.setPaveiksliukas(knyga.getPaveiksliukas());
			kn.setKaina(knyga.getKaina());
			kn.setBukle(knyga.getBukle());
			kn.setKiekis(knyga.getKiekis());
			
			return kn;
		}).collect(Collectors.toList());
		return knygosKlientui;
	}

	public KnyguRepository getKnyguRepository() {
		return knyguRepository;
	}

	public void setKnyguRepository(KnyguRepository knyguRepository) {
		this.knyguRepository = knyguRepository;
	}

	public void pridetiNaujaKnyga(NaujaKnyga naujaKnyga) {
		Knyga knyg = new Knyga();
		knyg.setPavadinimas(naujaKnyga.getPavadinimas());
		knyg.setAutorius(naujaKnyga.getAutorius());
		knyg.setPuslapiuSkaicius(naujaKnyga.getPuslapiuSkaicius());
		knyg.setPaveiksliukas(naujaKnyga.getPaveiksliukas());
		knyg.setKaina(naujaKnyga.getKaina());
		knyg.setBukle(naujaKnyga.getBukle());
		knyg.setKiekis(naujaKnyga.getKiekis());
		knyguRepository.save(knyg);
	}

	public void istrintiKnyga(Long id) {
		knyguRepository.delete(id);
	}

	public void atnaujintiKnyga(Knyga knyga, Long id) {
		Knyga knyg = knyguRepository.findOne(id);
		knyg.setPavadinimas(knyga.getPavadinimas());
		knyg.setAutorius(knyga.getAutorius());
		knyg.setPuslapiuSkaicius(knyga.getPuslapiuSkaicius());
		knyg.setPaveiksliukas(knyga.getPaveiksliukas());
		knyg.setKaina(knyga.getKaina());
		knyg.setBukle(knyga.getBukle());
		knyg.setKiekis(knyga.getKiekis());
		knyguRepository.save(knyg);
	}
}
