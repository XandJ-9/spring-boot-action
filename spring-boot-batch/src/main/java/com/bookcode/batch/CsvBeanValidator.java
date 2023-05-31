package com.bookcode.batch;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class CsvBeanValidator<T> implements Validator<T>, InitializingBean {

    javax.validation.Validator validator;

    @Override
    public void afterPropertiesSet() throws Exception {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @Override
    public void validate(T value) throws ValidationException {
        Set<ConstraintViolation<T>> constrainViolations = validator.validate(value);
        if (constrainViolations.size() > 0) {
            StringBuilder message = new StringBuilder();


            for (ConstraintViolation<T> constrainViolation : constrainViolations) {
                message.append(constrainViolation.getMessage() + "\n");
            }
        }
    }
}
