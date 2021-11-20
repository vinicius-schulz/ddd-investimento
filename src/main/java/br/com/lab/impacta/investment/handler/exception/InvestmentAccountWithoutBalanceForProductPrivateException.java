package br.com.lab.impacta.investment.handler.exception;

public class InvestmentAccountWithoutBalanceForProductPrivateException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5334753591018970304L;
	private String description;

	public String getDescription() {
		return description;
	}

	public InvestmentAccountWithoutBalanceForProductPrivateException() {
	}

	public InvestmentAccountWithoutBalanceForProductPrivateException(String message, String description) {
		super(message);

		this.description = description;
	}
}
