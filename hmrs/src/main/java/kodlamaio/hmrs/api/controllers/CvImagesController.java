package kodlamaio.hmrs.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.CvImageService;
import kodlamaio.hmrs.business.abstracts.JobSeekerService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvImage;
import kodlamaio.hmrs.entities.concretes.JobSeeker;

@RestController
@RequestMapping("api/cvImage")
public class CvImagesController {

	private CvImageService cvImageService;
	private JobSeekerService jobSeekerService;

	@Autowired
	public CvImagesController(CvImageService cvImageService, JobSeekerService jobSeekerService) {
		super();
		this.cvImageService = cvImageService;
		this.jobSeekerService = jobSeekerService;
	}
	

	@PostMapping(value = "/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile){
		JobSeeker seeker = this.jobSeekerService.getById(id).getData();
		CvImage cvImage = new CvImage();
		cvImage.setJobSeeker(seeker);
		return this.cvImageService.add(cvImage, imageFile);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody CvImage cvImage) {
		return this.cvImageService.update(cvImage);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.cvImageService.delete(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CvImage>> getAll(){
		return this.cvImageService.getAll();
	}
	
	@GetMapping("/findByJobSeekerId")
	public DataResult<List<CvImage>> findByJobSeekerId(@RequestParam int id){
		return this.cvImageService.findByJobSeekerId(id);
	}
	
}
