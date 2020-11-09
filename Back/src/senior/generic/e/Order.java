package senior.generic.e;

public class Order<T> {
	String orderName;
	int orderId;
	T orderT;

	public Order(String orderName, int orderId, T orderT) {
		this.orderName = orderName;
		this.orderId = orderId;
		this.orderT = orderT;
	}

	public Order() {
	}

	public T getOrderT() {
		return orderT;
	}

	public void setOrderT(T orderT) {
		this.orderT = orderT;
	}
	
}
