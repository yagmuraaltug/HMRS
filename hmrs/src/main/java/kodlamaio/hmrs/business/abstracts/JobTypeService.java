package kodlamaio.hmrs.business.abstracts;

import java.util.List
;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobType;

public interface JobTypeService {
	
	Result add(JobType jobType);
	DataResult<List<JobType>> getAll();
	DataResult<JobType> getById(int id);	
	Result delete(int id);
	Result update(JobType jobType);

}
