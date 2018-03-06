package springdataonetone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	  private static Main main;
	    
	    @Autowired
	    private EmployeeRepository employeeRepository;
	    
	    public static void main( String[] args )
	    {
	        //Reading the Configuration file
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
	        
	        //Get the SaveLogic bean
	        main = (Main)context.getBean("main");
	        
	        main.saveEmployee();
	        main.update("Delhi", 1);
	        main.retrieveEmployee();
	        context.close();
	    }
	    
	    public void saveEmployee()
	    {
	        Employee employee = new Employee();
	        employee.setEmpName("Saurabh");
	        
	        Employee_Address employeeAddress = new Employee_Address();
	        employeeAddress.setStreet("Noida");
	        employeeAddress.setCity("Noida");
	        employeeAddress.setCountry("India");
	        employeeAddress.setState("Uttar Pradesh");
	        
	        employee.setEmployeeAddress(employeeAddress);
	        employeeAddress.setEmployee(employee);
	        
	        employeeRepository.save(employeeAddress);
	        System.out.println("Employee and Employee Address saved successfully!!");
	  
	    }
	    
	    public void update(String STREET,Integer id)
	    {
	    	employeeRepository.updatebyid(STREET, id);
	    }
	    
	    public void retrieveEmployee()
	    {
	        // Get list of all Employee & Employee Address
	        List<Employee_Address> empAddress = employeeRepository.findAll();

	        // Displaying the Employee details
	        for (Employee_Address employeeAddress : empAddress)
	        {
	            System.out.println("*** Employee Details ***");

	            Employee employee = employeeAddress.getEmployee();
	            System.out.println("Employee Id   : " + employee.getEmpId());
	            System.out.println("Employee Name : " + employee.getEmpName());

	            System.out.println("*** Employee Address Details ***");
	            System.out.println("Street  : " + employeeAddress.getStreet());
	            System.out.println("City    : " + employeeAddress.getCity());
	            System.out.println("State   : " + employeeAddress.getState());
	            System.out.println("Country : " + employeeAddress.getCountry());
	        }
	    }
	    
}
