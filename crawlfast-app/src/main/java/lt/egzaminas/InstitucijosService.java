package lt.egzaminas;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class InstitucijosService {

	@Autowired
	private InstitucijosRepository institucijosRepository;

	public List<InstitucijaKlientui> gautiVisasInstitucijas() {
		List<Institucija> institucijosIsDuombazes = getInstitucijosRepository().findAll();
		List<InstitucijaKlientui> institucijosKlientui = institucijosIsDuombazes.stream().map((institucija) -> {
			InstitucijaKlientui inst = new InstitucijaKlientui();
			inst.setPavadinimas(institucija.getPavadinimas());
			inst.setMiestas(institucija.getMiestas());
			inst.setNuotrauka(institucija.getNuotrauka());
			inst.setKategorija(institucija.getKategorija());

			return inst;
		}).collect(Collectors.toList());
		return institucijosKlientui;
	}

	public void pridetiNaujaInstitucija(NaujaInstitucija naujaInstitucija) {
		Institucija instit = new Institucija();
		instit.setPavadinimas(naujaInstitucija.getPavadinimas());
		instit.setMiestas(naujaInstitucija.getMiestas());
		instit.setNuotrauka(naujaInstitucija.getNuotrauka());
		instit.setKategorija(naujaInstitucija.getKategorija());
		institucijosRepository.save(instit);
	}

	public void istrintiInstitucija(Long id) {
		institucijosRepository.delete(id);
	}

	public void atnaujintiInstitucija(Institucija institucija, Long id) {
		Institucija inst = institucijosRepository.findOne(id);
		inst.setPavadinimas(institucija.getPavadinimas());
		inst.setMiestas(institucija.getMiestas());
		inst.setNuotrauka(institucija.getNuotrauka());
		inst.setKategorija(institucija.getKategorija());
		institucijosRepository.save(inst);
	}

	public InstitucijosRepository getInstitucijosRepository() {
		return institucijosRepository;
	}

	public void setInstitucijosRepository(InstitucijosRepository institucijosRepository) {
		this.institucijosRepository = institucijosRepository;
	}
}
