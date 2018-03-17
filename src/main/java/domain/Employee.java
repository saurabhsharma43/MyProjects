package domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="employee")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Employee {
	@Id
	
	@GeneratedValue(strategy=GenerationType.TABLE,generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	
	
	@Column(name="E_ID")
	private int eid;
	@Column(name="Ename")
	private String name;

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="Dept_ID")

	private Department department;


	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", department=" + department + ", getEid()=" + getEid()
				+ ", getName()=" + getName() + ", getDepartment()=" + getDepartment() + "]";
	}

}
