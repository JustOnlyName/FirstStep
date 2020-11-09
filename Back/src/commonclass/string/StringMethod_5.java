package commonclass.string;


public class StringMethod_5 {

	/**
	 * 获取"ab" 子串在 字符串中出现次数
	 * 方式一：纯吃老本方式，没有用常用方法
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
	 * 获取"ab" 子串在 字符串中出现次数
	 * 方式二：indexOf() 方法
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
	 * 返回两个字符串中最大相同子串，仅针对只找到一个最大字串的结果
	 * 参考 求最大公因数    从sub 最大开始减小
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
	 * 如果有两个或多个最大相同字串，获取
	 * 通过字符串  xx,xx, 的形式进行split(",") 成[] 返回。
	 * 这里逗号 指代特殊字符，不一定是 "," 万一两个字符串找到的正好有 "," 就不好了
	 * @return 数组
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
