package comparableTest;

import java.util.Arrays;

public class ComparableTest {
	public static void main(String[] args) {
		new ComparableTest().test2();
	}
	
	public void test1() {
		String arr[] = new String[] {"AA","CC","BB","MM","JJ","DD"};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public void test2() {
		Goods arr[] = new Goods[]{new Goods("lianxiangMouse",34),
				new Goods("dellMouse",43),
				new Goods("xiaomiMouse",12),
				new Goods("huaweiMouse",65)};
		Arrays.sort(arr);
		System.out.println(arr);
	}
}
