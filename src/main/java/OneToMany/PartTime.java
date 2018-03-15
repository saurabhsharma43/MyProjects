package OneToMany;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="parttimeemployee")
public class PartTime extends Employee {
	@Column(name="Wage")
	private double wage; // wage per hour
	@Column(name="Hours")
	private double hours; // hours worked for week
	
	
	
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		this.hours = hours;
	}

}
