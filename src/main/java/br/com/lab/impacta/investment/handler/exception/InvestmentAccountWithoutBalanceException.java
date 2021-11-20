package br.com.lab.impacta.investment.handler.exception;

public class InvestmentAccountWithoutBalanceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5903547629808485506L;
	private String description;

	public String getDescription() {
		return description;
	}

	public InvestmentAccountWithoutBalanceException() {
	}

	public InvestmentAccountWithoutBalanceException(String message, String description) {
		super(message);

		this.description = description;
	}
}
