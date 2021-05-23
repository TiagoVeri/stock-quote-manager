package com.test.stockquotemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.stockquotemanager.domains.Stock;

public interface StockRepository extends JpaRepository<Stock, String>{

}
