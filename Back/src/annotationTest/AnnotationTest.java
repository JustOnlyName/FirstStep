package annotationTest;

import java.util.ArrayList;

@MyAnnotation("hi")
@MyAnnotation("he")
public class AnnotationTest {

}

class Generic<@MyAnnotation T>{
	private void show() {
		ArrayList<@MyAnnotation String> list = new ArrayList<>();
		int num = (@ MyAnnotation int) 10L;
	}
}
