package com.qincloud.activiti.service.impl;

import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.qincloud.activiti.config.ActivitiConstant;
import com.qincloud.activiti.dao.SalaryDao;
import com.qincloud.activiti.domain.SalaryDO;
import com.qincloud.activiti.service.SalaryService;
import com.qincloud.common.utils.StringUtils;


@Service
public class SalaryServiceImpl implements SalaryService {
	@Autowired
	private SalaryDao salaryDao;
	@Autowired
	private ActTaskServiceImpl actTaskService;
	
	@Override
	public SalaryDO get(String id){
		return salaryDao.get(id);
	}
	
	@Override
	public List<SalaryDO> list(Map<String, Object> map){
		return salaryDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return salaryDao.count(map);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public int save(SalaryDO salary){
			salary.setId(UUID.randomUUID().toString().replace("-",""));
			actTaskService.startProcess(ActivitiConstant.ACTIVITI_SALARY[0],ActivitiConstant.ACTIVITI_SALARY[1],salary.getId(),salary.getContent(),new HashMap<>());
			return salaryDao.save(salary);
	}
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int update(SalaryDO salary){
		System.out.println(salary.getTaskId());
		actTaskService.complete(salary.getTaskId());
		return salaryDao.update(salary);
	}
	
	@Override
	public int remove(String id){
		return salaryDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return salaryDao.batchRemove(ids);
	}
	
}
