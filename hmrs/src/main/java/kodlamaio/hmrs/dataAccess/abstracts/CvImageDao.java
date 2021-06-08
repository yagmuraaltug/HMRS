package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CvImage;

public interface CvImageDao extends JpaRepository<CvImage, Integer>{

	List<CvImage> getByJobSeeker_id(int id);
}
