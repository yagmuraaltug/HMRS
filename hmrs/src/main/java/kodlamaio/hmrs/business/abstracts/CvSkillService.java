package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.CvSkill;

public interface CvSkillService {

	DataResult<List<CvSkill>> findByJobSeekerId(int id);
	DataResult<List<CvSkill>> getAll();
	Result add(CvSkill cvSkill);
	Result delete(int id);
	Result update(CvSkill cvSkill);

}
