package lt.egzaminas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/institucija/knyga")
public class KnygosController {

	@Autowired
	private KnygosService knygosService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<KnygaKlientui> grazintiVisasKnygas(){
		return getKnygosService().gautiVisasKnygas();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void sukurtiNaujaKnyga(@RequestBody final NaujaKnyga naujaKnyga){
		knygosService.pridetiNaujaKnyga(naujaKnyga);
	}
	
	@RequestMapping(path= "/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void istrintiKnygaIsDuombazes(@PathVariable final Long id) {
		knygosService.istrintiKnyga(id);
	}
	
	@RequestMapping(path= "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public void atnaujintiKnygosDuomenis(@RequestBody final Knyga knyga, @PathVariable final Long id ) {
		knygosService.atnaujintiKnyga(knyga, id);
	}
	
	public KnygosService getKnygosService() {
		return knygosService;
	}

	public void setKnygosService(KnygosService knygosService) {
		this.knygosService = knygosService;
	}
}
