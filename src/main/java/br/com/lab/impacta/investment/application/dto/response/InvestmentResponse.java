package br.com.lab.impacta.investment.application.dto.response;

import java.util.Date;

import lombok.Data;

@Data
public class InvestmentResponse {
	private Long id;

	private Double value;

	private Date date;

	public InvestmentResponse() {
	}

	public InvestmentResponse(Long id, Double value, Date date) {
		this.id = id;
		this.value = value;
		this.date = date;
	}
}
