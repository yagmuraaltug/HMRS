package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvJobExperience;

public interface CvJobExperienceService {

	Result add(CvJobExperience cvJobExperience);
	Result delete(CvJobExperience cvJobExperience);
	DataResult<List<CvJobExperience>> findByJobSeekerId(int id);
	DataResult<List<CvJobExperience>> getAllByJobSeeker_idOrderByGraduationDateDesc(int id);
}
