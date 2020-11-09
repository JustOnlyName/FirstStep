package senior.generic.exer1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO<T> {
	private Map<String,T> map = new HashMap<String, T>();
	
//	����T ���͵Ķ���Map ��Ա������
	public void save(String id, T entity) {
		this.map.put(id, entity);
	}
//	��map �л�ȡid ��Ӧ�Ķ���
	public T get(String id) {
		return map.get(id);
	}
//	�滻map ��key Ϊid �����ݣ���Ϊentity ����
	public void update(String id,T entity) {
		if(map.containsKey(id)) {   //�ж���û�����Ԫ�أ���Ȼput ֱ�������һ����Ԫ��
			map.put(id, entity);
		}
	}
//	����map �д�ŵ�����T ����
	public List<T> list(){
		Collection<T> values = map.values();
		ArrayList<T> list = new ArrayList<T>();
		for(T t:values) {
			list.add(t);
		}
		return list;
	}
//	ɾ��ָ��id ����
	public void delete(String id) {
		map.remove(id);
	}
}
