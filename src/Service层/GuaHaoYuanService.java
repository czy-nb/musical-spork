package Service��;

import java.util.ArrayList;

import Dao��.GuahaoyuanDao;
import Entity��.GuaHaoYuanInfo;


public class GuaHaoYuanService {
	public static void read() {
		GuahaoyuanDao dao = new GuahaoyuanDao();
		dao.read();
	}
	public static ArrayList<GuaHaoYuanInfo> read1() {
		GuahaoyuanDao dao = new GuahaoyuanDao();
		return dao.list;
	}
}
