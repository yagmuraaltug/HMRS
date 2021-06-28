package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	Employee getByUserId(int userId);

}
