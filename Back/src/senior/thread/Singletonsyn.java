package senior.thread;

public class Singletonsyn {

	private static Singletonsyn instance = null;

	private Singletonsyn() {

	}

	public static Singletonsyn getInstance() {
		if (instance == null) {
			synchronized (Singletonsyn.class) {
				if (instance == null)
					instance = new Singletonsyn();
			}
		}
		return instance;
	}
}
