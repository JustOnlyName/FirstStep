package annotationTest;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Target;

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})

public @interface MyAnnotations {
	MyAnnotation [] value();
}
