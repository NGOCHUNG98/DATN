package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhjavaweb.entity.RolesEntity;

public interface RoleRepository extends JpaRepository<RolesEntity, Long>{
	
	@Query(value = "select * from roles where id=3", nativeQuery = true)
	List<RolesEntity> findUserById();
	
	RolesEntity findOneById(long id);
}
