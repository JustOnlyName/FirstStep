package innerclass;


public class Outer {
	private int size=-1;
	public class Inner{
		private int size=2;
		public void doStuff(int size) {
			size++;   //�����ڵľֲ�����
			System.out.println(size);
			System.out.println(this.size);   //�ڲ����size
			System.out.println(Outer.this.size);   //�ⲿ���size
		}
	}
	public static void main(String[] args) {
		Outer outer=new Outer();
		Inner in = outer.new Inner();
		in.doStuff(0);
	}
}
