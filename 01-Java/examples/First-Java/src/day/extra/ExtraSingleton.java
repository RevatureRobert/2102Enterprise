package day.extra;

import java.lang.annotation.*;

/**
 * Meant to mark a Singleton class for the extra package
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface ExtraSingleton {
}
