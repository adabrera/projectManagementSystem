package com.projects.projectManagementSystem.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE_PROJECT_HOURS")
public class EmployeeProjectHours
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "PROJECT_ID")
	private Project project;

	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee employee;

	@Column(name = "LOGGED_DATE")
	@DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
	private Date loggedDate;

	@Column(name = "HOURS")
	private double hours;

	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployee( Employee employee )
	{
		this.employee = employee;
	}

	public Project getProject()
	{
		return project;
	}

	public void setProject( Project project )
	{
		this.project = project;
	}

	public Date getLoggedDate()
	{
		return loggedDate;
	}

	public void setLoggedDate( Date loggedDate )
	{
		this.loggedDate = loggedDate;
	}

	public double getHours()
	{
		return hours;
	}

	public void setHours( double hours )
	{
		this.hours = hours;
	}

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}
}
