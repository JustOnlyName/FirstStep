package senior.generic.exer1;

import java.util.List;

public class DAOTest {
	public static void main(String[] args) {
		DAO<User> dao = new DAO<>();
		dao.save("1001", new User(1001,22,"Jackchou"));
		dao.save("1002", new User(1002,23,"caicaji"));
		dao.save("1003", new User(1003,24,"juju"));
		
		List<User> list = dao.list();
		System.out.println(list);
		list.forEach(System.out::println);
	}
}
