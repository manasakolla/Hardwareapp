package com.qts.hardware.devices.service;


import java.util.List;

import com.qts.hardware.devices.model.DevicesAdmin;

public interface DeviceAddingService 
{
	  public int save(DevicesAdmin devicesadd);
	  public List<DevicesAdmin> list();
	  public void delete(DevicesAdmin devicesadd);
	
	  
	  /*public void updateDevicesadd(Devicesadd devicesadd);*/
}

