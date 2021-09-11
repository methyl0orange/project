package com.oracle.service;

import com.oracle.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DeptService {
	

	@Autowired
	private DeptDao deptDao;

	public void service(){	


		deptDao.dao();
	}
	

	
}
