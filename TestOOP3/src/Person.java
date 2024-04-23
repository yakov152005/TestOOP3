public abstract class Person {
	private String name;
	private String lastName;
	private int seniority;

	public int getSeniority() {
		return seniority;
	}

	public String getName() {
		return name;
	}

	public String toString(){
		return "Name: " + this.name +" " + this.lastName + "\nSeniority: " + this.seniority;
	}
}
