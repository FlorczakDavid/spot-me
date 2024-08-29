package co.simplon.spotmebusiness.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = SpotUnicityValidator.class)
public @interface SpotUnicity {

	String message() default "___---***(SPOT UNICITY ERROR)***---___";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}