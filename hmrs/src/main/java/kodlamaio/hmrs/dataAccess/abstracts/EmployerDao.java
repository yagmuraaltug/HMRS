package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
