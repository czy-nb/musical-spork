package Service��;


import Dao��.StomachDao;

public class StomachService {
	public void writerfile(String s) {
		StomachDao drug = new StomachDao();
		drug.writerfile(s);
	}
}
