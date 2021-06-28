package kodlamaio.hmrs.business.abstracts;

import java.util.List;


import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	DataResult<Employer> getById(int userId);	
	Result add(Employer employer);
	Result delete(int userId);
	Result update(Employer employer);

}
