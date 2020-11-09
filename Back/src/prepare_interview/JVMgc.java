package prepare_interview;

public class JVMgc {
	public static void main(String[] args) {
		Object aobj = new Object();
		Object bobj = new Object();
		Object cobj = new Object();
		System.out.println(aobj.toString());
		aobj = bobj;
		System.out.println(aobj == bobj);
		
	}
}
