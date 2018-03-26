package springdataonetone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface EmployeeRepository extends JpaRepository<EmployeeAddress, Integer> {
@Modifying
@Query("update Employee_Address u set u.street = ?1  where u.id = ?2")
int updatebyid(String STREET ,Integer id);

}
