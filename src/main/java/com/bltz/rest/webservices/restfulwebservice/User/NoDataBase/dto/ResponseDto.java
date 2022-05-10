package com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.dto;

import java.util.Date;

public class ResponseDto<T> {
	private Integer status;
	private String shortCode;
	private Date timestamp;
	private String message;
	private String details;
	private T body;

	public ResponseDto() {
	}

	public ResponseDto<T> setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public ResponseDto<T> setShortCode(String shortCode) {
		this.shortCode = shortCode;
		return this;
	}

	public ResponseDto<T> setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public ResponseDto<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public ResponseDto<T> setDetails(String details) {
		this.details = details;
		return this;
	}

	public ResponseDto<T> setBody(T body) {
		this.body = body;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public String getShortCode() {
		return shortCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public T getBody() {
		return body;
	}
}
