import java.util.Random;

public class VoterProgram {
	public static void main(String[] args) {
		Voter[] voters = {
				new Voter("Yakov", "BenHemo", 1995, 2015),
				new Voter("Daniel","Gino",1998,2018),
				new Voter("Itay","Lol",2005,2022),
				new Voter("ido","Know", 2006,2012),
				new Voter("Amit","Aton",2010,2010)
		};
		boolean res = voters[0].eligibleToVote(CURRENT_YEAR);
		int temp = voters[0].citizenshipLength(CURRENT_YEAR);
		System.out.println("Can a contestant vote? " + res);
		System.out.println("The years of citizenship of the voter: " + temp);

		String[] namesAllowedToVote =  namesOfAreAllowedToVote(voters);
		System.out.println("The names are allowed to vote ");
		for (String names : namesAllowedToVote){
			System.out.print(names + " ");
		}

	}
	public static final int CURRENT_YEAR = 2024;

	public static String[] namesOfAreAllowedToVote(Voter[] voters){
		String[] names;
		int counterForStrArr = 0;
		for (int i = 0; i < voters.length; i++) {
			if (voters[i].eligibleToVote(CURRENT_YEAR)){
				counterForStrArr++;
			}
		}
		names = new String[counterForStrArr];
		int indexForStrArr = 0;
		for (int i = 0; i < voters.length; i++) {
			if (voters[i].eligibleToVote(CURRENT_YEAR)){
				names[indexForStrArr++] = voters[i].getName();
			}
		}
		return names;
	}
}
