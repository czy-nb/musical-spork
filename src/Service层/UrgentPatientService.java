package Service²ã;

import Dao²ã.UrgentPatientDao;
import Dao²ã.StomachDao;

public class UrgentPatientService {
	public void writerfile(String s) {
		UrgentPatientDao drug = new UrgentPatientDao ();
		drug.writerfile(s);
	}
}
