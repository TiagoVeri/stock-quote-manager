package com.test.stockquotemanager.domains;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_stock")
public class Stock {
	
	@Id
	private String id;
	
	private Map<String, String> quotes	= new HashMap<>();

	public Stock() {
	}
	
	public Stock(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, String> getQuotes() {
		return quotes;
	}

	public void setQuotes(Map<String, String> quotes) {
		this.quotes = quotes;
	}
	
	
	
}
