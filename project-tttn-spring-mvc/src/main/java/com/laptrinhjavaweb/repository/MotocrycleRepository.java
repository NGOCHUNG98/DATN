package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laptrinhjavaweb.entity.MotocrycleEntity;


public interface MotocrycleRepository extends JpaRepository<MotocrycleEntity, Long> {

	@Query(value = "select * from motocrycle where motocrycle.category_id=:categoryId", nativeQuery = true)
	List<MotocrycleEntity> findByCategoryId(@Param("categoryId") Long categoryId);
	
	@Query(value = "select * from motocrycle where motocrycle.id=:id", nativeQuery = true)
	List<MotocrycleEntity> findDetailByMotorycleId(@Param("id") Long id);
	
	@Query(value = "select * from motocrycle where motocrycle.name like %:name%", nativeQuery = true)
	List<MotocrycleEntity> findByNameMotocrycle(@Param("name") String name);
	
}
