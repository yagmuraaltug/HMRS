package kodlamaio.hmrs.business.concretes;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvEducationService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CvEducationDao;
import kodlamaio.hmrs.entities.concretes.CvEducation;

@Service
public class CvEducationManager implements CvEducationService{

	private CvEducationDao cvEducationDao;
	@Autowired
	public CvEducationManager(CvEducationDao cvEducationDao) {
		super();
		this.cvEducationDao = cvEducationDao;
	}

	@Override
	public DataResult<List<CvEducation>> findByJobSeekerId(int id) {
		return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.findByJobSeekerId(id));
	}

	
	@Override
	public Result add(CvEducation cvEducation) {
		var result = this.cvEducationDao.save(cvEducation);
		if(result != null) {
			return new SuccessResult("Educational informations are added to your CV");
		}
		return new ErrorResult("Sorry there is a problem please check your answers.");
	}

	@Override
	public DataResult<List<CvEducation>> getAllByJobSeeker_idOrderByGraduationDateDesc(int id) {
		return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.getAllByJobSeeker_idOrderByGraduationDateDesc(id));

	}

}
