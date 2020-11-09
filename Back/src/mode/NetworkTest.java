package mode;

public class NetworkTest {
	public static void main(String[] args) {
		Server server = new Server();
		ProxyServer proxyServer = new ProxyServer(server);
		proxyServer.browse();
	}
}

interface Network{
	public void browse() ;
}

//被代理类
class Server implements Network{
	@Override
	public void browse() {
		System.out.println("真实的服务器访问网络");
	}
}

//代理类
class ProxyServer implements Network{

	private Network work;
	
	public ProxyServer(Network work) {
		this.work = work;
	}
	
	public void check() {
		System.out.println("联网前的检查工作");
	}
	
	@Override
	public void browse() {
		//联网前先进行一下校验等其他工作
		check();
		
		work.browse();
	}
}