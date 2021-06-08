package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvLink;

public interface CvLinkService {
	DataResult<List<CvLink>> findByJobSeekerId(int id);
	DataResult<List<CvLink>> getAll();
	Result add(CvLink cvLink);


}
