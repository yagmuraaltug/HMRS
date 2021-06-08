package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CvCoverLetterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvCoverLetter;

@RestController
@RequestMapping("api/cv_cover_letters")
public class CvCoverLettersController {

	private CvCoverLetterService cvCoverLetterService;

	@Autowired
	public CvCoverLettersController(CvCoverLetterService cvCoverLetterService) {
		super();
		this.cvCoverLetterService = cvCoverLetterService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvCoverLetter>> getAll(){		
		return this.cvCoverLetterService.getAll();
	}
	
	@GetMapping("/findByJobSeekerId")
	public DataResult<List<CvCoverLetter>> findByJobSeekerId(@RequestParam int id){
		return this.cvCoverLetterService.findByJobSeekerId(id);
	}
	


	@PostMapping("/add")
	public Result add(@RequestBody CvCoverLetter cvCoverLetter){
		return this.cvCoverLetterService.add(cvCoverLetter);
	}

}
