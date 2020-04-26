package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.UserDTO;

public interface IUserService {
	List<UserDTO> findAll(Pageable pageable);
	UserDTO findOne(long id);
	UserDTO findOneByUserName(String userName);
	UserDTO save(UserDTO dto);
	void delete(long[] ids);
	int getTotalItem();
	void addUser(UserDTO userDTO);
	List<UserDTO> findAll();
	void addUserOrder(UserDTO userDTO);
	double getUserOrderTotal(long order_id);
	Long findByIdOfUserName(String userName);
}
