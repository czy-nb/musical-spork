package Service��;

import java.util.ArrayList;

import Dao��.OfficinaInfoDao;
import Entity��.YaoJuRenYuanInfo;



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
