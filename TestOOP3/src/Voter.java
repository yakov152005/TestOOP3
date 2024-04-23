import java.util.Random;

public class Voter {
	private String name;
	private String lastName;
	private int birthday;
	private int yearOfCitizenship;

	public Voter(String name, String lastName,int birthday, int yearOfCitizenship){
		this.name = name;
		this.lastName = lastName;
		this.birthday = birthday;
		this.yearOfCitizenship = yearOfCitizenship;
	}

	public String getName() {
		return name;
	}

	public String getFullName(){
		return this.name + " " + lastName;
	}

	public int citizenshipLength(int currentYear){
		return currentYear - this.yearOfCitizenship;
	}

	public boolean eligibleToVote(int currentYear){
		boolean mayVote = false;
		int countMayVote = 0;
		if (citizenshipLength(currentYear) >= 5){
			countMayVote++;
		}
		if (currentYear - this.birthday > 25){
			countMayVote++;
		}
		if (countMayVote == 2){
			mayVote = true;
		}else if (countMayVote ==1){
			if (this.name.charAt(0) == this.lastName.charAt(0)){
				int random = new Random().nextInt(1,101);
				if (random > 60){
					mayVote = true;
				}
			}
		}
		return mayVote;
	}
	public String toString(){
		return getFullName();
	}


}
