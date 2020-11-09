package varargs;

public class VarargsTest {
	public void show(int i ) {}
	
	public void show(String s) {
		
	}
	
	public void show(String ... strs) {
		System.out.println("show(String ... strs)");
		return ;
	}
	
//	public void show(String[] args) {
//		
//	}
	
	public void show(int i, String ... strs) {
		
	}
	
//	public void show(Sring ... args, double b) {
//		
//	}
	
	public static void main(String[] args) {
		new VarargsTest().show("world","hello","!");
	}
}
