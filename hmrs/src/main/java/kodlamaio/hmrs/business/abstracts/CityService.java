package kodlamaio.hmrs.business.abstracts;

import java.util.List;


import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();
	
}
