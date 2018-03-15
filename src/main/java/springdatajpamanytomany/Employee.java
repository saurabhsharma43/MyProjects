package springdatajpamanytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EMP_ID")
    private int empId;
    
    @Column(name="NAME")
    private String empName;

    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="employee_address", 
    joinColumns={@JoinColumn(name="EMP_ID")}, 
    inverseJoinColumns={@JoinColumn(name="ADDR_ID")})
    private Set<Address> address;
 
    public Employee()
    {
        super();
    }

    public Employee(int empId, String empName, Set<Address> address)
    {
        super();
        this.empId = empId;
        this.empName = empName;
        this.address = address;
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

    public Set<Address> getAddress()
    {
        return address;
    }

    public void setAddress(Set<Address> address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + "]";
    }
}
