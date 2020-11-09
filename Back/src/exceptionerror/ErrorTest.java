package exceptionerror;

public class ErrorTest {
	public static void main(String[] args) {
		try {
			Student s = new Student();
			s.regist(-1001);
			System.out.println(s);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("here");
		}
	}
}

class Student {
	private int id;

	public void regist(int id) {
		if (id > 0) {
			this.id = id;
		} else {
			try {
				throw new MyException("输入的数据非法");
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("i am ");
			}
		}
	}

	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}
}