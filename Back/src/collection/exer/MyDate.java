package collection.exer;

public class MyDate implements Comparable{
	private int year;
	private int month;
	private int day;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public MyDate() {
		super();
	}

	@Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof MyDate) {
			MyDate b = (MyDate) o;
			
			int minusYear = this.getYear()-b.getYear();
			if(minusYear!=0)
				return minusYear;

			int minusMonth = this.getMonth()-b.getMonth();
			if(minusMonth!=0)
				return minusYear;
			
			int minusDay = this.getDay()-b.getDay();
			if(minusDay!=0)
				return minusDay;
			
			return 0;
		}
		throw new RuntimeException();
	}
}
