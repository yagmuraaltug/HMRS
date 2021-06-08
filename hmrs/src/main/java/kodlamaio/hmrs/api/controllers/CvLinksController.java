package kodlamaio.hmrs.api.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CvLinkService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvLink;

@RestController
@RequestMapping("api/cv-links")
public class CvLinksController {

	private CvLinkService cvLinkService;

	public CvLinksController(CvLinkService cvLinkService) {
		super();
		this.cvLinkService = cvLinkService;
	};
	
	@GetMapping("/getAll")
	public DataResult<List<CvLink>> getAll(){		
		return this.cvLinkService.getAll();
	}
	
	@GetMapping("/findByJobSeekerId")
	public DataResult<List<CvLink>> findByJobSeekerId(@RequestParam int id){
		return this.cvLinkService.findByJobSeekerId(id);
	}
	


	@PostMapping("/add")
	public Result add(@RequestBody CvLink cvLink){
		return this.cvLinkService.add(cvLink);
	}
	
}
