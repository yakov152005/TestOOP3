public class FoodItem {
	private String name;
	private Ingredient[] ingredients;
	private int[] amountOfIngredients;

	public FoodItem(String name){
		this.name = name;
		ingredients = new Ingredient[0];
		amountOfIngredients = new int[0];
	}

	public String getName() {
		return name;
	}
	public Ingredient[] getIngredients() {
		return ingredients;
	}
	public int[] getAmountOfIngredients() {
		return amountOfIngredients;
	}

	public int calculatePrice(int day) {
		int sum = 0;
		int totalPrice = 0;
		boolean res = false;
		if (this.name.equals("pizza")) {
			for (int i = 0; i < ingredients.length; i++) {
					if (ingredients[i].getUnitsInStock() >= amountOfIngredients[i]){
						for (int j = 0; j < amountOfIngredients[i] ; j++) {
							ingredients[i].reduceUnits(); // הפחתה של אותו מרכיב באותו כמות שאני צריך
						}
						totalPrice += ingredients[i].getCost() * amountOfIngredients[i];
						res = true;
					}else {
						res = false;
						break;
					}
			}
			if (res){
				totalPrice *= day;
			}else {
				totalPrice = 0;
			}
		}
		return totalPrice;
	}

}
