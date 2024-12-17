package com.inw8minutes.microservices.currency_conversion_service.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.inw8minutes.microservices.currency_conversion_service.bean.CurrencyConversion;
import com.inw8minutes.microservices.currency_conversion_service.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy proxy;
	
	 @Autowired
	 private RestTemplate restTemplate;
	 
	@GetMapping("/currency-conversion/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
												  @PathVariable String to,
												  @PathVariable BigDecimal amount) {
		
		HashMap<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		//ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
		ResponseEntity<CurrencyConversion> responseEntity = restTemplate
																	.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
																				   CurrencyConversion.class,
																				   uriVariables);
		
		CurrencyConversion conversion = responseEntity.getBody();
		
		return new CurrencyConversion(conversion.getId(),
									  from, to,
									  conversion.getConversionMultiple(),
									  amount,
									  amount.multiply(conversion.getConversionMultiple()),
									  conversion.getEnvironment());
	}
	
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from,
												  @PathVariable String to,
												  @PathVariable BigDecimal amount) {
		
		CurrencyConversion conversion = proxy.getExchangeRate(from, to);
		
		return new CurrencyConversion(conversion.getId(),
									  from, to,
									  conversion.getConversionMultiple(),
									  amount,
									  amount.multiply(conversion.getConversionMultiple()),
									  conversion.getEnvironment()+ " Feign Client");
	}
}
