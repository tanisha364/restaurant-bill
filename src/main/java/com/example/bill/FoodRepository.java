package com.example.bill;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

	List<Food> findByOrderId(String orderId);
}