public class Ingredient {
	private String name;
	private int cost;
	private int unitsInStock;

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void reduceUnits(){
		this.unitsInStock--;
	}
}
