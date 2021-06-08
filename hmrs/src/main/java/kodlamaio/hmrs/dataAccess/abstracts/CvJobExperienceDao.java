package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CvJobExperience;


public interface CvJobExperienceDao extends JpaRepository<CvJobExperience, Integer>{

	List<CvJobExperience> findByJobSeekerId(int id);
	List<CvJobExperience> getAllByJobSeeker_idOrderByEndDateDesc(int id);
}
