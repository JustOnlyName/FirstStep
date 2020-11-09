package commonclass.string;


public class StringMethod_5 {

	/**
	 * ��ȡ"ab" �Ӵ��� �ַ����г��ִ���
	 * ��ʽһ�������ϱ���ʽ��û���ó��÷���
	 */
	private int substringnum(String str) {
		int i = 0, num = 0;

		char[] array = str.toCharArray();
		int length = str.length();
		while (i < length)
			while (array[i++] == 'a' && array[i] == 'b') {
				num++;
			}
		return num;
	}
	
	/**
	 * ��ȡ"ab" �Ӵ��� �ַ����г��ִ���
	 * ��ʽ����indexOf() ����
	 */
	private int substringnum(String mainStr, String subStr) {
		int i = 0, num = 0;
		if(mainStr != null && subStr != null) {
			while((i = mainStr.indexOf(subStr,i)) != -1) {
				num++;
				i += subStr.length();
				System.out.println(i);
			}
			return num;
		}else {
			return 0;			
		}
	}

	/**
	 * ���������ַ����������ͬ�Ӵ��������ֻ�ҵ�һ������ִ��Ľ��
	 * �ο� ���������    ��sub ���ʼ��С
	 */
	public int samesubstringlength(String str1, String str2) {
		String maxStr = str1.length()>=str2.length()?str1:str2;
		String minStr = str1.length()<str2.length()?str1:str2;
		int maxLen = maxStr.length(), minLen = minStr.length();
		int num = minLen;
		String str3 = null;
		boolean flag = false;

		for (; num > 0; num--) {
			for (int i = 0; i + num - 1 < minLen; i++) {
				str3 = minStr.substring(i, i + num);
				if (maxStr.contains(str3)) {
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}

		System.out.println(str3);
		return num;
	}
	
	/**
	 * ������������������ͬ�ִ�����ȡ
	 * ͨ���ַ���  xx,xx, ����ʽ����split(",") ��[] ���ء�
	 * ���ﶺ�� ָ�������ַ�����һ���� "," ��һ�����ַ����ҵ��������� "," �Ͳ�����
	 * @return ����
	 */
	public String samesubstringlength(String str1, String str2,String str) {
		String maxStr = str1.length()>=str2.length()?str1:str2;
		String minStr = str1.length()<str2.length()?str1:str2;
		int minLen = minStr.length();
		int num = minLen;
		String str3 = null, result = "";
		boolean flag = false;

		for (; num > 0; num--) {
			for (int i = 0; i + num - 1 < minLen; i++) {
				str3 = minStr.substring(i, i + num);
				if (maxStr.contains(str3)) {
					flag = true;
					result += str3+",";
				}
			}
			if (flag) {
				break;
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		String str = new StringMethod_5().samesubstringlength("abcwerthello1yuioabcdef", "cvhello1bnmabcdef"," ");
		System.out.println(str);
		
//		String str = "abkkcadkabkebfkabkskab";
//		num = new StringMethod_5().substringnum(str,"ab");
//		System.out.println(num);
	}
}
