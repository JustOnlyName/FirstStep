package arraytest;
import java.util.Arrays;

public class ArrayTest {
	public static void main(String[] args) {
		String s1[]= {"aa","bb","cc","dd"};
		String s2[]=new String[6];
		System.arraycopy(s1, 2, s2, 3, 2);
		for(String s:s2) {
			System.out.println(s);
		}
		removeElement(s1, 3);
//		int a[][] = new int[3][];
//		a[0] = new int[3];
//		a[1] = new int[] {1,2,3};
//		a[3] = {12,3};   报错
		
		int b[] = {1,2,3};   //不报错
		
		Object[] a1= {1001,"user1",19,"2020.1212"};
		Object[] a2= {1002,"user2",20,"2020.1212"};
		Object[] a3= {1003,"user3",21,"2020.1212"};
		
		Object [][] a=new Object[3][];
		a[0] = a1;
		a[1] = a2;
		a[2] = a2;

		for(Object [] temp:a) {
			System.out.println(Arrays.toString(temp));
		}
	}
	
	public static void  removeElement(String a[],int index) {
		System.arraycopy(a, index+1, a, index, a.length-index-1);
		a[a.length-1]=null;
		System.out.println(Arrays.toString(a));
	}
	
	//扩容，本质上是定义新大数组，将原数组拷贝到新数组
	public static String[] extendRange(String a[],int range) {
		String a2[] = new String[a.length+range];
		System.arraycopy(a, 0, a2, 0, a.length);
		return a2;
	}
}
