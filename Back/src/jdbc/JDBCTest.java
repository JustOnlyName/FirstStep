package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest {

	public void testPreparedStatement() {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = JDBCTools.getDriverManagerConnection();
			String sql = "INSERT INTO students(idcard,studentname,grade) VALUES(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "helloo");
			preparedStatement.setString(2, "worlddd");
			preparedStatement.setInt(3, 1);
			//注 如果不同的数据类型，最好看一看API 比如Date
//			preparedStatement.setDate(index, new java.sql.Date(new java.util.Date().getTime()));
//			System.out.println(preparedStatement.toString());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTools.releaseDB(null, preparedStatement, connection);
		}
	}
	
	public void addNewStudent2(Student student) {
		String sql = "INSERT INTO STUDENTS VALUES(?,?,?,?)";
		JDBCTools.update(sql,student.getFlowId(),student.getIdCard(),student.getStudentName(),student.getGrade());
	}
	
	public void testaddNewStudent() {
		Student student = getStudentFromConsole();
		addNewStudent2(student);
	}
	
	private Student getStudentFromConsole() {
		Scanner scanner = new Scanner(System.in);
		
		Student student = new Student();
		
		System.out.print("FlowId: ");
		student.setFlowId(scanner.nextInt());

		System.out.print("IdCard: ");
		student.setIdCard(scanner.next());
		
		System.out.print("StudentName: ");
		student.setStudentName(scanner.next());
		
		System.out.print("Grade: ");
		student.setGrade(scanner.nextInt());
		
		return student;
	}

	public void addNewStudent(Student student)  {
		String sql="INSERT INTO STUDENTS VALUES("+student.getFlowId()+",\""+student.getIdCard()+"\",\""+student.getStudentName()+"\","+student.getGrade()+")";

		JDBCTools.update(sql);
	}
	
	public static void main(String[] args) {
		JDBCTest x = new JDBCTest();
		x.testaddNewStudent();
	}
}
