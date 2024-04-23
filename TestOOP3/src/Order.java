public class Order {
	private int day;
	private FoodItem[] foodItems;

	public Order(int day){
		this.day = day;
		foodItems = new FoodItem[0];
	}

	public int calculateBill(){
		int totalPrice = 0;
		for (int i = 0; i < foodItems.length; i++) {
			totalPrice += foodItems[i].calculatePrice(this.day);
		}
		return totalPrice;
	}
}
