package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.RolesEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserConverter userConverter;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> model = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll(pageable).getContent();
		for (UserEntity item : entities) {
			UserDTO dto = userConverter.toDto(item);
			model.add(dto);
		}
		return model;
	}

	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		UserEntity entity = new UserEntity();
		if (dto.getId() != null) {
			UserEntity oldUser = userRepository.findOne(dto.getId());
			entity = userConverter.toEntity(oldUser, dto);
			
		} else {
			entity = userConverter.toEntity(dto);
			entity.setRoles(new ArrayList<RolesEntity>(roleRepository.findUserById()));
			entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		}
		return userConverter.toDto(userRepository.save(entity));
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			userRepository.delete(id);
		}
	}

	@Override
	public int getTotalItem() {
		return (int) userRepository.count();
	}

	@Override
	public UserDTO findOne(long id) {
		UserEntity entity = userRepository.findOne(id);
		return userConverter.toDto(entity);
	}

	@Override
	public void addUser(UserDTO userDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUserOrder(UserDTO userDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getUserOrderTotal(long order_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Long findByIdOfUserName(String userName) {
		return userRepository.findByIdOfUserName(userName);
	}

}
