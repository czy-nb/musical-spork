package Service²ã;

import Dao²ã.DiagnoseMessageDao;
import Dao²ã.StomachDao;

public class ZhenDuanInfoService {
	public void writerfile(String data) {
		DiagnoseMessageDao drug = new DiagnoseMessageDao();
		drug.writerfile(data);
	}
}
