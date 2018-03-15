package springdatajpamanytomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Modifying 
	@Query("update Address u set u.state = ?1  where u.id = ?2")
	int setaddressinfobyid(String state, Integer id);
	
	@Query("delete from Address a where a.id=?1")
	int deletebyid(Integer id);
}
