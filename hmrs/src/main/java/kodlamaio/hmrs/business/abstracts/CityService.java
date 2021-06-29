package kodlamaio.hmrs.business.abstracts;

import java.util.List;


import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();
	DataResult<City> getByCityName(int cityName);
	Result add(City city);
	Result update(City city);
	Result delete(int cityId);
}
