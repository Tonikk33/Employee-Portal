package portal.repository;

import portal.entity.CompanyEmployee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyEmployeeRepository extends JpaRepository<CompanyEmployee, Integer> {
}
