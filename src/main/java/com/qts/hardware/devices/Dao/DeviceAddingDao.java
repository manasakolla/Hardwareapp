package com.qts.hardware.devices.Dao;

import java.util.List;

import com.qts.hardware.devices.model.DevicesAdmin;

public interface DeviceAddingDao
{
	public int save(DevicesAdmin devicesadd);
	 public List<DevicesAdmin> list();
	 public void delete(DevicesAdmin devicesadd);
	 
     /*public void updateDevicesadd(Devicesadd devicesadd);*/
}
