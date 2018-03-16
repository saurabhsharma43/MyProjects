package springdatajpamanytomany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	 private static Main main;

	    @Autowired
	    private EmployeeRepository employeeRepository;

	    public static void main(String[] args)
	    {
	        // Reading the Configuration file
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");

	        // Get the SaveLogic bean
	        main = (Main) context.getBean("main");
	        main.retrieveEmployee();
	        main.saveEmployee();
	        main.update("UP", 1);
           // main.delete(1);
          
	        context.close();
	    }

	    public void saveEmployee()
	    {
	        //Create a new Employee object employee1
	        Employee employee1 = new Employee();
	        employee1.setEmpName("JIP1");
	        
	        //Create a new Employee object employee2
	        /*Employee employee2 = new Employee();
	        employee2.setEmpName("JIP2");*/
	        
	        //Create a new Address object address1
	        Address address1 = new Address();
	        address1.setStreet("Street 1");
	        address1.setCity("City 1");
	        address1.setCountry("Country 1");
	        address1.setState("State 1");

	        /*//Create a new Address object address2
	        Address address2 = new Address();
	        address2.setStreet("Street 2");
	        address2.setCity("City 2");
	        address2.setCountry("Country 2");
	        address2.setState("State 2");*/

	        //Adding address1 and address2 to addressSet
	        Set<Address> addressSet = new HashSet<Address>();
	        addressSet.add(address1);
	        //addressSet.add(address2);
	       
	        employee1.setAddress(addressSet);
	        //employee2.setAddress(addressSet);
	        
	        //Add both employee object to a list
	        List<Employee> empList= new ArrayList<Employee>();
	        empList.add(employee1);
	        //empList.add(employee2);
	        
	        //Saving the empList
	        employeeRepository.save(empList);
	        
	        System.out.println("Employee and Employee Address saved successfully!!");
	    }
	    
	    public void update(String state, Integer id)
	    {
	    	employeeRepository.setaddressinfobyid(state, id);
	    }
	    
	    public void delete(Integer id)
	    
	    {
	    	employeeRepository.delete(id);
	    }
	    public void retrieveEmployee()
	    {
	        // Get list of all Employee & Address
	        List<Employee> employeeList = employeeRepository.findAll();

	        // Displaying the Employee details
	        for (Employee employee : employeeList)
	        {
	            System.out.println("*** Employee Details ***");

	            System.out.println("Employee Id   : " + employee.getEmpId());
	            System.out.println("Employee Name : " + employee.getEmpName());

	            System.out.println("*** Employee Address Details ***");
	            Set<Address> empAddressSet = employee.getAddress();
	            for (Address employeeAddress : empAddressSet)
	            {
	                System.out.println("Street  : " + employeeAddress.getStreet());
	                System.out.println("City    : " + employeeAddress.getCity());
	                System.out.println("State   : " + employeeAddress.getState());
	                System.out.println("Country : " + employeeAddress.getCountry());
	            }
	        }
	    }
	    
}
