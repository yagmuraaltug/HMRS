package kodlamaio.hmrs.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvLinkService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CvLinkDao;
import kodlamaio.hmrs.entities.concretes.CvLink;

@Service
public class CvLinkManager implements CvLinkService{

	
	private CvLinkDao cvLinkDao;
	@Autowired
	public CvLinkManager(CvLinkDao cvLinkDao) {
		super();
		this.cvLinkDao = cvLinkDao;
	}
	@Override
	public DataResult<List<CvLink>> findByJobSeekerId(int id) {
		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.findByJobSeekerId(id));

	}
	@Override
	public DataResult<List<CvLink>> getAll() {
		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.findAll());

	}
	@Override
	public Result add(CvLink cvLink) {
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("The link added!");
	}
	@Override
	public Result delete(int id) {
		this.cvLinkDao.deleteById(id);
		return new SuccessResult("The link deleted!");
	}
	@Override
	public Result update(CvLink cvLink) {
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("The link updated!");
	}


}
