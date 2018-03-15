package OneToMany;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static Main main;
	@Autowired
	private EmployeeRepository employeerepo;

	public static void main(String agrs[])
	{

		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("springconfig.xml");

		main=(Main)context.getBean("main");

		main.save();
		/*		main.update("Ramy",2);*/
		//main.employeerepo.delete(57);
		//main.employeerepo.deleteAllInBatch();
		main.retrieveDepartment();
		
		context.close();

	}

	private void save() {
		Department dept=new Department();
		dept.setDname("Marketing");

		Employee employee=new Employee();
		employee.setName("Sunny");

		Permanent_Employee permanent=new Permanent_Employee();
		permanent.setName("Rahul");
		permanent.setBonus(130);
		permanent.setSalary(200000.0f);
		permanent.setDepartment(dept);

		Contract_Employee contract=new Contract_Employee();
		contract.setName("XYZ");
		contract.setPay_per_hour(120.0f);
		contract.setContract_duration("six month");
		contract.setDepartment(dept);
		
		PartTime part_time=new PartTime();
		part_time.setName("Hitesh");
		part_time.setWage(100);
        part_time.setHours(4);
        part_time.setDepartment(dept);
        

		Set<Employee> employee1=new HashSet();
		employee1.add(employee);
		employee1.add(permanent);
		employee1.add(contract);
		employee1.add(part_time);
		dept.setEmployee(employee1);
		employee.setDepartment(dept);
		employeerepo.save(dept);


	}

	public void update(String name, int id)
	{
		employeerepo.setUserInfoById(name, id);
	}
	public void delete(int id)
	{
		employeerepo.deleteInBulkById(id);	
	}


	public void retrieveDepartment()
	{

		List<Department> Dept=employeerepo.findAll();
		for(Department deptlist:Dept)
		{
			System.out.println("Department id:"+deptlist.getDeptid());
			System.out.println("Department name:"+deptlist.getDname());


			Set<Employee> emplist=deptlist.getEmployee();
			for(Employee emp:emplist)
			{
				
				if(emp instanceof Contract_Employee)
				{
					Contract_Employee contract_Employee = (Contract_Employee)emp;
					 System.out.println("Contract_Employee id:"+contract_Employee.getEid());
					 System.out.println("Contract_Employee:"+contract_Employee.getName());
					 System.out.println("Contract_Employee:"+contract_Employee.getPay_per_hour());

				}
				else if (emp instanceof Permanent_Employee) {
				
					Permanent_Employee contract_Employee = (Permanent_Employee)emp;
					 System.out.println("Permanent_Employee id:"+contract_Employee.getEid());
					 System.out.println("Permanent_Employee name:"+contract_Employee.getName());
					 System.out.println("Permanent_Employee salary:"+contract_Employee.getSalary());

				}
				else
				{
				
					 System.out.println("Employee id:"+emp.getEid());
					 System.out.println("Employee name:"+emp.getName());
					
				}
				
			}





		}
	}
}


