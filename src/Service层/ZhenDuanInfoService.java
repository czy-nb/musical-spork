package Service��;

import Dao��.DiagnoseMessageDao;
import Dao��.StomachDao;

public class ZhenDuanInfoService {
	public void writerfile(String data) {
		DiagnoseMessageDao drug = new DiagnoseMessageDao();
		drug.writerfile(data);
	}
}
