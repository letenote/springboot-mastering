package com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.dto;

import java.util.Date;

public class ResponseDto {
	private Integer status;
	private String shortCode;
	private Date timestamp;
	private String message;
	private String details;

	public ResponseDto() {
	}

	public ResponseDto setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public ResponseDto setShortCode(String shortCode) {
		this.shortCode = shortCode;
		return this;
	}

	public ResponseDto setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public ResponseDto setMessage(String message) {
		this.message = message;
		return this;
	}

	public ResponseDto setDetails(String details) {
		this.details = details;
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

}
