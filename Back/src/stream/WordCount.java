package stream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WordCount {
	public static void main(String[] args) throws IOException {
		//1. ����Map ����
		Map<Character, Integer> map = new HashMap();
		
		//2. ����ÿһ���ַ���ÿһ���ַ����ֵĴ����ŵ�map ��
		FileReader fr = new FileReader(new File("hello.txt"));
		int count = 0;
		while((count = fr.read()) != -1) {
			//int ��ԭ char
			char ch = (char) count;
			//�ж�char �Ƿ���map �е�һ�γ���
			if(map.get(ch) == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
		}
		
		//3. ��map �����ݴ����ļ�count.txt
		//3.1 ����Writer
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("count.txt")));
		
		//3.2 ����map ����д������
		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		for(Entry<Character, Integer> entry : entrySet) {
			switch (entry.getKey()) {
			case ' ':
				bw.write("�ո�=" + entry.getValue());
				break;
			case '\t':
				bw.write("tab ��=" + entry.getValue());
				break;
			case '\r':
				bw.write("�س�=" + entry.getValue());
				break;
			case '\n':
				bw.write("\r=" + entry.getValue());
				break;
			default :
				bw.write(entry.getKey() + "=" + entry.getValue());
				break;
			}
			bw.newLine();
		}
		
		//4. ����Դ
		bw.close();
		fr.close();
	}
}
