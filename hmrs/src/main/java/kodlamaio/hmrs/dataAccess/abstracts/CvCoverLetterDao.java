package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CvCoverLetter;

public interface CvCoverLetterDao extends JpaRepository<CvCoverLetter, Integer>{

	
	List<CvCoverLetter> findByJobSeekerId(int id);

}
