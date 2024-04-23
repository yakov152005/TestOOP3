public class SpecializedDoctor extends Person{
	private int averagePatientsPerDay;
	private String specialty;

	@Override
	public int getSeniority() {
		return super.getSeniority();
	}

	@Override
	public String getName() {
		return super.getName();
	}

	public int getAveragePatientsPerDay() {
		return averagePatientsPerDay;
	}
}
