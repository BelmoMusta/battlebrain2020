package musta.belmo.cody.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
public @interface ApplicationTimeFormat {
}
