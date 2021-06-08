package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvSkillService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CvSkillDao;
import kodlamaio.hmrs.entities.concretes.CvSkill;

@Service
public class CvSkillManager implements CvSkillService{

	private CvSkillDao cvSkillDao;
	
	@Autowired
	public CvSkillManager(CvSkillDao cvSkillDao) {
		super();
		this.cvSkillDao = cvSkillDao;
	}

	@Override
	public DataResult<List<CvSkill>> findByJobSeekerId(int id) {
		return new SuccessDataResult<List<CvSkill>>(this.cvSkillDao.findByJobSeekerId(id));

	}

	@Override
	public DataResult<List<CvSkill>> getAll() {
		return new SuccessDataResult<List<CvSkill>>(this.cvSkillDao.findAll());

	}

	@Override
	public Result add(CvSkill cvSkill) {
		this.cvSkillDao.save(cvSkill);
		return new SuccessResult("The skill added!");
	}

}
