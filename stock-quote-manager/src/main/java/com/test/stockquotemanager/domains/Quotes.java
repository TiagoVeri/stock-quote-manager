package com.test.stockquotemanager.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Quotes implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String quoteDate;
	private Double quoteValue;
	
	@JsonBackReference
	@ManyToOne
	private Stock stock;
	
	public Quotes() {
	}
	
	public Quotes(Long id, String quoteDate, Double quoteValue, Stock stock) {
		this.id = id;
		this.quoteDate = quoteDate;
		this.quoteValue = quoteValue;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuoteDate() {
		return quoteDate;
	}

	public void setQuoteDate(String quoteDate) {
		this.quoteDate = quoteDate;
	}

	public Double getQuoteValue() {
		return quoteValue;
	}

	public void setQuoteValue(Double quoteValue) {
		this.quoteValue = quoteValue;
	}
	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}


	
	
}
