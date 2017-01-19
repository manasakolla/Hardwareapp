package com.qts.hardware.devices.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="device_mgnt")
@Entity
public class DevicesAdmin
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	 @Column(name="device_name")
    private String deviceName;
	 @Column(name = "cr_by")
    private String createdBy;
	 @Column(name = "cr_dt")
    private String createdDate;
	 @Column(name = "md_by")
    private String modifiedBy;
	 @Column(name = "md_dt")
    private String modifiedDate;
	 @Column(name = "descr")
    private String description;
    
	public int getId() 
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getDeviceName() 
	{
		return deviceName;
	}
	public void setDeviceName(String deviceName) 
	{
		this.deviceName = deviceName;
	}
	public String getCreatedBy() 
	{
		return createdBy;
	}
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}
	public String getCreatedDate()
	{
		return createdDate;
	}
	public void setCreatedDate(String createdDate)
	{
		this.createdDate = createdDate;
	}
	public String getModifiedBy()
	{
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDate() 
	{
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) 
	{
		this.modifiedDate = modifiedDate;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
}
