package Service²ã;


import Dao²ã.StomachDao;

public class StomachService {
	public void writerfile(String s) {
		StomachDao drug = new StomachDao();
		drug.writerfile(s);
	}
}
