package arraytest;

/*
 * ����һ������λ6 ��int �����飬����Ԫ��ֵ1-30 ���������Ԫ�ز�ͬ
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
