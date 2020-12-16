package com.projects.projectManagementSystem.domain;

import javax.persistence.*;

@Entity
@Table(name = "BRANCH_MANAGERS")
public class BranchManager
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee employee;

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

	@Override
	public String toString()
	{
		return employee.getName();
	}
}
