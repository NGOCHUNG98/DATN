package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.RolesEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.service.IRolesService;

@Service
public class RolesServiceImpl implements IRolesService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Map<Long, String> findAllRoles() {
		Map<Long, String> result=new HashMap<Long, String>();
		List<RolesEntity> entities = roleRepository.findAll();
		for (RolesEntity item : entities) {
			result.put(item.getId(), item.getName());
		}
		return result;
	}

}
