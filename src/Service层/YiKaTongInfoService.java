package Service��;

import Dao��.YiKaTongInfoDao;


public class YiKaTongInfoService {
	public void writerfile(String s) {
		YiKaTongInfoDao drug = new YiKaTongInfoDao();
		drug.writerfile(s);
	}
}
