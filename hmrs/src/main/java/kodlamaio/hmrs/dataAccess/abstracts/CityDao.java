package kodlamaio.hmrs.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

	boolean existsByCityId(int cityId);
	City getByCityId(int cityId);
	City findCityByCityName(String cityName);
	List<City> findAllByCityName(String cityName);

	
}
