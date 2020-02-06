package Service²ã;

import java.util.ArrayList;

import Dao²ã.GuahaoyuanDao;
import Entity²ã.GuaHaoYuanInfo;


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
