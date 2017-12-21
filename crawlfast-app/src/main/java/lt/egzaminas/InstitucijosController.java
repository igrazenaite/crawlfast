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
@RequestMapping(value = "/rest/institucija")
public class InstitucijosController {

		@Autowired
		private InstitucijosService institucijosService;
		
		
		@RequestMapping(method = RequestMethod.GET)
		public List<InstitucijaKlientui> grazintiVisasInstitucijas(){
			return getInstitucijosService().gautiVisasInstitucijas();
		}

		@RequestMapping(method = RequestMethod.POST)
		@ResponseStatus(HttpStatus.CREATED)
		public void sukurtiNaujaInstitucija(@RequestBody final NaujaInstitucija naujaInstitucija){
			institucijosService.pridetiNaujaInstitucija(naujaInstitucija);
		}
		
		@RequestMapping(path= "/{id}",method=RequestMethod.DELETE)
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void istrintiInstitucijaIsDuombazes(@PathVariable final Long id) {
			institucijosService.istrintiInstitucija(id);
		}
		
		@RequestMapping(path= "/{id}", method = RequestMethod.PUT)
		@ResponseStatus(HttpStatus.CREATED)
		public void atnaujintiInstitucijosDuomenis(@RequestBody final Institucija institucija, @PathVariable final Long id ) {
			institucijosService.atnaujintiInstitucija(institucija, id);
		}
		
		public InstitucijosService getInstitucijosService() {
			return institucijosService;
		}

		public void setInstitucijosService(InstitucijosService institucijosService) {
			this.institucijosService = institucijosService;
		}
}
