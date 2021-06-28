package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobPosition;

public interface JobPositionService {
	

	List <JobPosition> getAll();
	DataResult<JobPosition> getById(int id);	
	Result add(JobPosition jobPosition);
	Result delete(int id);
	Result update(JobPosition jobPosition);

}
