package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobPositionService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hmrs.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}


	@Override
	public List<JobPosition> getAll() {
		return this.jobPositionDao.findAll();
	}


	@Override
	public DataResult<JobPosition> getById(int id) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.getById(id));

	}


	@Override
	public Result add(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("The skill added!");
	}


	@Override
	public Result delete(int id) {
		this.jobPositionDao.deleteById(id);
		return new SuccessResult("The skill deleted!");
	}


	@Override
	public Result update(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("The skill updated!");
	}

}
