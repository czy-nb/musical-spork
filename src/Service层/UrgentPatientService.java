package Service��;

import Dao��.UrgentPatientDao;
import Dao��.StomachDao;

public class UrgentPatientService {
	public void writerfile(String s) {
		UrgentPatientDao drug = new UrgentPatientDao ();
		drug.writerfile(s);
	}
}
