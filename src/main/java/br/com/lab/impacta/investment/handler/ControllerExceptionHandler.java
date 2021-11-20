package br.com.lab.impacta.investment.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.lab.impacta.investment.handler.exception.ErrorMessageResponse;
import br.com.lab.impacta.investment.handler.exception.InvestmentAccountIsNotDebitException;
import br.com.lab.impacta.investment.handler.exception.InvestmentAccountWithoutBalanceException;
import br.com.lab.impacta.investment.handler.exception.InvestmentAccountWithoutBalanceForProductPrivateException;
import br.com.lab.impacta.investment.handler.exception.InvestmentProductDontExistException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(InvestmentProductDontExistException.class)
	public ResponseEntity<ErrorMessageResponse> errorProductDontExists(InvestmentProductDontExistException ex) {
		ErrorMessageResponse message = new ErrorMessageResponse(HttpStatus.NOT_FOUND.value(), new Date(),
				ex.getMessage(), ex.getDescription());

		return new ResponseEntity<ErrorMessageResponse>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvestmentAccountWithoutBalanceException.class)
	public ResponseEntity<ErrorMessageResponse> errorWithoutBalance(InvestmentAccountWithoutBalanceException ex) {
		ErrorMessageResponse message = new ErrorMessageResponse(HttpStatus.BAD_REQUEST.value(), new Date(),
				ex.getMessage(), ex.getDescription());

		return new ResponseEntity<ErrorMessageResponse>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvestmentAccountWithoutBalanceForProductPrivateException.class)
	public ResponseEntity<ErrorMessageResponse> errorWithoutBalanceForPrivate(
			InvestmentAccountWithoutBalanceForProductPrivateException ex) {
		ErrorMessageResponse message = new ErrorMessageResponse(HttpStatus.BAD_REQUEST.value(), new Date(),
				ex.getMessage(), ex.getDescription());

		return new ResponseEntity<ErrorMessageResponse>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvestmentAccountIsNotDebitException.class)
	public ResponseEntity<ErrorMessageResponse> errorWithoutBalanceForPrivate(InvestmentAccountIsNotDebitException ex) {
		ErrorMessageResponse message = new ErrorMessageResponse(HttpStatus.BAD_REQUEST.value(), new Date(),
				ex.getMessage(), ex.getDescription());

		return new ResponseEntity<ErrorMessageResponse>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorMessageResponse> errorGeneral(RuntimeException ex) {
		ErrorMessageResponse message = new ErrorMessageResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(),
				ex.getMessage(), "Não foi possível processar sua requisição.");

		return new ResponseEntity<ErrorMessageResponse>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
