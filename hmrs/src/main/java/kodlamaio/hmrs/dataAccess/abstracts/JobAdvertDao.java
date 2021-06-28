package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{

	JobAdvert getByJobPosition_Id(int id);
	
	List<JobAdvert> findByIsActiveTrue();
	
	List<JobAdvert> findByIsActiveTrueAndEmployer_CompanyName(String companyName);
	
	List<JobAdvert> findAllByIsActiveTrueOrderByPublishedAtDesc();
	
	JobAdvert getById(Integer id);

	
	
}
