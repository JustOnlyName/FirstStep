package enumeration;

public class SeasonTest {
	public static void main(String[] args) {
		Season1.SPRINT.show();
		Season1.SUMMER.show();
	}
}

interface Info{
	void show();
}

class Season{
	//1. 声明season 对象的属性
	private final String seasonName;
	private final String seasonDesc;
	//对象造完之后，对象都是一个常量了，不能重新赋值，即其属性也需要定义成常量
	
	//2. 私有化类的构造器
	//如果类的构造器不是私有化，那么就是 在类的外边任意位置可以随意调
	//只要能任意调，那就不确定有多少个对象，显然就不符合枚举类的 “确定”要求
	private Season(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;   //给对象属性赋值
		this.seasonDesc = seasonDesc;
	}
	
	//3. 提供当前枚举类的多个对象，public static final 的 
	public static final Season SPRING = new Season("春天","春暖花开");
	public static final Season SUMMER = new Season("夏天","夏日炎炎");
	public static final Season AUTUMN = new Season("秋天","秋高气爽");
	public static final Season WINTER = new Season("冬天","冰天雪地");

	//4. 上面3 步其实已经可以了，后续就是其他的一些需求可以添一些
	//其他诉求： 获取枚举类对象的属性
	public String getSeasonName() {
		return seasonName;
	}
	
	public String getSeasonDesc() {
		return seasonDesc;
	}

	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}
}

enum Season1 implements Info{
	//1. 开头就要提供对象
	SPRINT("春天","春暖花开"){
		@Override
		public void show() {
			System.out.println("this is spring");
		}
	},
	SUMMER("夏天","夏日炎炎"){
		@Override
		public void show() {
			System.out.println("this is summer");
		}
	},
	AUTUMN("秋天","秋高气爽"){
		@Override
		public void show() {
			System.out.println("this is autumn");
		}
	},
	WINTER("冬天","冰天雪地"){
		@Override
		public void show() {
			System.out.println("this is winter");
		}
	};
	
	//2. 声明属性
	private String seasonName;
	private String seasonDesc;
	
	//3. 私有构造器
	private Season1(String seasonName, String seasonDesc){
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}

	//4. 其他诉求
	//注意，不需要重写 toString() 方法
	public String getSeasonDesc() {
		return seasonDesc;
	}

	public void setSeasonDesc(String seasonDesc) {
		this.seasonDesc = seasonDesc;
	}

}