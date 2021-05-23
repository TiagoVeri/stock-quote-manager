package com.test.stockquotemanager.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.stockquotemanager.domains.Quotes;
import com.test.stockquotemanager.domains.Stock;

public class StockDTO {


	private String id;
	//private List<Quotes> quotesList = new ArrayList<>();//TODO change key to Date and value to Double
	private Map<String, Double> quotes = new HashMap<String, Double>();
	
	public StockDTO() {
	}

	public StockDTO(String id) {
		this.id = id;
	}
	
	public StockDTO(Stock entity) {
		id = entity.getId();
		quotes = listMapQuotes(entity.getQuotes());

	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Double> getQuotes() {
		return quotes;
	}

	public void setQuotes(Map<String, Double> quotes) {
		this.quotes = quotes;
	}

	public Map<String, Double> listMapQuotes(List<Quotes> list){
      Map<String, Double> listObj = new HashMap<>();
      for(int i = 0; i < list.size(); i++) {
      //	for(int j = 0; j < list.get(i).getQuotes().size(); j++) {
      		String quoteDate =  list.get(i).getQuoteDate();
      		Double quoteValue = list.get(i).getQuoteValue();
      		listObj.put(quoteDate, quoteValue);
     // 	}
      }
	return listObj;
	}
	
}
