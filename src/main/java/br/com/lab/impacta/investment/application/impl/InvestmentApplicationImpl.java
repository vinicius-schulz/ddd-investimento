package br.com.lab.impacta.investment.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lab.impacta.investment.application.InvestmentApplication;
import br.com.lab.impacta.investment.application.adapter.InvestmentAdapter;
import br.com.lab.impacta.investment.application.dto.request.InvestmentRequest;
import br.com.lab.impacta.investment.application.dto.response.InvestmentResponse;
import br.com.lab.impacta.investment.model.Investment;
import br.com.lab.impacta.investment.service.InvestmentService;

@Component
public class InvestmentApplicationImpl implements InvestmentApplication {

	@Autowired
	private InvestmentService investmentService;

	@Override
	public InvestmentResponse invest(Long accountId, InvestmentRequest investmentRequest) {
		Investment investment = investmentService.invest(investmentRequest.getProductId(), accountId,
				investmentRequest.getValue());

		return InvestmentAdapter.toDtoInvestment(investment);
	}
}
