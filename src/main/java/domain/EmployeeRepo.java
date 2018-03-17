package domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface EmployeeRepo extends JpaRepository<Department, Integer> {

	  /*@Modifying
	  @Query("delete from Department u where u.deptid = ?1")
	  int  deleteInBulkById(Integer eid);

	@Modifying
	 @Query("update Employee u set u.name = ?1  where u.id = ?2")
	 int setUserInfoById(String name, Integer userId);*/
}
