package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {
	private static Main main;
	@Autowired
	private EmployeeRepo employeerepo;
	
	public static void main(String agrs[])
	{
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("SpringConfig.xml");
		
		main=(Main)context.getBean("main");
		
		main.save();
/*		main.update("Ramy",2);*/
		//main.delete(5);
		main.retrieveDepartment();
		context.close();
		
	}

	private void save() {
		Department dept=new Department();
		dept.setDname("Marketing");
		
		Employee employee=new Employee();
		employee.setName("Sunny");
		
		PermanentEmployee permanent=new PermanentEmployee();
		permanent.setName("Rahul");
		permanent.setBonus(130);
		permanent.setDepartment(dept);
		permanent.setSalary(200000.0f);
		
		ContractEmployee contract=new ContractEmployee();
		contract.setName("XYZ");
		contract.setPay_per_hour(120.0f);
		contract.setDepartment(dept);
		contract.setContract_duration("six month");
		
		
		Set<Employee> employee1=new HashSet();
		employee1.add(employee);
		employee1.add(permanent);
		employee1.add(contract);
		dept.setEmployee(employee1);
		employee.setDepartment(dept);
		employeerepo.save(dept);
		
		
	}
	
/*	public void update(String name, int id)
	{
		employeerepo.setUserInfoById(name, id);
	}
	public void delete(int id)
	{
		employeerepo.deleteInBulkById(id);	
	}*/
	
    
    public void retrieveDepartment()
    {
    	
    	List<Department> Dept=employeerepo.findAll();
    	for(Department deptlist:Dept)
    	{
    		System.out.println("Department id:"+deptlist.getDeptid());
    		System.out.println("Department name:"+deptlist.getDname());
    	
    	
    		
    	Set<Employee> emplist=deptlist.getEmployee();
    	for(Employee emp:emplist)
    	if(emp instanceof PermanentEmployee)
    	{
    		PermanentEmployee permanent=(PermanentEmployee)emp;
    		System.out.println("Employee Eid:"+permanent.getEid());
    		System.out.println("Employee Name:"+permanent.getName());
    		System.out.println("Employee Salary:"+permanent.getSalary());
    		System.out.println("Employee Bonus:"+permanent.getBonus());
    	}
    	
    	else if(emp instanceof ContractEmployee)
    	{
    		ContractEmployee contract=(ContractEmployee)emp;
    		System.out.println("Employee ID:"+contract.getEid());
    		System.out.println("Employee Name:"+contract.getName());
    		System.out.println("Employee Contract_duration:"+contract.getContract_duration());
    		System.out.println("Employee Pay_per_hour:"+contract.getPay_per_hour());
    	}
    
    	else
    	{
    		
    		System.out.println("Employee id:"+emp.getEid());
    		System.out.println("Employee name:"+emp.getName());
    	}
    	
       
    
   
    
    
}
}
}

