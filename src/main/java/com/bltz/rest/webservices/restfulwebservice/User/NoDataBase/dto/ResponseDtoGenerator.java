package com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.dto;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.Date;
import java.util.Map;

public class ResponseDtoGenerator extends ResponseDto {
	private Map<String, Object> body;

	public ResponseDtoGenerator() {
		this.setTimestamp(new Date());
		this.setDetails(ServletUriComponentsBuilder.fromCurrentRequest().toUriString());
	}

	public ResponseDtoGenerator isSuccess(String message, Map<String, Object> body){
		this.body = body;
		this.setStatus(HttpStatus.OK.value());
		this.setShortCode(HttpStatus.OK.name());
		this.setMessage(message);

		return this;
	}

	public ResponseDtoGenerator isCreated(String message, Map<String, Object> body){
		this.body = body;
		this.setStatus(HttpStatus.CREATED.value());
		this.setShortCode(HttpStatus.CREATED.name());
		this.setMessage(message);

		return this;
	}

	public ResponseDtoGenerator isAccepted(String message, Map<String, Object> body){
		this.body = body;
		this.setStatus(HttpStatus.ACCEPTED.value());
		this.setShortCode(HttpStatus.ACCEPTED.name());
		this.setMessage(message);

		return this;
	}

	public Map<String, Object> getBody() {
		return body;
	}
}
