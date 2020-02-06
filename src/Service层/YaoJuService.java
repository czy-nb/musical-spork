package Service²ã;

import java.util.ArrayList;

import Dao²ã.OfficinaInfoDao;
import Entity²ã.YaoJuRenYuanInfo;



public class YaoJuService {
	public static void read() {
		OfficinaInfoDao dao = new OfficinaInfoDao();
		dao.read();
	}
	public static ArrayList<YaoJuRenYuanInfo> read1() {
		OfficinaInfoDao dao = new OfficinaInfoDao();
		return dao.list;
	}
}
