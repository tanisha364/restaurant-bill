package com.example.bill;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {

	Menu findByFoodName(String foodName);
 
}