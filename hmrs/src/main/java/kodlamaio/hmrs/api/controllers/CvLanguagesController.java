package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CvLanguageService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvLanguage;

@RestController
@RequestMapping("api/cv_languages")
public class CvLanguagesController {
	
	private CvLanguageService cvLanguageService;

	@Autowired
	public CvLanguagesController(CvLanguageService cvLanguageService) {
		super();
		this.cvLanguageService = cvLanguageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvLanguage>> getAll(){		
		return this.cvLanguageService.getAll();
	}
	
	@GetMapping("/findByJobSeekerId")
	public DataResult<List<CvLanguage>> findByJobSeekerId(@RequestParam int id){
		return this.cvLanguageService.findByJobSeekerId(id);
	}
	


	@PostMapping("/add")
	public Result add(@RequestBody CvLanguage cvLanguage){
		return this.cvLanguageService.add(cvLanguage);
	}

}
