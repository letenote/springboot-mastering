package com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.helper.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class DateNotEmptyValidatorImpl implements ConstraintValidator<DateNotEmptyValidator, Date> {
	@Override
	public boolean isValid(final Date valueToValidate, final ConstraintValidatorContext context) {
		return valueToValidate != null;
	}
}