package Service²ã;

import Dao²ã.ControllerDao;

public class ControllerService {
	public void writeFile(String s) {
		ControllerDao dao = new ControllerDao();
		dao.writerfile(s);
	}
}
