package com.qts.hardware.reception.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="repair_device")
public class RecpDev 
{
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String customerName;
	@Column(name="device_mgnt_id")
	private int device_mgnt_id;
	@Column(name="problem")
	private String problem;
	@Column(name="status")
	private String status;
	@Column(name="date")
	private String date;
	@Column(name="exrep_dt")
	private String expectedDeliveryDate;
	@Column(name="track_id")
	private String trackId;	
	@Column(name="assigned_tech_id")
	private int assignedTechId;
	
	public int getId() 
	{
		return id;
	}	
	public void setId(int id)
	{
		this.id = id;
	}	
	public String getCustomerName()
	{
		return customerName;
	}
	public void setCustomerName(String customerName) 
	{
		this.customerName = customerName;
	}
	public String getExpectedDeliveryDate() 
	{
		return expectedDeliveryDate;
	}
	public void setExpectedDeliveryDate(String expectedDeliveryDate) 
	{
		this.expectedDeliveryDate = expectedDeliveryDate;
	}
	public String getTrackId()
	{
		return trackId;
	}
	public void setTrackId(String trackId)
	{
		this.trackId = trackId;
	}
	public int getAssignedTechId()
	{
		return assignedTechId;
	}
	public void setAssignedTechId(int assignedTechId) 
	{
		this.assignedTechId = assignedTechId;
	}
	public String getProblem() 
	{
		return problem;
	}
	public void setProblem(String problem)
	{
		this.problem = problem;
	}
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getDate() 
	{
		return date;
	}
	public void setDate(String date) 
	{
		this.date = date;
	}
	public int getDevice_mgnt_id()
	{
		return device_mgnt_id;
	}
	public void setDevice_mgnt_id(int device_mgnt_id) 
	{
		this.device_mgnt_id = device_mgnt_id;
	}
}