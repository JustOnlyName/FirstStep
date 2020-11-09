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
		//1. 创建Map 集合
		Map<Character, Integer> map = new HashMap();
		
		//2. 遍历每一个字符，每一个字符出现的次数放到map 中
		FileReader fr = new FileReader(new File("hello.txt"));
		int count = 0;
		while((count = fr.read()) != -1) {
			//int 还原 char
			char ch = (char) count;
			//判断char 是否在map 中第一次出现
			if(map.get(ch) == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
		}
		
		//3. 把map 中数据存在文件count.txt
		//3.1 创建Writer
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("count.txt")));
		
		//3.2 遍历map ，再写入数据
		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		for(Entry<Character, Integer> entry : entrySet) {
			switch (entry.getKey()) {
			case ' ':
				bw.write("空格=" + entry.getValue());
				break;
			case '\t':
				bw.write("tab 键=" + entry.getValue());
				break;
			case '\r':
				bw.write("回车=" + entry.getValue());
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
		
		//4. 关资源
		bw.close();
		fr.close();
	}
}
