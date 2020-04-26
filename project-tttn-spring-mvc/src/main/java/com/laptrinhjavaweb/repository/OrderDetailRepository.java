package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhjavaweb.entity.OrderDetailEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,Long>{
	
	@Query(value = "select bill.customer_name, "
			+ "bill.customer_address, "
			+ "bill.customer_phone, "
			+ "bill.order_date, "
			+ "bill.status, "
			+ "motocrycle.thumbnail, "
			+ "motocrycle.name, "
			+ "motocrycle.price, "
			+ "billdetail.quantity "
			+ "from motocrycle, bill, billdetail "
			+ "where billdetail.motocrycle_id = motocrycle.id and billdetail.order_id = bill.id", nativeQuery = true)
	List<OrderDetailEntity> findAllOrderDetail();
}
