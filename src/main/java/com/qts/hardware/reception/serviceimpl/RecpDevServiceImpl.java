package com.qts.hardware.reception.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qts.hardware.reception.dao.RecpDevDao;
import com.qts.hardware.reception.model.RecpDev;
import com.qts.hardware.reception.service.RecpDevService;
@Service
public class RecpDevServiceImpl implements RecpDevService
{
	@Autowired
	private RecpDevDao recpdevdao;

	@Transactional
	@Override
	public int save(RecpDev recpadddev)
	{
		return recpdevdao.save(recpadddev);
	}

	@Transactional
	@Override
	public List<RecpDev> list()
	{		
		return recpdevdao.list();
	}

	@Transactional
	@Override
	public RecpDev findbycustId(Integer id) 
	{
		// TODO Auto-generated method stub
	return recpdevdao.findbycustId(id);
	}

	@Transactional
	@Override
	public void update(RecpDev recpDev)
	{
		recpdevdao.update(recpDev);		
	}	
}
