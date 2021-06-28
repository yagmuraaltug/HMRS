package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvLanguage;

public interface CvLanguageService {

	DataResult<List<CvLanguage>> findByJobSeekerId(int id);
	DataResult<List<CvLanguage>> getAll();
	Result add(CvLanguage cvLanguage);
	Result update(CvLanguage cvLanguage);
	Result delete(int id);

}
