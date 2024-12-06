package com.inw8minutes.microservices.currency_conversion_service.bean;

import java.math.BigDecimal;

public class CurrencyConversion {

		private Long id;
		private String from;
		private String to;
		private BigDecimal conversionMultiple;
		private BigDecimal amount;
		private BigDecimal totalConvertedAmount;
		private String environment;		
		
		public CurrencyConversion() {
			super();
		}
		
		public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal amount,
				BigDecimal totalConvertedAmount, String environment) {
			super();
			this.id = id;
			this.from = from;
			this.to = to;
			this.conversionMultiple = conversionMultiple;
			this.amount = amount;
			this.totalConvertedAmount = totalConvertedAmount;
			this.environment = environment;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}
		public BigDecimal getConversionMultiple() {
			return conversionMultiple;
		}
		public void setConversionMultiple(BigDecimal conversionMultiple) {
			this.conversionMultiple = conversionMultiple;
		}
		public BigDecimal getAmount() {
			return amount;
		}
		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}
		public BigDecimal getTotalConvertedAmount() {
			return totalConvertedAmount;
		}
		public void setTotalConvertedAmount(BigDecimal totalConvertedAmount) {
			this.totalConvertedAmount = totalConvertedAmount;
		}
		public String getEnvironment() {
			return environment;
		}
		public void setEnvironment(String environment) {
			this.environment = environment;
		}
		
		@Override
		public String toString() {
			return "CurrencyConversion [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
					+ conversionMultiple + ", amount=" + amount + ", totalConvertedAmount=" + totalConvertedAmount
					+ ", environment=" + environment + "]";
		}
		
		
}
