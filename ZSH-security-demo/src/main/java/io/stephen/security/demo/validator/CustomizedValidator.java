package io.stephen.security.demo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * 自定义注解，用于验证参数
 * @author 10447
 * @since 2017/10/30
 */
@Target({METHOD,PARAMETER,ANNOTATION_TYPE,CONSTRUCTOR,FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ParamConstraintValidator.class)
public @interface CustomizedValidator {
    String message() ;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
