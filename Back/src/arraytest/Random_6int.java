package arraytest;

/*
 * 创建一个长度位6 的int 型数组，数组元素值1-30 ，随机，各元素不同
 */
public class Random_6int {
	public static void main(String[] args) {
		int[] arr = new int[6];
		for(int i = 0 ;i<arr.length;i++) {
			arr[i] = (int) (Math.random()*30)+1;
			for(int j = 0;j<i;j++) {
				if(arr[j]==arr[i]) {
					i--;
					break;
				}
			}
		}
		
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
	}
}
