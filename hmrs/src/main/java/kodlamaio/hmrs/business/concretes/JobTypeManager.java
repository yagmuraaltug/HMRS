package kodlamaio.hmrs.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobTypeService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobTypeDao;
import kodlamaio.hmrs.entities.concretes.JobType;

@Service
public class JobTypeManager implements JobTypeService{

	private JobTypeDao jobTypeDao;
	@Autowired
	public JobTypeManager(JobTypeDao jobTypeDao) {
		super();
		this.jobTypeDao = jobTypeDao;
	}

	@Override
	public Result add(JobType jobType) {
		this.jobTypeDao.save(jobType);
		return new SuccessResult("Job Type Added");
	}

	@Override
	public DataResult<List<JobType>> getAll() {
		return new SuccessDataResult<List<JobType>>(this.jobTypeDao.findAll());
	}

	@Override
	public DataResult<JobType> getById(int id) {
		return new SuccessDataResult<JobType>(this.jobTypeDao.getById(id));

	}

	@Override
	public Result delete(int id) {
		this.jobTypeDao.deleteById(id);
		return new SuccessResult("Job Type Deleted");

	}

	@Override
	public Result update(JobType jobType) {
		this.jobTypeDao.save(jobType);
		return new SuccessResult("Job Type Updated");

	}
  
}
