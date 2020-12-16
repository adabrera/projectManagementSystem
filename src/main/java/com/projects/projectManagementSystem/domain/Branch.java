package com.projects.projectManagementSystem.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BRANCHES")
public class Branch
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "UNIQUE_NAME")
	private String uniqueName;

	@Column(name = "TELEPHONE")
	private String telephoneNumber;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "EMAIL")
	private String email;

	@OneToOne
	@JoinColumn(name = "MANAGER_EMP_ID")
	private BranchManager branchManager;

	@Column(name = "START_DATE")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@OneToMany(
			mappedBy = "branch",
			cascade = CascadeType.REFRESH,
			orphanRemoval = true
	)
	private List<Employee> employeeSet = new ArrayList<>();

	public Branch()
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

	public String getUniqueName()
	{
		return uniqueName;
	}

	public void setUniqueName( String uniqueName )
	{
		this.uniqueName = uniqueName;
	}

	public String getTelephoneNumber()
	{
		return telephoneNumber;
	}

	public void setTelephoneNumber( String telephoneNumber )
	{
		this.telephoneNumber = telephoneNumber;
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

	public BranchManager getBranchManager()
	{
		return branchManager;
	}

	public void setBranchManager( BranchManager branchManager )
	{
		this.branchManager = branchManager;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate( Date startDate )
	{
		this.startDate = startDate;
	}

	public List<Employee> getEmployeeSet()
	{
		return employeeSet;
	}

	public void setEmployeeSet( List<Employee> employeeSet )
	{
		this.employeeSet = employeeSet;
	}

	public void addEmployee( Employee employee )
	{
		this.employeeSet.add( employee );
		employee.setBranch( this );
	}

	public void removeEmployee( Employee employee )
	{
		employeeSet.remove( employee );
		employee.setBranch( null );
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		Branch branch = ( Branch ) o;

		if ( id != null ? !id.equals( branch.id ) : branch.id != null )
			return false;
		if ( uniqueName != null ? !uniqueName.equals( branch.uniqueName ) : branch.uniqueName != null )
			return false;
		if ( telephoneNumber != null ? !telephoneNumber.equals( branch.telephoneNumber ) : branch.telephoneNumber != null )
			return false;
		if ( address != null ? !address.equals( branch.address ) : branch.address != null )
			return false;
		if ( email != null ? !email.equals( branch.email ) : branch.email != null )
			return false;
		if ( branchManager != null ? !branchManager.equals( branch.branchManager ) : branch.branchManager != null )
			return false;
		if ( startDate != null ? !startDate.equals( branch.startDate ) : branch.startDate != null )
			return false;
		return employeeSet != null ? employeeSet.equals( branch.employeeSet ) : branch.employeeSet == null;
	}

	@Override
	public int hashCode()
	{
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + ( uniqueName != null ? uniqueName.hashCode() : 0 );
		result = 31 * result + ( telephoneNumber != null ? telephoneNumber.hashCode() : 0 );
		result = 31 * result + ( address != null ? address.hashCode() : 0 );
		result = 31 * result + ( email != null ? email.hashCode() : 0 );
		result = 31 * result + ( branchManager != null ? branchManager.hashCode() : 0 );
		result = 31 * result + ( startDate != null ? startDate.hashCode() : 0 );
		result = 31 * result + ( employeeSet != null ? employeeSet.hashCode() : 0 );
		return result;
	}
}
