package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.MemberExistValidator;
//import umc.study.validation.validator.StoreExistsValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER}) // PARAMETER 추가
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MemberExistValidator.class)
public @interface ExistMember {
    String message() default "존재하지 않는 유저입니다.";

    Class<?> [] groups() default {};

    Class<? extends Payload> [] payload() default {};
}