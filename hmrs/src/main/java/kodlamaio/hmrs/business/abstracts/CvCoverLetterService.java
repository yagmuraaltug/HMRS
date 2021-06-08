package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvCoverLetter;

public interface CvCoverLetterService {

	DataResult<List<CvCoverLetter>> findByJobSeekerId(int id);
	DataResult<List<CvCoverLetter>> getAll();
	Result add(CvCoverLetter cvCoverLetter);
}
