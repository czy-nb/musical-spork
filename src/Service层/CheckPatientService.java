package Service��;


import Dao��.CheckPatientDao;

public class CheckPatientService {
	public void writerfile(String s) {
		CheckPatientDao patient = new CheckPatientDao();
		patient.writerfile(s);
		}
}
