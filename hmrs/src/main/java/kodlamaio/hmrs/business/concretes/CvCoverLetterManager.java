package kodlamaio.hmrs.business.concretes;

import java.util.List
;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvCoverLetterService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CvCoverLetterDao;
import kodlamaio.hmrs.entities.concretes.CvCoverLetter;

@Service
public class CvCoverLetterManager implements CvCoverLetterService{

	
	private CvCoverLetterDao cvCoverLetterDao;
	
	@Autowired
	public CvCoverLetterManager(CvCoverLetterDao cvCoverLetterDao) {
		super();
		this.cvCoverLetterDao = cvCoverLetterDao;
	}

	@Override
	public DataResult<List<CvCoverLetter>> findByJobSeekerId(int id) {
		return new SuccessDataResult<List<CvCoverLetter>>(this.cvCoverLetterDao.findByJobSeekerId(id));

	}

	@Override
	public DataResult<List<CvCoverLetter>> getAll() {
		return new SuccessDataResult<List<CvCoverLetter>>(this.cvCoverLetterDao.findAll());

	}

	@Override
	public Result add(CvCoverLetter cvCoverLetter) {
		this.cvCoverLetterDao.save(cvCoverLetter);
		return new SuccessResult("Your cover letter is added!");
	}

	@Override
	public Result delete(int id) {
		this.cvCoverLetterDao.deleteById(id);
		return new SuccessResult("Your cover letter is deleted!");
	}

	@Override
	public Result update(CvCoverLetter cvCoverLetter) {
		this.cvCoverLetterDao.save(cvCoverLetter);
		return new SuccessResult("Your cover letter is updated!");
	}

}
