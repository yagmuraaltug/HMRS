package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobAdvert;

public interface JobAdvertService {
	
	Result add(JobAdvert jobAdvert);
	
	Result update(JobAdvert jobAdvert);
	
	Result delete(int id);
	
	Result changeStatus(int id);
	
	DataResult<List<JobAdvert>> getAll();
	
	DataResult<List<JobAdvert>> findByIsActiveTrue();
	
	DataResult<List<JobAdvert>> findAllByIsActiveTrueOrderByPublishedAtDesc();

	DataResult<List<JobAdvert>> findByIsActiveTrueAndCompany_CompanyName(String companyName);

	DataResult<JobAdvert> getById(int id);

	DataResult<List<JobAdvert>> getAllByCompanyId(int userId);
	
	DataResult<List<JobAdvert>> findJobsByCityId(int cityId);

	Result updateconfirmStatus(int id);
	
	DataResult<List<JobAdvert>>getByConfirmStatusFalse();
}
