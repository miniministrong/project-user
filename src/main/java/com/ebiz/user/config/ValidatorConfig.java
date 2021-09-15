package com.ebiz.user.config;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author dhl
 * @datetime 2021/8/12  19:08
 */
@Configuration
public class ValidatorConfig {

    @Bean
    public Validator validator() {
        ValidatorFactory factory =
                ((HibernateValidatorConfiguration)((HibernateValidatorConfiguration)Validation
                        .byProvider(HibernateValidator.class)
                        .configure()).
                        addProperty("hibernate.validator.fail_fast", "true")).
                        buildValidatorFactory();
        return factory.getValidator();
    }
}