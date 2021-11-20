package br.com.lab.impacta.investment.handler.exception;

public class InvestmentProductDontExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6466735045461863365L;
	private String description;

	public String getDescription() {
		return description;
	}

	public InvestmentProductDontExistException() {
	}

	public InvestmentProductDontExistException(String message, String description) {
		super(message);

		this.description = description;
	}
}
