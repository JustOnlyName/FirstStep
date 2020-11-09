package prepare_interview;

public class PassValueReference {
	public static void main(String[] args) {
		Data data = new Data();
		data.m = 10;
		data.n = 20;
		
		System.out.println("m = "+data.m+",n = "+data.n);		
		swap(data);
		System.out.println("m = "+data.m+",n = "+data.n);
		
	}

	private static void swap(Data data) {
		int temp = data.m;
		data.m = data.n;
		data.n = temp;
	}
	
	
	
}

class Data{
	int m;
	int n;
}