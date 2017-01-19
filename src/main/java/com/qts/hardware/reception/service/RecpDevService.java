package com.qts.hardware.reception.service;

import java.util.List;

import com.qts.hardware.department.model.Department;
import com.qts.hardware.reception.model.RecpDev;

public interface RecpDevService
{
	public int save(RecpDev recpadddev);
	public List<RecpDev> list();
	RecpDev findbycustId(Integer id);
	public void update(RecpDev recpDev);
}
