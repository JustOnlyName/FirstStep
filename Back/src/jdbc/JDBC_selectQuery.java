package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_selectQuery {

	// ��ȡstudent ������Ϣ   �����������
	public void testGetStudent() {
		// 1. �ȵõ���ѯ������
		int searchType = getSearchTypeFromConsole();

		// 2. �����ѯѧ����Ϣ
		Student student = searchStudent(searchType);

		// 3. ��ӡѧ����Ϣ
		printStudent(student);
	}

	/**
	 * ��ӡѧ����Ϣ����ѧ��������ڣ����ӡ������Ϣ���������ڣ���ӡ �����޴��ˡ�
	 * 
	 * @param student
	 */
	private void printStudent(Student student) {
		if (student != null) {
			System.err.println(student);
		} else {
			System.out.println("���޴���");
		}
	}

	/**
	 * �����ѯѧ����Ϣ�� ����Student �����������ڣ��򷵻�null
	 * 
	 * @param searchType
	 * @return
	 */
	private Student searchStudent(int searchType) {
		String sql = "select flowid,idcard,studentname,grade from students where ";
		Scanner scanner = new Scanner(System.in);

		// 1. ���������searchType ,��ʾ�û�������Ϣ
		// 1.1 ��searchType Ϊ1 ,��ʾ���������֤�� ��Ϊ2 ������׼��֤��
		// 2. ����searchType ȷ��SQL
		if (searchType == 1) {
			System.out.print("������flowid �� ");
			int flowid = scanner.nextInt();
			sql = sql + "flowid=" + flowid;
//			System.out.println(sql);
		} else {
			System.out.print("������idcard��");
			String idcard = scanner.next();
			sql = sql + "idcard=" + "\""+idcard+"\"";
//			System.out.println(sql);
		}

		// 3. ִ��sql
		Student student = getStudent(sql);

		// 4. �����ڲ�ѯ����������װΪStudent ����
		return student;
	}

	/**
	 * ���ݴ����SQL ����Student ����
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

			// Ӧ�þ�һ�����ݣ�if �жϼ���
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
	 * �ӿ���̨����һ��������ȷ��Ҫ��ѯ������
	 * 
	 * @return 1. flowID 2. IdCard ��������Ч����ʾ�û���������
	 */
	private int getSearchTypeFromConsole() {
		System.out.print("�������ѯ����. 1: ��FlowID ���в�ѯ   2: ��IdCard ���в�ѯ �� ");
		Scanner scanner = new Scanner(System.in);
		int type = scanner.nextInt();

		if (type != 1 && type != 2) {
			System.out.println("������������������");
			throw new RuntimeException();
		}

		return type;
	}
	
	public static void main(String[] args) {
		JDBC_selectQuery x = new JDBC_selectQuery();
		x.testGetStudent();
	}
}
