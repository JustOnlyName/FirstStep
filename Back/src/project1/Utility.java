package project1;

import java.util.Scanner;

public class Utility {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * ���ڻ�ȡ�������������
	 * 
	 * @param limit ͨ���趨Ҫ��ĳ��Ȼ�ȡ����
	 * @return
	 */
	private static String readKeyBoard(int limit) {
		String line = "";

		while (scanner.hasNext()) {
			line = scanner.nextLine();
			if (line.length() < 1 || line.length() > limit) {
				System.out.print("���볤�ȣ�������\" + limit + \"���������������룺");
				continue;
			}
			break;
		}

		return line;
	}

	/**
	 * ���ڽ���˵���ѡ�񡣸÷�����ȡ���̣��û�����'1'-'4' �е������ַ� �򷽷����� ����ֵΪ�û������ַ�
	 */
	public char readMenuSelection() {
		char c = ' ';
		while (true) {
			String str = readKeyBoard(1);
			c = str.charAt(0);
			if (c != '1' && c != '2' && c != '3' && c != '4') {
				System.out.println("�������������");
			} else
				break;
		}

		return c;
	}

	/**
	 * ���������֧���������� �÷����Ӽ��̶�ȡһ��������4λ���ȵ���������������Ϊ�����ķ���ֵ��
	 */
	public static int readNumber() {
		int n = 0;
		while (true) {
			try {
				n = Integer.parseInt(readKeyBoard(4));
				break;
			} catch (NumberFormatException e) {
				System.out.println("�������������������");
			}
		}
		return n;
	}

	/**
	 * ���������֧��˵�����ַ������롣 �÷����Ӽ��̶�ȡ������8λ���ȵ��ַ�������������Ϊ�����ķ���ֵ
	 */
	public static String readString() {
		String str = readKeyBoard(8);
		return str;
	}

	/**
	 * ����ȷ��ѡ������롣�÷����Ӽ��̶�ȡ"Y"��"N",��������Ϊ�����ķ���ֵ
	 */
	public static char readConfirmSelection() {
		char c = ' ';
		while (true) {
			System.out.println("ȷ���𣿣�Y or N��");
			String str = readKeyBoard(1).toUpperCase();
			c = str.charAt(0);
			if (c != 'Y' && c != 'N') {
				System.out.println("����������������");
			} else
				break;
		}

		return c;
	}
}
