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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	 @Id
	    @Column(name = "ADDR_ID")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int addrId;
	    
	    @Column(name="STREET")
	    private String street;
	    @Column(name="CITY")
	    private String city;
	    @Column(name="STATE")
	    private String state;
	    @Column(name="COUNTRY")
	    private String country;
	    
	    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="address")
	    private Set<Employee> employee;

	    public Address()
	    {
	        super();
	    }

	    public Address(int addrId, String street, String city, String state, String country, Set<Employee> employee)
	    {
	        super();
	        this.addrId = addrId;
	        this.street = street;
	        this.city = city;
	        this.state = state;
	        this.country = country;
	        this.employee = employee;
	    }

	    public int getAddrId()
	    {
	        return addrId;
	    }

	    public void setAddrId(int addrId)
	    {
	        this.addrId = addrId;
	    }

	    public String getStreet()
	    {
	        return street;
	    }

	    public void setStreet(String street)
	    {
	        this.street = street;
	    }

	    public String getCity()
	    {
	        return city;
	    }

	    public void setCity(String city)
	    {
	        this.city = city;
	    }

	    public String getState()
	    {
	        return state;
	    }

	    public void setState(String state)
	    {
	        this.state = state;
	    }

	    public String getCountry()
	    {
	        return country;
	    }

	    public void setCountry(String country)
	    {
	        this.country = country;
	    }

	    public Set<Employee> getEmployee()
	    {
	        return employee;
	    }

	    public void setEmployee(Set<Employee> employee)
	    {
	        this.employee = employee;
	    }

	    @Override
	    public String toString()
	    {
	        return "Address [addrId=" + addrId + ", street=" + street + ", city=" + city + ", state=" + state + ", country="
	                + country + ", employee=" + employee + "]";
	    }
}
