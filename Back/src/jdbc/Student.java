package jdbc;

public class Student {
	private int flowId;
	
	private String idCard;
	
	private String studentName;
	
	private int grade;

	public int getFlowId() {
		return flowId;
	}

	public void setFlowId(int flowId) {
		this.flowId = flowId;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Student(int flowId, String idCard, String studentName, int grade) {
		super();
		this.flowId = flowId;
		this.idCard = idCard;
		this.studentName = studentName;
		this.grade = grade;
	}

	public Student() {
		
	}

	@Override
	public String toString() {
		return "Student [flowId=" + flowId + ", idCard=" + idCard + ", studentName=" + studentName + ", grade=" + grade
				+ "]";
	}
	
	
}
