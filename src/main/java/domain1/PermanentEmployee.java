package domain1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name="permanentemployee")
@PrimaryKeyJoinColumn(name="E_ID")
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
