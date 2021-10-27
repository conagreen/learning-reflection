package com.github.conagreen.prac_basic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.METHOD, // method
        ElementType.TYPE    // class
})
public @interface RunTest {
}
