package Entity²ã;

import java.util.Vector;

public class Records {
	String PatientID;
	String time;
	String doctorID;
	String memo;
	Vector<String> medicines;
	public String getPatientID() {
		return PatientID;
	}
	public String getTime() {
		return time;
	}
	public String getDoctorID() {
		return doctorID;
	}
	public String getMemo() {
		return memo;
	}
	public Vector<String> getMedicines() {
		return medicines;
	}
	public void setPatientID(String patientID) {
		PatientID = patientID;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public void setMedicines(Vector<String> medicines) {
		this.medicines = medicines;
	}
	@Override
	public String toString() {
		return PatientID+" "+time+" "+doctorID+" "+memo;
}
	public int compareTo(Records o) {
		int i = Integer.valueOf(this.PatientID);
		int j = Integer.valueOf(o.getPatientID());
		if (i>j) {
			return 1;
		}
		
		if (i==j) {
			return 0;
		}
		if (i<j) {
			return -1;
		}
		return j;
	}
}