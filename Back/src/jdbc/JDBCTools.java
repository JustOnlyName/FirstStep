package jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Properties;


public class JDBCTools {
	
	/**
	 * 执行SQL 语句，使用PreparedStatement
	 * @param sql
	 * @param args ： 填写SQL 占位符的可变参数
	 */
	public static void update(String sql,Object ... args) {
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getDriverManagerConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			for(int i=0;i<args.length;i++) {
				preparedStatement.setObject(i+1, args[i]);
			}
			System.out.println(preparedStatement.toString());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			releaseDB(null, preparedStatement, connection);
		}
	}
	
	/**
	 * 执行SQL 语句
	 * @param sql update insert  delete 不包含select
	 */
	public static void update(String sql) {
		Connection connection =null;
		Statement statement=null;
		
		try {
			connection = getDriverManagerConnection();
		
			statement=connection.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			releaseDB(null, statement, connection);
		}
	}
	
	public static Connection getDriverManagerConnection() throws Exception {
		Properties properties = new Properties();
		InputStream in = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc/jdbc.properties");
		properties.load(in);
		String user = properties.getProperty("user");
		String driverClass = properties.getProperty("driver");
		String jdbcUrl = properties.getProperty("jdbcUrl");
		String password = properties.getProperty("password");
		Class.forName(driverClass);
		return DriverManager.getConnection(jdbcUrl,user,password);
	}
	
	public static void releaseDB(ResultSet resultSet, Statement statement, Connection connection) {
	//	ResultSet resultSet = null;

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
