package io.stephen.security.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义注解验证器，CustomizedValidator该注解, 作用在Object上
 * @author 10447
 * @since 2017/10/30
 */
public class ParamConstraintValidator implements ConstraintValidator<CustomizedValidator,Object> {



    @Override
    public void initialize(CustomizedValidator customizedValidator) {
        System.out.println("ConstraintValidator 验证初始化");

    }


    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        System.out.println("参数值为："+o);

        return "111".equals(0);
    }
}
