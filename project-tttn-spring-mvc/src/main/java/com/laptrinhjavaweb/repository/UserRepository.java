package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laptrinhjavaweb.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findOneByUserNameAndStatus(String name, int status);
	
	@Query(value = "select user.id from user where username=:username", nativeQuery = true)
	Long findByIdOfUserName(@Param("username") String userName);
	
	UserEntity findOneByUserName(String userName);
	
	@Query(value = "select * from user, user_role where user.id=user_role.user_id and  user_role.roles_id in (1,2)", nativeQuery = true)
	List<UserEntity> findAllByEmployee();
}
