package io.stephen.test.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * @author zhoushuyi
 * @since 2018/12/9
 */
@Target(FIELD)
@Retention(SOURCE)
public @interface GetSet {
}
