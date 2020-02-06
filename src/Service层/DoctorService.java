package Service²ã;

import java.util.ArrayList;

import Dao²ã.DoctorInfoDao;
import Dao²ã.StomachDao;
import Entity²ã.YiShengInfo;

public class DoctorService {
//	public static   ArrayList<String> list = new ArrayList<String>() ;
	public static void read() {
		DoctorInfoDao dao = new DoctorInfoDao();
		dao.read();
	}
	public static ArrayList<YiShengInfo> read1() {
		DoctorInfoDao dao = new DoctorInfoDao();
		return dao.list;
	}
	public void writerfile(String s) {
		DoctorInfoDao drug = new DoctorInfoDao();
		drug.writerfile(s);
	}
}
