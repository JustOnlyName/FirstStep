package commonclass.stringbufferbuilder;

public class BufferBuilderTest {
	public static void main(String[] args) {
		//��������Ч��
		long startTime = 0L;
		long endTime = 0L;
		String text = "";
		StringBuffer buffer = new StringBuffer("");
		StringBuilder builder = new StringBuilder("");
		
		startTime = System.currentTimeMillis();
		for(int i = 0;i<20000;i++) {
			buffer.append(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer time:" + (endTime - startTime));
		
		startTime = System.currentTimeMillis();
		for(int i = 0;i<20000;i++) {
			builder.append(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder time:" + (endTime - startTime));
		
		startTime = System.currentTimeMillis();
		for(int i = 0;i<20000;i++) {
			text = text + i;
		}
		endTime = System.currentTimeMillis();
		System.out.println("String time:" + (endTime - startTime));
	}
}
