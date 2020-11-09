package exceptionerror;

public class MyException extends Exception {
	static final long serialVersionUID = 5766939L;
	
	public MyException() {
        super();
    }
	
    public MyException(String message) {
        super(message);
    }
}
