package innerclass;


public class Outer {
	private int size=-1;
	public class Inner{
		private int size=2;
		public void doStuff(int size) {
			size++;   //方法内的局部变量
			System.out.println(size);
			System.out.println(this.size);   //内部类的size
			System.out.println(Outer.this.size);   //外部类的size
		}
	}
	public static void main(String[] args) {
		Outer outer=new Outer();
		Inner in = outer.new Inner();
		in.doStuff(0);
	}
}
