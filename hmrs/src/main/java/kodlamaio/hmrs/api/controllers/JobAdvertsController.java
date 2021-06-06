package kodlamaio.hmrs.api.controllers;

import java.util.List;

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
		

}