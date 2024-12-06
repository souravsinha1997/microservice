package com.inw8minutes.microservices.currency_conversion_service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.inw8minutes.microservices.currency_conversion_service.bean.CurrencyConversion;

@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion getExchangeRate(@PathVariable("from") String from,
											@PathVariable("to") String to);
}
