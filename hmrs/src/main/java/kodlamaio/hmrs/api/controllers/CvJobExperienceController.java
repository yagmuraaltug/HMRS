package kodlamaio.hmrs.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CvJobExperienceService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvJobExperience;

@RestController
@RequestMapping("api/cv_job_experience")
public class CvJobExperienceController {

	private CvJobExperienceService cvJobExperienceService;

	public CvJobExperienceController(CvJobExperienceService cvJobExperienceService) {
		super();
		this.cvJobExperienceService = cvJobExperienceService;
	}
	
	   @PostMapping("/add")
	    public Result add(@RequestBody CvJobExperience cvJobExperience){
	        return this.cvJobExperienceService.add(cvJobExperience);
	    }
	   
	   @DeleteMapping("/delete")
	    public ResponseEntity<?> delete(@RequestParam("id") int id){
	        return ResponseEntity.ok(cvJobExperienceService.delete(id));
	    }
	   
	   @PutMapping("/update")
		public ResponseEntity<?> update(@Valid @RequestBody CvJobExperience cvJobExperience) {
			return ResponseEntity.ok(this.cvJobExperienceService.update(cvJobExperience));
		}
	    
		@GetMapping("/getAllByJobSeekeridOrderByEndDateDesc")
		public DataResult<List<CvJobExperience>> getAllByJobSeeker_idOrderByEndDateDesc(@RequestParam int id){
			return this.cvJobExperienceService.getAllByJobSeeker_idOrderByGraduationDateDesc(id);
		}
		
		@GetMapping("/findByJobSeekerId")
		public DataResult<List<CvJobExperience>> findByJobSeekerId(@RequestParam int id){
			return this.cvJobExperienceService.findByJobSeekerId(id);
		}
		
		

}
