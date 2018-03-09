package domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
private static Main main;
@Autowired
private EmployeeRepo repository;
public static void main(String args[])
{
ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("SpringConfig.xml");
main=(Main)context.getBean("main");
//Integer emp1=main.addemployee("ram4");


//main.save();
//main.retrieve(4);
main.update("saurabh",3);
//main.delete(6);
main.retrieveEmployee();
main.deleteEmployee();
}
/*private Integer addemployee(String name) {
	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("SpringConfig.xml");
	Employee empid=null;
	Employee employee=new Employee();
	employee.setName(name);
	empid = repository.save(employee);
	return empid.getId();
}*/

/*private void delete(int id) {
	repository.deletebyId(id);
	
}*/


private void update(String name,Integer id) {
	repository.updatebtid(name,id);
	
}
/*private void retrieve(Integer id) {
	System.out.println(repository.reterievbyid(id));
	
}*/

public void retrieveEmployee()
{
    // Get list of all Employee & Employee Address
    List<Employee> empAddress =repository.findAll();

   // Displaying the Employee details
    for (Employee employeeAddress : empAddress)
    {
        System.out.println("*** Employee Details ***");

      
        System.out.println("Employee Id   : " +employeeAddress.getId());
        System.out.println("Employee Name : " +employeeAddress.getName());

  
    }
}

public void deleteEmployee()
{
	
	repository.deleteAll();
	
	
}



/*public void save() {

Employee emp=new Employee();
emp.setName("Aryan");
System.out.println(repository.save(emp));
	
	
}*/
}
