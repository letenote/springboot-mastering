package com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.helper.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFormatValidatorImpl implements ConstraintValidator<DateFormatValidator, Date> {
//	private String dateFormat = "yyyy-MM-dd";
//	@Override
//	public boolean isValid(final Date valueToValidate, final ConstraintValidatorContext context) {
//		if(valueToValidate == null) return false;
//		DateFormat sdf = new SimpleDateFormat(this.dateFormat);
//		sdf.setLenient(false);
//		try {
//			sdf.parse(valueToValidate.toString());
//		} catch (ParseException e) {
//			return false;
//		}
//		return true;
//	}
	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		try {
			Pattern pattern = Pattern.compile("^([0-9]{4})-([0-9]{2})-([0-9]{2})$");
			Matcher matcher = pattern.matcher(value.toString());
			return matcher.matches();
		} catch (Exception e) {
			return false;
		}
	}
}