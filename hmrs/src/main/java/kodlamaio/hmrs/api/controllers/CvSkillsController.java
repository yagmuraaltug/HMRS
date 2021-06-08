package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CvSkillService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvSkill;

@RestController
@RequestMapping("api/cv_skill")
public class CvSkillsController {

	private CvSkillService cvSkillService;

	
	@Autowired
	public CvSkillsController(CvSkillService cvSkillService) {
		super();
		this.cvSkillService = cvSkillService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvSkill>> getAll(){		
		return this.cvSkillService.getAll();
	}
	
	@GetMapping("/findByJobSeekerId")
	public DataResult<List<CvSkill>> findByJobSeekerId(@RequestParam int id){
		return this.cvSkillService.findByJobSeekerId(id);
	}
	


	@PostMapping("/add")
	public Result add(@RequestBody CvSkill cvSkill){
		return this.cvSkillService.add(cvSkill);
	}

}
