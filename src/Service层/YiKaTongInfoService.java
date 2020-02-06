package Service²ã;

import Dao²ã.YiKaTongInfoDao;


public class YiKaTongInfoService {
	public void writerfile(String s) {
		YiKaTongInfoDao drug = new YiKaTongInfoDao();
		drug.writerfile(s);
	}
}
