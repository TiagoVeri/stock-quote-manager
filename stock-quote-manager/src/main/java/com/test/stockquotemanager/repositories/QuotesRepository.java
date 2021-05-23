package com.test.stockquotemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.stockquotemanager.domains.Quotes;


public interface QuotesRepository extends JpaRepository<Quotes, Long>{

}
