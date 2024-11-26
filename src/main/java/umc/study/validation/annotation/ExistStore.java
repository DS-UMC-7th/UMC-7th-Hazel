package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.StoreExistsValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 가게 존재 여부 확인 어노테이션 정의
@Target({ElementType.FIELD, ElementType.PARAMETER}) // PARAMETER 추가
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StoreExistsValidator.class)
public @interface ExistStore {

    String message() default "존재하지 않는 가게입니다."; // 에러 메시지

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
