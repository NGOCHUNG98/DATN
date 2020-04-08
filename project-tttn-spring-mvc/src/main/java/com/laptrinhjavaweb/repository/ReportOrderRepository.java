package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laptrinhjavaweb.entity.OrderEntity;

public interface ReportOrderRepository extends JpaRepository<OrderEntity, Long>{
	@Query(value = "SELECT count(*) FROM bill WHERE DATE_FORMAT(order_date,'%Y-%m-%d')=:date", nativeQuery = true)
	Long count(@Param("date") String date);

}
