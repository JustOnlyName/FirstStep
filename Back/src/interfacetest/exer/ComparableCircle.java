package interfacetest.exer;

public class ComparableCircle extends Circle implements CompareObject {

	@Override
	public int compareTo(Object o) {
		if(this == o) {
			return 0;
		}
		if(o instanceof ComparableCircle) {
			ComparableCircle c = (ComparableCircle) o;
			return this.getRedius() > c.getRedius()? 1 : (this.getRedius() < c.getRedius() ? -1 : 0);
		}
		throw new RuntimeException("类型不一致");
	}
	
	public static void main(String[] args) {
		ComparableCircle comparableCircle1 = new ComparableCircle();
		ComparableCircle comparableCircle2 = new ComparableCircle();
		
		comparableCircle1.setRedius(1.2);
		comparableCircle2.setRedius(1.3);
		System.out.println(comparableCircle1.compareTo(comparableCircle2));
	}
}
