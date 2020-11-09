package project1;

import java.util.Scanner;

public class Utility {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * 用于获取键盘输入的内容
	 * 
	 * @param limit 通过设定要求的长度获取内容
	 * @return
	 */
	private static String readKeyBoard(int limit) {
		String line = "";

		while (scanner.hasNext()) {
			line = scanner.nextLine();
			if (line.length() < 1 || line.length() > limit) {
				System.out.print("输入长度（不大于\" + limit + \"）错误，请重新输入：");
				continue;
			}
			break;
		}

		return line;
	}

	/**
	 * 用于界面菜单的选择。该方法读取键盘，用户键入'1'-'4' 中的任意字符 则方法返回 返回值为用户键入字符
	 */
	public char readMenuSelection() {
		char c = ' ';
		while (true) {
			String str = readKeyBoard(1);
			c = str.charAt(0);
			if (c != '1' && c != '2' && c != '3' && c != '4') {
				System.out.println("输入的数字有误");
			} else
				break;
		}

		return c;
	}

	/**
	 * 用于收入和支出金额的输入 该方法从键盘读取一个不超过4位长度的整数，并将其作为方法的返回值。
	 */
	public static int readNumber() {
		int n = 0;
		while (true) {
			try {
				n = Integer.parseInt(readKeyBoard(4));
				break;
			} catch (NumberFormatException e) {
				System.out.println("数字输入错误，重新输入");
			}
		}
		return n;
	}

	/**
	 * 用于收入和支出说明的字符串输入。 该方法从键盘读取不超过8位长度的字符串，并将其作为方法的返回值
	 */
	public static String readString() {
		String str = readKeyBoard(8);
		return str;
	}

	/**
	 * 用于确认选择的输入。该方法从键盘读取"Y"或"N",并将其作为方法的返回值
	 */
	public static char readConfirmSelection() {
		char c = ' ';
		while (true) {
			System.out.println("确认吗？（Y or N）");
			String str = readKeyBoard(1).toUpperCase();
			c = str.charAt(0);
			if (c != 'Y' && c != 'N') {
				System.out.println("输入有误，重新输入");
			} else
				break;
		}

		return c;
	}
}
