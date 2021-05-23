package com.test.stockquotemanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.stockquotemanager.domains.Stock;
import com.test.stockquotemanager.repositories.StockRepository;
import com.test.stockquotemanager.services.exceptions.ObjectNotFoundException;

import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepo;

	@Transactional
	public Stock insertStock(Stock stock) {
		String id = stock.getId();
		stock.setId(id.toLowerCase());
		return stockRepo.save(stock);
	}

	public List<Stock> findAll() {
		return stockRepo.findAll();
	}

	public Stock find(String id) {
		id.toLowerCase();
		Optional<Stock> stock = stockRepo.findById(id);

		return stock.orElseThrow(() -> new ObjectNotFoundException(
				"O id " + id + " tipo: " + Stock.class.getName() + " não foi encontrato"));
	}

}
