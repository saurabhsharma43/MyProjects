package domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="permanentemployee")
@AttributeOverrides({
	
@AttributeOverride(name="E_ID",column=@Column(name="E_ID")),
@AttributeOverride(name="Ename",column=@Column(name="Ename")),
/*@AttributeOverride(name="Dept_ID",column=@Column(name="Dept_ID"))*/

})
public class PermanentEmployee extends Employee {
	@Column(name="salary")	
	private float salary;

	@Column(name="bonus")
	private int bonus;




	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Permanent_Employee [salary=" + salary + ", bonus=" + bonus + ", getSalary()=" + getSalary()
				+ ", getBonus()=" + getBonus() + "]";
	}



}
