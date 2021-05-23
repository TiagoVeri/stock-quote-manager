package com.test.stockquotemanager.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.stockquotemanager.domains.Stock;
import com.test.stockquotemanager.dto.StockDTO;
import com.test.stockquotemanager.repositories.StockRepository;
import com.test.stockquotemanager.services.exceptions.ObjectNotFoundException;
import com.test.stockquotemanager.services.exceptions.StockIdException;

import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepo;

	@Transactional
	public Stock insertStock(Stock stock) {
		try {
			stock.setId(stock.getId().toLowerCase());
			return stockRepo.save(stock);
		} catch (Exception e) {
			throw new StockIdException("Stock ID '" +stock.getId().toLowerCase() +"' already exists");
		}

	}

	public List<StockDTO> findAll() {
		List<Stock> result = stockRepo.findAll();
		return result.stream().map(x -> new StockDTO(x)).collect(Collectors.toList());

	}

	public StockDTO find(String id) {
		Optional<Stock> stock = stockRepo.findById(id.toLowerCase());
		if(stock == null) {
			throw new StockIdException("Stock ID '" + id.toLowerCase() +"' doesn't exist");
		}
		StockDTO dto = new StockDTO(stock.get());
					
		return dto;
	}

}
