package kodlamaio.hmrs.api.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobAdvertService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobAdvert;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/job_adverts")
public class JobAdvertsController {
	
	private JobAdvertService jobAdvertService;

	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvert>> getAll(){		
		return this.jobAdvertService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobAdvert> getById(@RequestParam int id){
		return this.jobAdvertService.getById(id);
	}
	


	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert){
		return this.jobAdvertService.add(jobAdvert);
	}
	
	 @GetMapping("/isActive")
	    public DataResult<List<JobAdvert>> isActive() {
	        return this.jobAdvertService.findByIsActiveTrue();
	    }

	 @GetMapping("/getaisactivetrueandorderbydate")
	    public DataResult<List<JobAdvert>> getaIsActiveTrueAndOrderByDate() {
	        return this.jobAdvertService.findAllByIsActiveTrueOrderByPublishedAtDesc();
	    }
	 

	    @GetMapping("/getallactivetruebycompany")
	    public DataResult<List<JobAdvert>> getAllActiveByTrueByCompany(String companyName) {
	        return this.jobAdvertService.findByIsActiveTrueAndCompany_CompanyName(companyName);
	    }
	    
	    @PutMapping("/changestatus")
	    public Result changeStatus(int id) {
	        return this.jobAdvertService.changeStatus(id);
	    }
	    
		@PutMapping("/update")
		public ResponseEntity<?> update(@Valid @RequestBody JobAdvert jobAdvert){
			return ResponseEntity.ok(this.jobAdvertService.update(jobAdvert));
		}
		
		@DeleteMapping("/delete")
		public ResponseEntity<?> delete(@RequestParam int id){
			return ResponseEntity.ok(this.jobAdvertService.delete(id));
		}
		
		@PostMapping("/updateconfirmStatus")
		@Transactional
		public Result updateconfirmStatus(@RequestParam int id) {
			return this.jobAdvertService.updateconfirmStatus(id);
		}
		
		@GetMapping("/getConfirmStatusFalse")
		public ResponseEntity<?> getConfirmStatusFalse(){
			return ResponseEntity.ok(this.jobAdvertService.getByConfirmStatusFalse());
		}
		
		@GetMapping("/getAllByCompanyId")
		public DataResult<List<JobAdvert>> getAllByCompanyId(@RequestParam int userId){
			return this.jobAdvertService.getAllByCompanyId(userId);
		}
		
		
		@GetMapping("/getAllByCityId")
		public DataResult<List<JobAdvert>> getAllByCityId(@RequestParam int cityId){
			return this.jobAdvertService.findJobsByCityId(cityId);
		}

}