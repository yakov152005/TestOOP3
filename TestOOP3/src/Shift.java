public class Shift {
	private Nurse[] nurses;
	private FamilyDoctor[] familyDoctors;
	private SpecializedDoctor[] specializedDoctors;
	private Patients[] patients;

	public String[] namesOfStaffMembersWithTheMostSeniority() {
		int highSeniorityNurse = highestSeniorityNurse();
		int highSeniorityFamily = highestSeniorityFamilyDoctors();
		int highSenioritySpecialized = highestSenioritySpecializedDoctor();

		int highestSeniority = highestSeniorityBetweenAll(highSeniorityNurse, highSeniorityFamily, highSenioritySpecialized);

		int countForNurseName = 0;
		for (int i = 0; i < nurses.length; i++) {
			if (nurses[i].getSeniority() > highestSeniority) {
				countForNurseName++;
			}
		}

		int countForFamilyName = 0;
		for (int i = 0; i < familyDoctors.length; i++) {
			if (familyDoctors[i].getSeniority() > highestSeniority) {
				countForFamilyName++;
			}
		}

		int countForSpecialized = 0;
		for (int i = 0; i < specializedDoctors.length; i++) {
			if (specializedDoctors[i].getSeniority() > highestSeniority) {
				countForSpecialized++;
			}
		}

		int sizeOfArrayNames = countForNurseName + countForFamilyName + countForSpecialized;
		String[] nameWithMostSeniority = new String[sizeOfArrayNames];
		int indexForName = 0;
		for (int i = 0; i < nurses.length; i++) {
			if (nurses[i].getSeniority() > highestSeniority) {
				nameWithMostSeniority[indexForName++] = nurses[i].getName();
			}
		}

		for (int i = 0; i < familyDoctors.length; i++) {
			if (familyDoctors[i].getSeniority() > highestSeniority) {
				nameWithMostSeniority[indexForName++] = familyDoctors[i].getName();
			}
		}

		for (int i = 0; i < specializedDoctors.length; i++) {
			if (specializedDoctors[i].getSeniority() > highestSeniority) {
				nameWithMostSeniority[indexForName++] = specializedDoctors[i].getName();
			}
		}

		return nameWithMostSeniority;
	}

	public int highestSeniorityNurse() {
		int highSeniorityNurse = 0;
		for (int i = 0; i < nurses.length; i++) {
			highSeniorityNurse = nurses[i].getSeniority();
		}
		return highSeniorityNurse;
	}

	public int highestSeniorityFamilyDoctors() {
		int highSeniorityFamily = 0;
		for (int i = 0; i < familyDoctors.length; i++) {
			if (familyDoctors[i].getSeniority() > highSeniorityFamily) {
				highSeniorityFamily = familyDoctors[i].getSeniority();
			}
		}
		return highSeniorityFamily;
	}

	public int highestSenioritySpecializedDoctor() {
		int highSenioritySpecialized = 0;
		for (int i = 0; i < specializedDoctors.length; i++) {
			if (specializedDoctors[i].getSeniority() > highSenioritySpecialized) {
				highSenioritySpecialized = specializedDoctors[i].getSeniority();
			}
		}
		return highSenioritySpecialized;
	}

	public int highestSeniorityBetweenAll(int n1, int n2, int n3) {
		int highestSeniority = 0;
		if (n1 > n2 && n1 > n3) {
			highestSeniority = n1;
		} else if (n2 > n1 && n2 > n3) {
			highestSeniority = n2;
		} else {
			highestSeniority = n3;
		}
		return highestSeniority;
	}

	public boolean didAllPatientsReceiveTreatment(Patients[] patients) {

		int averagePatientsPerDayFamily = 0;
		for (int i = 0; i < familyDoctors.length; i++) {
			averagePatientsPerDayFamily += familyDoctors[i].getAveragePatientsPerDay();
		}

		int averagePatientsPerDaySpecialized = 0;
		for (int i = 0; i < specializedDoctors.length; i++) {
			averagePatientsPerDaySpecialized += specializedDoctors[i].getAveragePatientsPerDay();
		}

		int patientsLength = patients.length;

		for (int i = 0; i < patients.length; i++) {
			if (patients[i].getTypeOfTreatment() == 1) {
				patientsLength--;
			}
			if (patients[i].getTypeOfTreatment() == 2) {
				patientsLength--;
				averagePatientsPerDayFamily--;
				if (averagePatientsPerDayFamily == 0) {
					break;
				}
			}
			if (patients[i].getTypeOfTreatment() == 3) {
				patientsLength--;
				averagePatientsPerDaySpecialized--;
				if (averagePatientsPerDaySpecialized == 0) {
					break;
				}
			}
		}

		boolean res = false;
		if (patientsLength == 0){
			res = true;
		}

		return res;
	}

	public boolean allEmergencyPatientsReceivedTreatment(Patients[] patients){
		int countForPatientsWithUrgentAppointment = 0;
		for (int i = 0; i < patients.length; i++) {
			if (patients[i].isUrgentAppointment()){
				countForPatientsWithUrgentAppointment++;
			}
		}
		Patients[] temp = new Patients[countForPatientsWithUrgentAppointment];
		int index = 0;
		for (int i = 0; i < patients.length ; i++) {
			if (patients[i].isUrgentAppointment()){
				temp[index++] = patients[i];
			}
		}
		boolean res;
		res = didAllPatientsReceiveTreatment(temp);
		return res;
	}
}
