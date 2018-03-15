package OneToMany;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="permanentemployee")
public class Permanent_Employee extends Employee {
	
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
