package Service��;

import Dao��.ControllerDao;

public class ControllerService {
	public void writeFile(String s) {
		ControllerDao dao = new ControllerDao();
		dao.writerfile(s);
	}
}
