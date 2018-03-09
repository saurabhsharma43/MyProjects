package domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
/*@Query("select name from Employee e where e.id=?1")
	String reterievbyid(Integer id);*/

@Modifying
@Query("update Employee e set e.name=?1 where e.id=?2")
void updatebtid( String name,Integer id);

/*@Modifying
@Query("delete from Employee a where a.id=?1")
int deletebyId(Integer id);
*/

}
