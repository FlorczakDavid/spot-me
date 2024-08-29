package co.simplon.spotmebusiness.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = FileSizeValidator.class)
public @interface FileSize {
	String message() default "___---***(SIZE ERROR)***---___";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	long max() default 0;
}
