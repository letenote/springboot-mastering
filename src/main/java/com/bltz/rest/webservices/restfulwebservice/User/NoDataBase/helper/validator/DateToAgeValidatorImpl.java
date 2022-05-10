package com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.helper.validator;

import java.util.Calendar;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateToAgeValidatorImpl implements ConstraintValidator<DateToAgeValidator, Date> {
	@Override
	public boolean isValid(final Date valueToValidate, final ConstraintValidatorContext context) {
		if(valueToValidate == null) return false;
		Calendar dateInCalendar = Calendar.getInstance();
		dateInCalendar.setTime(valueToValidate);

		return Calendar.getInstance().get(Calendar.YEAR) - dateInCalendar.get(Calendar.YEAR) >= 18;
	}
}
