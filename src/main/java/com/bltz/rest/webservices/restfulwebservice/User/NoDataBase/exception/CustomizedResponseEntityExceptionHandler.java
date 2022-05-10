package com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.exception;

import com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.dto.ResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDto> handleAllExceptions(Exception ex, WebRequest request) {
		var exceptionResponse = new ResponseDto()
				.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.setShortCode(HttpStatus.INTERNAL_SERVER_ERROR.name())
				.setTimestamp(new Date())
				.setMessage(ex.getMessage())
				.setDetails(request.getDescription(false));

		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(exceptionResponse);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request
	) {
		List<String> detailResponse = new ArrayList();

		for(ObjectError error: ex.getAllErrors()){
			System.err.println("##::Validation -> "+ error.getDefaultMessage());
			detailResponse.add(error.getDefaultMessage());
		}

		var exceptionResponse = new ResponseDto()
				.setStatus(HttpStatus.BAD_REQUEST.value())
				.setShortCode(HttpStatus.BAD_REQUEST.name())
				.setTimestamp(new Date())
				.setMessage("Validation Failed")
				.setDetails(String.join(", ", detailResponse));
//				.setMessage(ex.getMessage())
//				.setDetails(ex.getBindingResult().toString());

		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(exceptionResponse);
	}

	@ExceptionHandler(ServiceNotImplementedException.class)
	public ResponseEntity<ResponseDto> handleServiceNotImplementedException(Exception ex, WebRequest request) {
		var exceptionResponse = new ResponseDto()
				.setStatus(HttpStatus.NOT_IMPLEMENTED.value())
				.setShortCode(HttpStatus.NOT_IMPLEMENTED.name())
				.setTimestamp(new Date())
				.setMessage(ex.getMessage())
				.setDetails(request.getDescription(false));

		return ResponseEntity
				.status(HttpStatus.NOT_IMPLEMENTED).
				body(exceptionResponse);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseDto> handleUserNotFoundException(Exception ex, WebRequest request) {
		var exceptionResponse = new ResponseDto()
				.setStatus(HttpStatus.NOT_FOUND.value())
				.setShortCode(HttpStatus.NOT_FOUND.name())
				.setTimestamp(new Date())
				.setMessage(ex.getMessage())
				.setDetails(request.getDescription(false));

		return ResponseEntity.
				status(HttpStatus.NOT_FOUND)
				.body(exceptionResponse);
	}
}
