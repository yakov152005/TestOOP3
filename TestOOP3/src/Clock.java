public class Clock {
	private int hour;
	private int minute;

	public Clock(int hour, int minute){
		setHour(hour);
		setMinute(minute);
	}

	public int getHour() {
		return hour;
	}
	public int getMinute(){
		return minute;
	}

	public void setHour(int hour){
		if (hour >= 0 && hour < 24){
			this.hour = hour;
		}else {
			this.hour = 0;
		}
	}
	public void setMinute(int minute) {
		if (minute >= 0 && minute <60){
			this.minute = minute;
		}else {
			this.minute = 0;
		}
	}

	public String toString(){
		String res;
		if (this.hour < 10){
			res = "0" + this.hour +":";
		}else {
			res = this.hour + ":";
		}
		if (this.minute < 10){
			res += "0" + this.minute;
		}else {
			res += this.minute;
		}
		return res;
	}

	public int timeToMidnight(){
		int timeLeftMidnight,timeHour;
		int midnight = 24;
		int timeMinute = 60;
		timeHour = midnight - this.hour;
		timeLeftMidnight = (timeHour * timeMinute) - this.minute;
		return timeLeftMidnight;
	}

	public void addMinutes(int minute){
		int timeHour = 0, timeMinute = 0;
		boolean res = true;
		while (res){
			minute -= 60;
			timeHour++;
			if (minute < 60){
				timeMinute = minute;
				res = false;
			}
		}
		this.hour += timeHour;
		this.minute += timeMinute;
		if (this.minute > 60){
			this.minute -= 60;
			this.hour++;
		}
		if (this.hour > 23){
			this.hour -= 24;
		}
	}

	public void print(boolean amPm){
		String clock;
		int timeHour;
		if(amPm){
			if (this.hour > 12){
				timeHour = this.hour - 12;
				if (timeHour < 10){
					clock = "0" + timeHour;
				}else {
					clock =timeHour +"";
				}
				clock += ":" + this.minute +" PM";
				System.out.println(clock);
			}
		}else {
			clock = toString();
			System.out.println(clock);
		}
	}
}
