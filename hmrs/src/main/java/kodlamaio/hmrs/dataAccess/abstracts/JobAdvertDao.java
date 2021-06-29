package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hmrs.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{

	JobAdvert getByJobPosition_Id(int id);
	
	List<JobAdvert> findByIsActiveTrue();
	
	List<JobAdvert> findByIsActiveTrueAndEmployer_CompanyName(String companyName);
	
	List<JobAdvert> findAllByIsActiveTrueOrderByPublishedAtDesc();
	
	JobAdvert getById(Integer id);

	List<JobAdvert> getByConfirmStatusFalse();
	
	List<JobAdvert> findByEmployer_UserId(int userId);

	List<JobAdvert> findJobByCity_CityId(int cityId);


	@Modifying
	@Query("update JobAdvert set confirmStatus=true where id=:id")
	int updateconfirmStatus(@Param("id")int id);
	
}
