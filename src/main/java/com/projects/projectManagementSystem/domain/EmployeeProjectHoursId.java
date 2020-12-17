//package com.projects.projectManagementSystem.domain;
//
//import javax.persistence.MappedSuperclass;
//import java.io.Serializable;
//
//@MappedSuperclass
//public class EmployeeProjectHoursId implements Serializable
//{
//	private Long projectId;
//	private Long employeeId;
//
//	public Long getProjectId()
//	{
//		return projectId;
//	}
//
//	public void setProjectId( Long projectId )
//	{
//		this.projectId = projectId;
//	}
//
//	public Long getEmployeeId()
//	{
//		return employeeId;
//	}
//
//	public void setEmployeeId( Long employeeId )
//	{
//		this.employeeId = employeeId;
//	}
//
//	@Override
//	public boolean equals( Object o )
//	{
//		if ( this == o )
//			return true;
//		if ( o == null || getClass() != o.getClass() )
//			return false;
//
//		EmployeeProjectHoursId that = ( EmployeeProjectHoursId ) o;
//
//		if ( projectId != null ? !projectId.equals( that.projectId ) : that.projectId != null )
//			return false;
//		return employeeId != null ? employeeId.equals( that.employeeId ) : that.employeeId == null;
//	}
//
//	@Override
//	public int hashCode()
//	{
//		int result = projectId != null ? projectId.hashCode() : 0;
//		result = 31 * result + ( employeeId != null ? employeeId.hashCode() : 0 );
//		return result;
//	}
//}
