package br.com.lab.impacta.investment.handler.exception;

public class InvestmentAccountIsNotDebitException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3516539921169362962L;
	private String description;

	public String getDescription() {
		return description;
	}

	public InvestmentAccountIsNotDebitException() {
	}

	public InvestmentAccountIsNotDebitException(String message, String description) {
		super(message);

		this.description = description;
	}
}
