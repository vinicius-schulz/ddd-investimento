package br.com.lab.impacta.investment.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class Investment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long productId;

	private Long accountId;

	private Double value;

	@CreationTimestamp
	private Date date;

	private boolean privateInvestment;

	public Investment() {
	}

	public Investment(Long productId, Long accountId, Double value) {
		this.productId = productId;
		this.accountId = accountId;
		this.value = value;
	}

	public boolean sufficientBalanceForInvestment(Double accountBalance) {
		return this.value < accountBalance;
	}

	public boolean verifyProductPrivateOrDefaultForInvestment(Double accountBalance, Product product) {
		if (!product.isPrivateInvestment()) {
			this.privateInvestment = false;

			return true;
		}

		if (product.isPrivateInvestment() && (accountBalance >= product.getMinimumValueForInvestment())) {
			this.privateInvestment = true;

			return true;
		}

		return false;
	}
}
