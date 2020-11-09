package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_selectQuery {

	// 获取student 对象信息   程序整体搭建入口
	public void testGetStudent() {
		// 1. 先得到查询的类型
		int searchType = getSearchTypeFromConsole();

		// 2. 具体查询学生信息
		Student student = searchStudent(searchType);

		// 3. 打印学生信息
		printStudent(student);
	}

	/**
	 * 打印学生信息：若学生具体存在，则打印具体信息，若不存在，打印 ”查无此人“
	 * 
	 * @param student
	 */
	private void printStudent(Student student) {
		if (student != null) {
			System.err.println(student);
		} else {
			System.out.println("查无此人");
		}
	}

	/**
	 * 具体查询学生信息的 返回Student 对象，若不存在，则返回null
	 * 
	 * @param searchType
	 * @return
	 */
	private Student searchStudent(int searchType) {
		String sql = "select flowid,idcard,studentname,grade from students where ";
		Scanner scanner = new Scanner(System.in);

		// 1. 根据输入的searchType ,提示用户输入信息
		// 1.1 若searchType 为1 ,提示请输入身份证号 若为2 请输入准考证号
		// 2. 根绝searchType 确定SQL
		if (searchType == 1) {
			System.out.print("请输入flowid ： ");
			int flowid = scanner.nextInt();
			sql = sql + "flowid=" + flowid;
//			System.out.println(sql);
		} else {
			System.out.print("请输入idcard：");
			String idcard = scanner.next();
			sql = sql + "idcard=" + "\""+idcard+"\"";
//			System.out.println(sql);
		}

		// 3. 执行sql
		Student student = getStudent(sql);

		// 4. 若存在查询结果，将其封装为Student 对象，
		return student;
	}

	/**
	 * 根据传入的SQL 返回Student 对象
	 * 
	 * @param sql
	 * @return
	 */
	private Student getStudent(String sql) {

		Student student = null;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getDriverManagerConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			// 应该就一条数据，if 判断即可
			if (resultSet.next()) {
				student = new Student(resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getInt(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCTools.releaseDB(resultSet, statement, connection);
		}
		return student;
	}

	/**
	 * 从控制台读入一个整数，确定要查询的类型
	 * 
	 * @return 1. flowID 2. IdCard 其他的无效，提示用户重新输入
	 */
	private int getSearchTypeFromConsole() {
		System.out.print("请输入查询类型. 1: 用FlowID 进行查询   2: 用IdCard 进行查询 ： ");
		Scanner scanner = new Scanner(System.in);
		int type = scanner.nextInt();

		if (type != 1 && type != 2) {
			System.out.println("输入有误，请重新输入");
			throw new RuntimeException();
		}

		return type;
	}
	
	public static void main(String[] args) {
		JDBC_selectQuery x = new JDBC_selectQuery();
		x.testGetStudent();
	}
}
