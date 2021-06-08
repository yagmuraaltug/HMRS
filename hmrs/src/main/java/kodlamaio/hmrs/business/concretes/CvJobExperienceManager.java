package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvJobExperienceService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CvJobExperienceDao;
import kodlamaio.hmrs.entities.concretes.CvJobExperience;

@Service
public class CvJobExperienceManager implements CvJobExperienceService{

	private CvJobExperienceDao cvJobExperienceDao;
	
	@Autowired
	public CvJobExperienceManager(CvJobExperienceDao cvJobExperienceDao) {
		super();
		this.cvJobExperienceDao = cvJobExperienceDao;
	}

	@Override
	public Result add(CvJobExperience cvJobExperience) {
		this.cvJobExperienceDao.save(cvJobExperience);
		return new SuccessResult("The job experience added!");
	}

	@Override
	public Result delete(CvJobExperience cvJobExperience) {
		this.cvJobExperienceDao.delete(cvJobExperience);
		return new SuccessResult("The job experience deleted!");
	}

	@Override
	public DataResult<List<CvJobExperience>> findByJobSeekerId(int id) {
		return new SuccessDataResult<List<CvJobExperience>>(this.cvJobExperienceDao.findByJobSeekerId(id));

	}

	@Override
	public DataResult<List<CvJobExperience>> getAllByJobSeeker_idOrderByGraduationDateDesc(int id) {
		return new SuccessDataResult<List<CvJobExperience>>(this.cvJobExperienceDao.getAllByJobSeeker_idOrderByEndDateDesc(id));

	}

}
