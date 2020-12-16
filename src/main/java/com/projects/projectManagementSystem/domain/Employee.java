package com.projects.projectManagementSystem.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "EMPLOYEES")
public class Employee
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DOB")
	@DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
	private Date dateOfBirth;

	@Column(name = "SALARY")
	private double salary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRANCH_ID" )
	private Branch branch;

	@OneToMany(mappedBy = "employee")
	private Set<EmployeeProjectHours> employeeHours;

	public Employee()
	{
	}

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress( String address )
	{
		this.address = address;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth( Date dateOfBirth )
	{
		this.dateOfBirth = dateOfBirth;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary( double salary )
	{
		this.salary = salary;
	}

	public Branch getBranch()
	{
		return branch;
	}

	public void setBranch( Branch branch )
	{
		this.branch = branch;
	}

	public Set<EmployeeProjectHours> getEmployeeHours()
	{
		return employeeHours;
	}

	public void setEmployeeHours( Set<EmployeeProjectHours> employeeHours )
	{
		this.employeeHours = employeeHours;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		Employee employee = ( Employee ) o;

		if ( Double.compare( employee.salary, salary ) != 0 )
			return false;
		if ( id != null ? !id.equals( employee.id ) : employee.id != null )
			return false;
		if ( name != null ? !name.equals( employee.name ) : employee.name != null )
			return false;
		if ( address != null ? !address.equals( employee.address ) : employee.address != null )
			return false;
		if ( email != null ? !email.equals( employee.email ) : employee.email != null )
			return false;
		if ( dateOfBirth != null ? !dateOfBirth.equals( employee.dateOfBirth ) : employee.dateOfBirth != null )
			return false;
		if ( branch != null ? !branch.equals( employee.branch ) : employee.branch != null )
			return false;
		return employeeHours != null ? employeeHours.equals( employee.employeeHours ) : employee.employeeHours == null;
	}

	@Override
	public int hashCode()
	{
		int result;
		long temp;
		result = id != null ? id.hashCode() : 0;
		result = 31 * result + ( name != null ? name.hashCode() : 0 );
		result = 31 * result + ( address != null ? address.hashCode() : 0 );
		result = 31 * result + ( email != null ? email.hashCode() : 0 );
		result = 31 * result + ( dateOfBirth != null ? dateOfBirth.hashCode() : 0 );
		temp = Double.doubleToLongBits( salary );
		result = 31 * result + ( int ) ( temp ^ ( temp >>> 32 ) );
		result = 31 * result + ( branch != null ? branch.hashCode() : 0 );
		result = 31 * result + ( employeeHours != null ? employeeHours.hashCode() : 0 );
		return result;
	}
}
