package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_select_prepared {
	
	public <T>T get(Class<T> clazz,String sql,Object ... args){
		T entity = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getDriverManagerConnection();
			preparedStatement = connection.prepareStatement(sql);
			for(int i=0;i<args.length;i++) {
				preparedStatement.setObject(i+1, args[i]);
			}
			resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				//通过反射创建对象
				entity = clazz.newInstance();
				
				//通过解析SQL 语句，判断到底选择了哪些列，以及需要为entity 对象
				//赋值
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}
		
		return entity;
	}
	
	public Student getStudent(String sql,Object ... args) {
		Student student = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getDriverManagerConnection();
			preparedStatement = connection.prepareStatement(sql);
			for(int i=0;i<args.length;i++) {
				preparedStatement.setObject(i+1, args[i]);
			}
			resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				student = new Student();
				student.setFlowId(resultSet.getInt(1));
				student.setIdCard(resultSet.getString(2));
				student.setStudentName(resultSet.getString(3));
				student.setGrade(resultSet.getInt(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}
		return student;
	}
	
	public static void main(String[] args) {
		JDBC_select_prepared x = new JDBC_select_prepared();
		String sql = "select flowid,idcard,studentname,grade from students where id=?";
		
		Student student =x.get(Student.class,sql, 1);
		System.out.println(student);
		
		sql = "select flowid,idcard,studentname,grade from students where id=? and idcard=?";
		Object a[] = {1,"hello"};
		student = x.get(Student.class, sql, a);
		System.out.println(student);
	}
}
