package springdataonetone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="employee")
public class Employee {
	 @Id
	    @GeneratedValue
	    @Column(name="EMP_ID")
	    private int empId;
	    
	    @Column(name="NAME")
	    private String empName;

	    @OneToOne(mappedBy="employee")
	    private EmployeeAddress employeeAddress;

	    public Employee()
	    {
	        super();
	    }

	    public Employee(int empId, String empName, EmployeeAddress employeeAddress)
	    {
	        super();
	        this.empId = empId;
	        this.empName = empName;
	        this.employeeAddress = employeeAddress;
	    }

	    public int getEmpId()
	    {
	        return empId;
	    }

	    public void setEmpId(int empId)
	    {
	        this.empId = empId;
	    }

	    public String getEmpName()
	    {
	        return empName;
	    }

	    public void setEmpName(String empName)
	    {
	        this.empName = empName;
	    }

	    public EmployeeAddress getEmployeeAddress()
	    {
	        return employeeAddress;
	    }

	    public void setEmployeeAddress(EmployeeAddress employeeAddress)
	    {
	        this.employeeAddress = employeeAddress;
	    }

	    @Override
	    public String toString()
	    {
	        return "Employee [empId=" + empId + ", empName=" + empName + ", employeeAddress=" + employeeAddress + "]";
	    }
}
