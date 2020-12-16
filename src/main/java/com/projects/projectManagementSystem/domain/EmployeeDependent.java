package com.projects.projectManagementSystem.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE_DEPENDENTS")
public class EmployeeDependent
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@OneToOne
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee employee;

	@Column(name = "DEPENDENT_NAME")
	private String dependentName;

	@Column(name = "RELATIONSHIP")
	private String relationship;

	@Column(name = "DOB")
	@DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
	private Date dateOfBirth;

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployee( Employee employee )
	{
		this.employee = employee;
	}

	public String getDependentName()
	{
		return dependentName;
	}

	public void setDependentName( String dependentName )
	{
		this.dependentName = dependentName;
	}

	public String getRelationship()
	{
		return relationship;
	}

	public void setRelationship( String relationship )
	{
		this.relationship = relationship;
	}

	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth( Date dateOfBirth )
	{
		this.dateOfBirth = dateOfBirth;
	}
}
