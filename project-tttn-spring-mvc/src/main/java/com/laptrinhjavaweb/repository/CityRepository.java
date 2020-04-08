package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Long> {

}
