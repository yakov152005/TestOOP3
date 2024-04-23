public class FamilyDoctor extends Person{
	private int averagePatientsPerDay;

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
