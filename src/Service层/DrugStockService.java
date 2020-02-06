package Service²ã;

import Dao²ã.DrugStockDao;

public class DrugStockService {
	public void writerfile(String s) {
		DrugStockDao drug = new DrugStockDao();
		drug.writerfile(s);
	}
}
