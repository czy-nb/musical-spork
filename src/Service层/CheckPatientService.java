package Service²ã;


import Dao²ã.CheckPatientDao;

public class CheckPatientService {
	public void writerfile(String s) {
		CheckPatientDao patient = new CheckPatientDao();
		patient.writerfile(s);
		}
}
