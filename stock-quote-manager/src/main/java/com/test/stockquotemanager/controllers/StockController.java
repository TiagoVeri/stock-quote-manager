package com.test.stockquotemanager.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.stockquotemanager.domains.Quotes;
import com.test.stockquotemanager.domains.Stock;
import com.test.stockquotemanager.dto.StockDTO;
import com.test.stockquotemanager.services.StockService;

import javax.validation.Valid;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/stock")
public class StockController {
	
    @Autowired
    private StockService stockService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<StockDTO> findById(@PathVariable String id){
        StockDTO obj = stockService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<StockDTO>> findAll(){
        List<StockDTO> stockList = stockService.findAll();
        return ResponseEntity.ok().body(stockList);
    }

    @PostMapping
    public ResponseEntity<Stock> insertStock(@Valid @RequestBody Stock Stock){
        Stock obj = stockService.insertStock(Stock);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }



}
