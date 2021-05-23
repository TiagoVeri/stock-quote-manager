package com.test.stockquotemanager.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.test.stockquotemanager.domains.utils.ArrayMapDeserializer;

@Entity
@Table(name = "tb_stock")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @NotBlank(message = "Identifier required")
    @Column(updatable = false, unique = true)
	private String id;
	
	//@JsonDeserialize(using = ArrayMapDeserializer.class)
	//@ElementCollection(targetClass=ArrayMapDeserializer.class)
	//@MapKeyColumn(name="Employee_Position")
	//private Map<String, String> quotes = new HashMap<>();//TODO change key to Date and value to Double
	
	//@JsonManagedReference
	//@JsonIgnore
	@OneToMany(mappedBy="stock", fetch=FetchType.EAGER)
	private List<Quotes> quotesList = new ArrayList<>();//TODO change key to Date and value to Double

	@Transient
	private Map<String, Double> quotes = new HashMap<String, Double>();
	
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

	public  List<Quotes> getQuotes() {
		return quotesList;
	}

	public void setQuotes(List<Quotes> quotes) {
		this.quotesList = quotes;
	}
	
	
	public Map<String, Double> getQuotesMap() {
		
		return quotes;
	}

	public void setQuotesMap(Map<String, Double> quotes) {
		this.quotes = quotes;
	}



	@Override
	public String toString() {
		return "Stock [id=" + id + ", quotes=" + quotes + "]";
	}
	
	
	
}
