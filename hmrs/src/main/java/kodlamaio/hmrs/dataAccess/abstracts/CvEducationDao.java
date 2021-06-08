package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CvEducation;

public interface CvEducationDao extends JpaRepository<CvEducation, Integer>{

	List<CvEducation> findByJobSeekerId(int id);
	List<CvEducation> getAllByJobSeeker_idOrderByGraduationDateDesc(int id);

}
