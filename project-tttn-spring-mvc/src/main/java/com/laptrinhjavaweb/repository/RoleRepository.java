package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laptrinhjavaweb.entity.RolesEntity;

public interface RoleRepository extends JpaRepository<RolesEntity, Long>{
	
	@Query(value = "select * from roles where id=3", nativeQuery = true)
	List<RolesEntity> findUserById();
	
	@Query(value = "select * from roles where roles.id=:id", nativeQuery = true)
	List<RolesEntity> findAllById(@Param("id") Long id);
}
