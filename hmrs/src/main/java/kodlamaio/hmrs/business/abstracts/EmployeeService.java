package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employee;

public interface EmployeeService {
           DataResult<List<Employee>> getAll();
       	   DataResult<Employee> getById(int userId);	
           Result add(Employee employee); 
           Result delete(int userId); 
           Result update(Employee employee); 

}
