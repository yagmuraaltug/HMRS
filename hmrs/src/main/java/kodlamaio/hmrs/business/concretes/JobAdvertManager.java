package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobAdvertService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hmrs.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobAdvertDao;
	
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		if(!CheckField(jobAdvert)) {
			return new ErrorResult("Please enter valid information!");
		}
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("The job advert is added to system!");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("The job advert is updated!");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertDao.deleteById(id);
		return new SuccessResult("The job advert is deleted from the system!");
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getById(id));
	} 
	
	@Override
	public Result changeStatus(int id) {
		JobAdvert jobAdvert = this.jobAdvertDao.getById(id);
        if(jobAdvert == null) {
        	return new ErrorResult("Sorry we could not find the job advert, please check it again.");
	}
	if(jobAdvert.getIsActive() == false) {
    	return new ErrorResult("The job advert is already closed!");

	}
	jobAdvert.setIsActive(jobAdvert.getIsActive());
	jobAdvert.setIsActive(false);
	update(jobAdvert);
	return new SuccessResult("The job advert has been closed!");
	
		
}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvert>> findByIsActiveTrue() {
		 return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvert>> findAllByIsActiveTrueOrderByPublishedAtDesc() {
		 return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAllByIsActiveTrueOrderByPublishedAtDesc());

	}

	@Override
	public DataResult<List<JobAdvert>> findByIsActiveTrueAndCompany_CompanyName(String companyName) {
		 return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findByIsActiveTrueAndEmployer_CompanyName(companyName));

	}

	
	// Business Rules
	
	private boolean CheckField(JobAdvert jobAdvert) {
		
		if(jobAdvert.getJobPosition() != null && 
		jobAdvert.getDescription() != null && 
		jobAdvert.getCity() != null &&
		jobAdvert.getOpenPositionNumber() != 0)
		{
			return true;

		}
		return false;

	}






}
