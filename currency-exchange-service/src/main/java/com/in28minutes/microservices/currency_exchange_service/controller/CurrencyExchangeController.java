package com.in28minutes.microservices.currency_exchange_service.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currency_exchange_service.bean.CurrencyExchange;
import com.in28minutes.microservices.currency_exchange_service.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getExchangeRate(@PathVariable("from") String from,
											@PathVariable("to") String to) {
		
		//currency-exchange,236e6dc0d9083792b9338efc83ac64d1,c871dfb5280f247f
		logger.info("retrieve Exchange value called with {} to {}", from, to);
		CurrencyExchange rate = repository.findByFromAndTo(from, to);
		if(rate == null)
			throw new RuntimeException("Unable to find for "+from+" to "+to);
		rate.setEnvironment(environment.getProperty("local.server.port"));
		return rate;
		
	}
}
