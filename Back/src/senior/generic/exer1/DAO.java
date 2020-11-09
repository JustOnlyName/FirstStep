package senior.generic.exer1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO<T> {
	private Map<String,T> map = new HashMap<String, T>();
	
//	保存T 类型的对象到Map 成员变量中
	public void save(String id, T entity) {
		this.map.put(id, entity);
	}
//	从map 中获取id 对应的对象
	public T get(String id) {
		return map.get(id);
	}
//	替换map 中key 为id 的内容，改为entity 对象
	public void update(String id,T entity) {
		if(map.containsKey(id)) {   //判断有没有这个元素，不然put 直接添加了一个新元素
			map.put(id, entity);
		}
	}
//	返回map 中存放的所有T 对象
	public List<T> list(){
		Collection<T> values = map.values();
		ArrayList<T> list = new ArrayList<T>();
		for(T t:values) {
			list.add(t);
		}
		return list;
	}
//	删除指定id 对象
	public void delete(String id) {
		map.remove(id);
	}
}
