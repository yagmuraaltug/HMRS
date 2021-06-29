package kodlamaio.hmrs.api.controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	

	
	@GetMapping("/findByJobSeekerId")
	public DataResult<List<CvEducation>> findByJobSeekerId(@RequestParam int id){
		return this.cvEducationService.findByJobSeekerId(id);
	}
	
    @PostMapping("/add")
    public Result add(@RequestBody CvEducation cvEducation){
        return this.cvEducationService.add(cvEducation);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
    	return ResponseEntity.ok(this.cvEducationService.delete(id));
    }
    
    
    @PutMapping("/update")
    public ResponseEntity<?> update(@Valid @RequestBody CvEducation cvEducation){
    	return ResponseEntity.ok(this.cvEducationService.update(cvEducation));
    }
    
	@GetMapping("/getAllByJobSeekeridOrderByGraduationDateDesc")
	public DataResult<List<CvEducation>> getAllByJobSeeker_idOrderByGraduationDateDesc(@RequestParam int id){
		return this.cvEducationService.getAllByJobSeeker_idOrderByGraduationDateDesc(id);
	}
}
