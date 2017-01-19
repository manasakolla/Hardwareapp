package com.qts.hardware.reception.dao;

import java.util.List;

import com.qts.hardware.reception.model.RecpDev;

public interface RecpDevDao 
{
	public int save(RecpDev recpadddev);
	 public List<RecpDev> list();
	RecpDev findbycustId(Integer id);
	  public void update(RecpDev recpDev);
}
