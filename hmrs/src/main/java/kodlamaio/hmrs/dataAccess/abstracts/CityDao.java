package kodlamaio.hmrs.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {


	
}
