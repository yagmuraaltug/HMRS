package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hmrs.entities.concretes.JobType;

public interface JobTypeDao extends JpaRepository<JobType, Integer>{

	JobType getById(int id);

}
