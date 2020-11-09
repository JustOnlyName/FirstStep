package interfacetest.exer;

public class Ball_twoimpl implements Rollable{
	private String name;
	
	public String getName() {
		return name;
	}
	
	public Ball_twoimpl(String name) {
		this.name = name;
	}
	
	public void play() {
//		ball = new Ball("Football");
		System.out.println(ball.getName());
	}
}

interface Playable {
	
}

interface Bounceable {
	
}

interface Rollable extends Playable, Bounceable{
	Ball_twoimpl ball = new Ball_twoimpl("pingpang");
}