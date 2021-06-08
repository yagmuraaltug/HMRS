package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CvEducationService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvEducation;

@RestController
@RequestMapping("api/cv_educations")
public class CvEducationsController {

	private CvEducationService cvEducationService;

	@Autowired
	public CvEducationsController(CvEducationService cvEducationService) {
		super();
		this.cvEducationService = cvEducationService;
	}
	
    @PostMapping("/add")
    public Result add(@RequestBody CvEducation cvEducation){
        return this.cvEducationService.add(cvEducation);
    }
    
	@GetMapping("/getAllByJobSeekeridOrderByGraduationDateDesc")
	public DataResult<List<CvEducation>> getAllByJobSeeker_idOrderByGraduationDateDesc(@RequestParam int id){
		return this.cvEducationService.getAllByJobSeeker_idOrderByGraduationDateDesc(id);
	}
}
