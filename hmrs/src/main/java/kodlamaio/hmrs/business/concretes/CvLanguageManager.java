package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvLanguageService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CvLanguageDao;
import kodlamaio.hmrs.entities.concretes.CvLanguage;

@Service
public class CvLanguageManager implements CvLanguageService{

	private CvLanguageDao cvLanguageDao;

	public CvLanguageManager(CvLanguageDao cvLanguageDao) {
		super();
		this.cvLanguageDao = cvLanguageDao;
	}

	@Override
	public DataResult<List<CvLanguage>> findByJobSeekerId(int id) {
		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.findByJobSeekerId(id));

	}

	@Override
	public DataResult<List<CvLanguage>> getAll() {
		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.findAll());

	}

	@Override
	public Result add(CvLanguage cvLanguage) {
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("The language added!");
	}

}
