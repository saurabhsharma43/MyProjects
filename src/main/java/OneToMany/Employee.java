package OneToMany;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="employee")


public class Employee {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="E_ID")
private int eid;
@Column(name="Ename")
private String name;

@ManyToOne
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
