package com.qts.hardware.device.serviceimpl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qts.hardware.devices.Dao.DeviceAddingDao;
import com.qts.hardware.devices.model.DevicesAdmin;
import com.qts.hardware.devices.service.DeviceAddingService;

@Service
public class DeviceAddingServiceImpl implements DeviceAddingService
{
	@Autowired
	private DeviceAddingDao deviceaddingdao;

	 public void setDeviceAddingDao(DeviceAddingDao deviceaddingdao)
	 {
	     this.deviceaddingdao = deviceaddingdao;
	 }
	 
	@Transactional
	@Override
	public int save(DevicesAdmin devicesadd)
	{
		return deviceaddingdao.save(devicesadd);
	}
 
	@Transactional
	public List<DevicesAdmin> list()
	{		
		return deviceaddingdao.list();
	}

	@Transactional
	public void delete(DevicesAdmin devicesadd)
	{
		deviceaddingdao.delete(devicesadd);		
	}


	/*@Override
	public void deleteDevicesadd(int id)
	{
		deviceaddingdao.deleteDevicesadd(id);
		
	}

	@Override
	public void updateDevicesadd(Devicesadd devicesadd) 
	{
	   deviceaddingdao.updateDevicesadd(devicesadd);
		
	}*/
}
