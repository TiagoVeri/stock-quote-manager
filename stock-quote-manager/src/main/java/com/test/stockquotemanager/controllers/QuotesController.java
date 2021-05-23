package com.test.stockquotemanager.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.stockquotemanager.domains.Quotes;
import com.test.stockquotemanager.services.QuotesService;


import javax.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/quote")
public class QuotesController {
	
    @Autowired
    private QuotesService quoteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Quotes> findById(@PathVariable Long id){
        com.test.stockquotemanager.domains.Quotes obj = quoteService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Quotes>> findAll(){
        List<Quotes> QuotesList = quoteService.findAll();
        return ResponseEntity.ok().body(QuotesList);
    }

    @PostMapping
    public ResponseEntity<Quotes> insertQuotes(@Valid @RequestBody Quotes Quotes){
        Quotes obj = quoteService.insertQuotes(Quotes);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }



}
