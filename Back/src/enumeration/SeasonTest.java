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
	//1. ����season ���������
	private final String seasonName;
	private final String seasonDesc;
	//��������֮�󣬶�����һ�������ˣ��������¸�ֵ����������Ҳ��Ҫ����ɳ���
	
	//2. ˽�л���Ĺ�����
	//�����Ĺ���������˽�л�����ô���� ������������λ�ÿ��������
	//ֻҪ����������ǾͲ�ȷ���ж��ٸ�������Ȼ�Ͳ�����ö����� ��ȷ����Ҫ��
	private Season(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;   //���������Ը�ֵ
		this.seasonDesc = seasonDesc;
	}
	
	//3. �ṩ��ǰö����Ķ������public static final �� 
	public static final Season SPRING = new Season("����","��ů����");
	public static final Season SUMMER = new Season("����","��������");
	public static final Season AUTUMN = new Season("����","�����ˬ");
	public static final Season WINTER = new Season("����","����ѩ��");

	//4. ����3 ����ʵ�Ѿ������ˣ���������������һЩ���������һЩ
	//�������� ��ȡö������������
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
	//1. ��ͷ��Ҫ�ṩ����
	SPRINT("����","��ů����"){
		@Override
		public void show() {
			System.out.println("this is spring");
		}
	},
	SUMMER("����","��������"){
		@Override
		public void show() {
			System.out.println("this is summer");
		}
	},
	AUTUMN("����","�����ˬ"){
		@Override
		public void show() {
			System.out.println("this is autumn");
		}
	},
	WINTER("����","����ѩ��"){
		@Override
		public void show() {
			System.out.println("this is winter");
		}
	};
	
	//2. ��������
	private String seasonName;
	private String seasonDesc;
	
	//3. ˽�й�����
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

	//4. ��������
	//ע�⣬����Ҫ��д toString() ����
	public String getSeasonDesc() {
		return seasonDesc;
	}

	public void setSeasonDesc(String seasonDesc) {
		this.seasonDesc = seasonDesc;
	}

}