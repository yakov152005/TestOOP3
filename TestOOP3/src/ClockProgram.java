import java.util.Scanner;

public class ClockProgram {
	public static void main(String[] args) {
		//A
		Clock clock = new Clock(25,61);
		System.out.println(clock);

		//B
		Clock clock1 = new Clock(20,45);
		System.out.println(clock1.timeToMidnight());

		//C
		Clock clock2 = new Clock(7,17);
		clock2.addMinutes(70);
		System.out.println(clock2);
		Clock clock3 = new Clock(23,51);
		clock3.addMinutes(60);
		System.out.println(clock3);

		//D
		Clock clock4 = new Clock(14,57);
		System.out.println(clock4);
		boolean amPm = true;
		clock4.print(amPm);

		//E
		System.out.println("Enter landing time of first flight: ");
		int hour1 = s.nextInt();
		int minute1 = s.nextInt();
		Clock landingTime1 = new Clock(hour1,minute1);

		System.out.println("Enter landing time of second flight:  ");
		int hour2 = s.nextInt();
		int minute2 = s.nextInt();
		Clock landingTime2 = new Clock(hour2,minute2);

		int time1 = landingTime1.timeToMidnight();
		int time2 = landingTime2.timeToMidnight();

		if (time1 < time2){
			System.out.println("The first flight is the one that lands later " + landingTime1);
		}else {
			System.out.println("The second flight is the one that lands later " + landingTime2);
		}

	}
	public static Scanner s = new Scanner(System.in);
}
