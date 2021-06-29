package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CityService;
import kodlamaio.hmrs.core.utilities.Business.BusinessRules;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CityDao;
import kodlamaio.hmrs.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Cities Listed!");

	}

	@Override
	public DataResult<City> getByCityName(int cityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(City city) {
		Result result=BusinessRules.run(cityNameExists(city));
		if (result.isSuccess()) {
			this.cityDao.save(city);
			return new SuccessResult("City added!");
		}
		return result;
	}

	@Override
	public Result update(City city) {
		Result result=BusinessRules.run(cityNameExists(city));
		if (result.isSuccess()) {
			this.cityDao.save(city);
			return new SuccessResult("City updated");
		}
		return result;
	}

	@Override
	public Result delete(int cityId) {
		this.cityDao.deleteById(cityId);
		return new SuccessResult("City deleted");
	}
	
	private Result cityNameExists(City city) {
		if(cityDao.findAllByCityName(city.getCityName().toUpperCase()).stream().count()!=0) {
			return new ErrorResult("The city name is already exists!");
		}
		return new SuccessResult();
	}
	

}
