package com.test.stockquotemanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.stockquotemanager.domains.Quotes;
import com.test.stockquotemanager.domains.Stock;
import com.test.stockquotemanager.repositories.QuotesRepository;
import com.test.stockquotemanager.services.exceptions.ObjectNotFoundException;
import com.test.stockquotemanager.services.exceptions.QuotesIdException;

@Service
public class QuotesService {

	@Autowired
	private QuotesRepository quoteRepo;
	
	@Transactional
	public Quotes insertQuotes(Quotes quotes) {
		try {
			quotes.setId(null);
			Stock stock = quotes.getStock();
			stock.setId(stock.getId().toLowerCase());

			return quoteRepo.save(quotes);
		} catch (Exception e) {
			throw new QuotesIdException("Quotes ID '" +quotes.getId() +"' already exists");
		}

	}

	public List<Quotes> findAll() {
		return quoteRepo.findAll();
	}

	public Quotes find(Long id) {
		Optional<Quotes> quotes = quoteRepo.findById(id);
		
		if(quotes == null) {
			throw new QuotesIdException("Quotes ID '" + id +"' doesn't exist");
		}
		return quotes.orElseThrow(() -> new ObjectNotFoundException(
				"O id " + id + " tipo: " + Quotes.class.getName() + " não foi encontrato"));
	}

}
